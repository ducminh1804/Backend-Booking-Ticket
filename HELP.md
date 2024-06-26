# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

---------------------------------------------------------------------
AUTHEN   ==> AUTHOR
xác thực ==> phân quyền
---------------------------------------------------------------------

class JwtUltis

Tóm tắt, đoạn mã trên là một lớp `JwtUtils` trong Java, sử dụng thư viện `jjwt` để tạo và xác thực JSON Web Token (JWT). Các chức năng chính của lớp này bao gồm:

1. **Tạo JWT mới**:
    - Phương thức `generateJwtToken(Authentication authentication)` tạo ra một JWT mới từ thông tin xác thực của người dùng (`Authentication`).
    - JWT chứa các thông tin như tên người dùng (`subject`), thời gian tạo (`issuedAt`), thời gian hết hạn (`expiration`).
    - JWT được ký bằng một khóa bí mật (`jwtSecret`) và thuật toán `HS256`.

2. **Xác thực JWT**:
    - Phương thức `validateJwtToken(String authToken)` kiểm tra tính hợp lệ của một JWT.
    - Nó sử dụng khóa bí mật (`jwtSecret`) để xác thực chữ ký của JWT.
    - Nếu JWT hợp lệ, phương thức trả về `true`, ngược lại trả về `false` và ghi lỗi vào nhật ký.

3. **Lấy thông tin từ JWT**:
    - Phương thức `getUserNameFromJwtToken(String token)` giải mã JWT và trích xuất tên người dùng (`subject`) từ phần `body` của JWT.

4. **Sử dụng giá trị từ file cấu hình**:
    - Sử dụng `@Value` annotation để đọc giá trị `jwtSecret` và `jwtExpiration` từ file cấu hình.

Lớp `JwtUtils` này được sử dụng trong các ứng dụng Spring Boot để tạo và xác thực JWT cho mục đích xác thực người dùng và quản lý phiên làm việc. Nó thường được sử dụng kết hợp với Spring Security để xác thực và phân quyền cho người dùng dựa trên JWT.

-------------------------------------------------------------------------

class AuthTokenFilter

Đoạn mã này là một lớp filter `AuthTokenFilter` trong Spring Security, có chức năng xác thực người dùng bằng JSON Web Token (JWT). Dưới đây là giải thích chi tiết về các thành phần của mã:

1. **Khai báo các đối tượng cần thiết**:
    - `JwtUtils`: Lớp hỗ trợ tạo, giải mã và xác thực JWT.
    - `UserDetailsServiceImpl`: Lớp triển khai giao diện `UserDetailsService` của Spring Security, cung cấp thông tin người dùng.
    - `Logger`: Đối tượng để ghi nhật ký.

2. **Phương thức `doFilterInternal()`**:
    - Được gọi mỗi khi có một yêu cầu HTTP đến.
    - Lấy JWT từ header `Authorization` của yêu cầu bằng phương thức `parseJwt(request)`.
    - Nếu JWT tồn tại và hợp lệ (được xác thực bằng `jwtUtils.validateJwtToken(jwt)`), thì:
        - Lấy tên người dùng từ JWT bằng `jwtUtils.getUserNameFromJwtToken(jwt)`.
        - Lấy thông tin chi tiết của người dùng từ `UserDetailsService` bằng `userDetailsService.loadUserByUsername(username)`.
        - Tạo một đối tượng `UsernamePasswordAuthenticationToken` mới với thông tin người dùng và quyền của họ.
        - Đặt đối tượng xác thực vào `SecurityContextHolder` để Spring Security có thể sử dụng trong quá trình xác thực và phân quyền.
    - Nếu có bất kỳ ngoại lệ nào xảy ra, ghi lỗi vào nhật ký.
    - Chuyển tiếp yêu cầu đến filter tiếp theo trong chuỗi filter của Spring Security.

3. **Phương thức `parseJwt()`**:
    - Lấy giá trị của header `Authorization` từ yêu cầu HTTP.
    - Nếu header tồn tại và bắt đầu bằng chuỗi "Bearer " (chuẩn JWT), thì trích xuất JWT từ phần còn lại của header.
    - Trả về JWT nếu tìm thấy, ngược lại trả về `null`.

Ví dụ thực tế:

Giả sử bạn đang xây dựng một ứng dụng web với các API RESTful để quản lý người dùng và sản phẩm. Khi người dùng đăng nhập thành công, ứng dụng sẽ tạo ra một JWT và gửi lại cho người dùng. Sau đó, mỗi khi người dùng gửi yêu cầu đến máy chủ (ví dụ: lấy danh sách sản phẩm, thêm sản phẩm mới, ...), họ sẽ gửi kèm JWT này trong header `Authorization` của yêu cầu.

