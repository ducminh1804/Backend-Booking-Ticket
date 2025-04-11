### Link Frontend: https://github.com/ducminh1804/App-Booking-Ticket
# 🎟️ Booking Ticket Backend

**Hệ thống backend cho nền tảng đặt vé xem phim trực tuyến, xây dựng với kiến trúc rõ ràng, dễ mở rộng và áp dụng các công nghệ thực tế. Ngoài các chức năng cơ bản như đặt vé, quản lý phim – lịch chiếu – phòng chiếu, hệ thống còn áp dụng JWT cho xác thực người dùng, sử dụng Cloudinary để lưu trữ media, và đóng gói bằng Docker để triển khai thuận tiện hơn. Dự án đã được triển khai thực tế trên máy chủ AWS EC2.**

---

## 🚀 Công Nghệ Sử Dụng

| Công nghệ                      | Mục đích                                                                 |
|-------------------------------|--------------------------------------------------------------------------|
| **Java 17**                   | Ngôn ngữ lập trình chính                                                 |
| **Spring Boot**               | Framework cốt lõi                                                        |
| **Spring Security + JWT**     | Xác thực & phân quyền người dùng                                        |
| **Spring Data JPA (Hibernate)** | ORM quản lý dữ liệu                                                     |
| **MySQL**                     | Cơ sở dữ liệu quan hệ chính                                              |
| **Cloudinary API**            | Lưu trữ và xử lý ảnh                                                     |
| **Docker**                    | Đóng gói & triển khai ứng dụng dễ dàng hơn                              |
| **AWS EC2**                   | Triển khai ứng dụng backend thực tế                                     |

---

## ✨ Tính Năng

| Tính năng                             | Mô tả                                                                 |
|--------------------------------------|----------------------------------------------------------------------|
| ✅ Xác thực & phân quyền             | Sử dụng JWT + Spring Security để xác thực & kiểm soát truy cập      |
| ✅ Đăng ký & đăng nhập               | Cho phép người dùng tạo tài khoản và đăng nhập                      |
| ✅ CRUD Phim                         | Quản lý thông tin phim: thêm, sửa, xoá, xem                         |
| ✅ CRUD Rạp chiếu                    | Quản lý rạp chiếu                                                    |
| ✅ CRUD Phòng chiếu                 | Tạo và cấu hình các phòng chiếu trong rạp                           |
| ✅ CRUD Lịch chiếu                  | Lập lịch chiếu phim, gán phòng, thời gian,...                        |
| ✅ CRUD Ghế ngồi                    | Quản lý sơ đồ ghế theo từng phòng                                    |
| ✅ Đặt vé                            | Chọn ghế và tạo vé xem phim                                          |
| ✅ Quản lý vé                        | Theo dõi lịch sử đặt vé, chi tiết vé                                 |
| ✅ Upload ảnh với Cloudinary        | Quản lý ảnh phim, rạp, banner bằng Cloudinary                       |
| ✅ Thiết kế RESTful API             | Chuẩn RESTful giúp frontend dễ tích hợp và phát triển               |

---
