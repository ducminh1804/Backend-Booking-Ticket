package com.booking_ticket.backend.controller;

import com.booking_ticket.backend.Exception.NotFoundException;
import com.booking_ticket.backend.dto.*;
import com.booking_ticket.backend.entity.Movie;
import com.booking_ticket.backend.entity.Screening;
import com.booking_ticket.backend.entity.Theater;
import com.booking_ticket.backend.entity.UsernameCurrent;
import com.booking_ticket.backend.service.CloudinaryService;
import com.booking_ticket.backend.service.MovieService;
import com.booking_ticket.backend.service.TheaterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MovieService movieService;
    @Autowired
    TheaterService theaterService;
    @Autowired
    CloudinaryService cloudinaryService;

    @GetMapping("/theaters/{theaterId}/movies")
    public ResponseEntity<List<MovieDto>> getMovies(@PathVariable(value = "theaterId") Long theaterId) {
        if (!theaterService.existsTheaterId(theaterId)) {
            List<MovieDto> movies = null;
            return new ResponseEntity<List<MovieDto>>(movies, HttpStatus.NOT_FOUND);
        }
        List<MovieDto> movies = movieService
                .findByTheaterId(theaterId)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping(path = "/theaters/{theaterId}/movies", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Movie> createMovies(@PathVariable(value = "theaterId") Long theaterId,
                                              @RequestPart("movie") Movie movie,
                                              @RequestPart("image") MultipartFile file) throws IOException {
        Theater re = theaterService.findById(theaterId).orElseThrow(() -> new NotFoundException("Not found theater_id"));
        List<Theater> theaters = new ArrayList<>();
        theaters.add(re);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        movie.setTheaters(theaters);
        movie.setCreate_at(now);
        movie.setCreate_by(new UsernameCurrent().usernameCurrent);
        movie.setUrlImg(this.cloudinaryService.upLoadFile(file));

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        re.setMovies(movies);

        movieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);


    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<MovieDto> getById(@PathVariable(value = "movie_id") Long movie_id) {
        Movie movie = movieService.getById(movie_id);
        MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }


    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getAllMovie() {
        List<Movie> movieDtos = movieService.findAll();
        return new ResponseEntity<>(movieDtos, HttpStatus.OK);
    }

    @GetMapping("/screeningg/{ngay}/{thang}")
    public List<MovieReturnByScreening> getMoviesByDatee(
            @PathVariable("ngay") int ngay,
            @PathVariable("thang") int thang
    ) {
//        return movieService.getMovieByDate(ngay, thang);
        return movieService.getMovieByDate(ngay, thang);
    }

//                .map(movie -> modelMapper.map(movie, MovieDto.class))

    @GetMapping("/screening/{ngay}/{thang}")
    public ResponseEntity<List<Map<String, Object>>> getMoviesByDate(
            @PathVariable("ngay") int ngay,
            @PathVariable("thang") int thang
    ) {
        List<MovieReturnByScreening> movies = movieService.getMovieByDate(ngay, thang);

        // Group movies by movie name and map to info and time
        Map<String, Map<String, Object>> map = movies.stream()
                .collect(Collectors.groupingBy(
                        MovieReturnByScreening::getMovie_name,
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        MovieReturnByScreening::getMovie_name, // Key mapper
                                        movie -> {
                                            Map<String, Object> movieInfo = new HashMap<>();
                                            movieInfo.put("id", movie.getId());
                                            movieInfo.put("movie_name", movie.getMovie_name());
                                            movieInfo.put("category", movie.getCategory());
                                            movieInfo.put("urlImg", movie.getUrlImg());
                                            return movieInfo;
                                        },
                                        (existing, replacement) -> existing // Merge function (in case of duplicate keys)
                                ),
                                movieMap -> {
                                    Map<String, Object> result = new HashMap<>();
                                    result.put("info", movieMap.values().iterator().next()); // Get the first movie info
                                    result.put("time", movieMap.keySet().stream()
                                            .flatMap(key -> movies.stream()
                                                    .filter(movie -> movie.getMovie_name().equals(key))
                                                    .map(movie -> formatTime(movie.getStart_at())) // Use formatTime here
                                            )
                                            .collect(Collectors.toList()));
                                    return result;
                                }
                        )
                ));

        // Convert map to list
        List<Map<String, Object>> resultList = map.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("movie_name", entry.getKey());
                    resultMap.putAll(entry.getValue());
                    return resultMap;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/screening/{ngay}/{thang}/{movie_id}")
    public ResponseEntity<Map<String, Object>> getMoviesByDate(
            @PathVariable("ngay") int ngay,
            @PathVariable("thang") int thang,
            @PathVariable("movie_id") Long movie_id
    ) {
        List<MovieReturnByScreening> movies = movieService.findMoviesByDateMovieId(ngay, thang, movie_id);

        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Assuming the query returns only one movie
        MovieReturnByScreening movie = movies.get(0);

        Map<String, Object> info = new HashMap<>();
        info.put("id", movie.getId());
        info.put("movie_name", movie.getMovie_name());
        info.put("category", movie.getCategory());
        info.put("urlImg", movie.getUrlImg());

        Map<String, Object> response = new HashMap<>();
        response.put("info", info);
        response.put("time", movies.stream()
                .map(m -> formatTime(m.getStart_at()))
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }


    public String formatTime(Time time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time);
    }

}