Lớp `AuthTokenFilter` sẽ được kích hoạt mỗi khi có yêu cầu đến máy chủ. Nó sẽ kiểm tra xem có JWT hợp lệ trong header `Authorization` hay không. Nếu có, nó sẽ xác thực JWT, lấy thông tin người dùng và đặt thông tin xác thực vào `SecurityContextHolder`. Sau đó, các filter khác trong chuỗi filter của Spring Security có thể sử dụng thông tin này để kiểm tra quyền và kiểm soát truy cập cho các tài nguyên khác nhau trong ứng dụng.

Nhờ sử dụng JWT, ứng dụng không cần lưu trữ thông tin đăng nhập trên máy chủ, giúp giảm tải cho máy chủ và dễ dàng mở rộng ứng dụng. Tuy nhiên, một nhược điểm của JWT là không thể thu hồi hoặc hủy bỏ một JWT đã được tạo ra, trừ khi nó hết hạn.


----------------------------------------------------------------------------
class AuthEntryPointJwt

Đoạn mã này là một lớp `AuthEntryPointJwt` trong Java, được sử dụng để xử lý các trường hợp khi người dùng truy cập vào tài nguyên mà không có quyền truy cập (chưa được xác thực). Lớp này triển khai giao diện `AuthenticationEntryPoint` của Spring Security.

Dưới đây là giải thích chi tiết về các thành phần của mã:

1. **Khai báo đối tượng Logger**:
    - `private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);`
    - Đối tượng `Logger` được sử dụng để ghi nhật ký lỗi hoặc thông tin liên quan đến quá trình xác thực.

2. **Phương thức `commence()`**:
    - Đây là phương thức duy nhất trong giao diện `AuthenticationEntryPoint` mà lớp `AuthEntryPointJwt` phải triển khai.
    - Phương thức này được gọi khi người dùng truy cập vào tài nguyên mà không có quyền truy cập.
    - Nó nhận ba tham số:
        - `HttpServletRequest request`: Đối tượng yêu cầu HTTP.
        - `HttpServletResponse response`: Đối tượng phản hồi HTTP.
        - `AuthenticationException authException`: Ngoại lệ xác thực được ném ra khi người dùng không được xác thực.

3. **Xử lý phản hồi cho yêu cầu không được phép**:
    - Ghi lỗi vào nhật ký với thông điệp lỗi từ `authException`.
    - Đặt kiểu nội dung của phản hồi là `application/json`.
    - Đặt trạng thái HTTP của phản hồi là `401 Unauthorized`.
    - Tạo một `Map` chứa thông tin về lỗi, bao gồm:
        - `status`: Mã trạng thái HTTP (`401`).
        - `error`: Tên lỗi (`Unauthorized`).
        - `message`: Thông điệp lỗi từ `authException`.
        - `path`: Đường dẫn của yêu cầu.
    - Sử dụng `ObjectMapper` để chuyển đổi `Map` thành JSON và ghi vào luồng đầu ra của phản hồi HTTP.

Lớp `AuthEntryPointJwt` được sử dụng trong cấu hình Spring Security để xử lý các trường hợp khi người dùng truy cập vào tài nguyên mà không có quyền truy cập. Thay vì trả về trang lỗi mặc định, lớp này sẽ trả về một phản hồi JSON chứa thông tin về lỗi xác thực, giúp dễ dàng xử lý lỗi trên phía client (ví dụ: ứng dụng web hoặc ứng dụng di động).

Ví dụ thực tế: Giả sử bạn đang xây dựng một ứng dụng web với các API RESTful để quản lý người dùng và sản phẩm. Người dùng phải được xác thực bằng JSON Web Token (JWT) để có quyền truy cập vào các tài nguyên này. Khi người dùng gửi yêu cầu đến máy chủ mà không có JWT hợp lệ hoặc không có quyền truy cập, lớp `AuthEntryPointJwt` sẽ được kích hoạt và trả về phản hồi JSON chứa thông tin về lỗi xác thực. Ứng dụng client (web hoặc di động) có thể sử dụng thông tin này để hiển thị thông báo lỗi phù hợp cho người dùng, hoặc thực hiện các hành động khác như chuyển hướng đến trang đăng nhập.


-------------------------
@Bean
SecurityFilterChain configure(HttpSecurity http) throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
.requestMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
.requestMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
.requestMatchers("/delete/**").hasAuthority("ADMIN")
.anyRequest().authenticated()
)
.formLogin(login -> login.permitAll())
.logout(logout -> logout.permitAll())
.exceptionHandling(eh -> eh.accessDeniedPage("/403"))
;

return http.build();
}



Tuân thủ quy tắc commit message conventions:


git commit -m "feat: Implement new feature"

git commit -m "fix: Resolve issue with feature"

git commit -m "docs: Update documentation"

git commit -m "refactor: Refactor code for better structure"

git commit -m "test: Add tests for new feature"


![img_1.png](img_1.png)