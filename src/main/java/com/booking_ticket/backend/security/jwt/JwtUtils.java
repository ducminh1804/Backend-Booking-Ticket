package com.booking_ticket.backend.security.jwt;

import com.booking_ticket.backend.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import java.security.Key;
import java.util.Date;

//tao va xac thuc token
//1Tạo JWT mới:
//
//Phương thức generateJwtToken(Authentication authentication) tạo ra một JWT mới từ thông tin xác thực của người dùng (Authentication).
//JWT chứa các thông tin như tên người dùng (subject), thời gian tạo (issuedAt), thời gian hết hạn (expiration).
//JWT được ký bằng một khóa bí mật (jwtSecret) và thuật toán HS256.
//
//
//Xác thực JWT:
//
//Phương thức validateJwtToken(String authToken) kiểm tra tính hợp lệ của một JWT.
//Nó sử dụng khóa bí mật (jwtSecret) để xác thực chữ ký của JWT.
//Nếu JWT hợp lệ, phương thức trả về true, ngược lại trả về false và ghi lỗi vào nhật ký.
//
//
//Lấy thông tin từ JWT:
//
//Phương thức getUserNameFromJwtToken(String token) giải mã JWT và trích xuất tên người dùng (subject) từ phần body của JWT.
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;  // Thời gian hết hạn được lưu dưới dạng chuỗi

    public String generateJwtToken(Authentication authentication) {
        // Lấy đối tượng UserDetailsImpl từ thông tin xác thực
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        // Chuyển đổi jwtExpiration từ String sang long
        long expirationTime = Long.parseLong(jwtExpiration);

        // Xây dựng và trả về JWT token
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())  // Thiết lập thông tin người dùng (username) cho token
                .setIssuedAt(new Date())  // Thiết lập thời điểm phát hành token (hiện tại)
                .setExpiration(new Date((new Date()).getTime() + expirationTime))  // Thiết lập thời điểm hết hạn của token
                .signWith(key(), SignatureAlgorithm.HS256)  // Ký token với khóa bí mật và thuật toán HS256
                .compact();  // Hoàn thiện và chuyển token sang dạng chuỗi
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
