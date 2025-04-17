### Link Frontend: [App-Booking-Ticket](https://github.com/ducminh1804/App-Booking-Ticket)

# 🎟️ Booking Ticket Backend

**A backend system for an online movie ticket booking platform, built with a clear and scalable architecture using real-world technologies. In addition to basic functionalities such as ticket booking, managing movies, showtimes, and theaters, the system implements JWT for user authentication, uses Cloudinary for media storage, and is containerized with Docker for easier deployment. The project is deployed on an AWS EC2 server.**

---

## 📑 Table of Contents

1. [🚀 Technologies Used](#-technologies-used)
2. [✨ Features](#-features)
3. [🔧 Installation & Running the Project](#-installation--running-the-project)

---

## 🚀 Technologies Used

| Technology                    | Purpose                                                                |
|-------------------------------|------------------------------------------------------------------------|
| **Java 17**                    | The main programming language                                           |
| **Spring Boot**                | The core framework used to build the backend system                     |
| **Spring Security + JWT**      | Authentication and authorization for users using JSON Web Token (JWT) |
| **Spring Data JPA (Hibernate)**| ORM for managing data in relational databases                           |
| **MySQL**                      | The main relational database                                           |
| **Cloudinary API**             | Media storage and image processing (movie posters, banners)            |
| **Docker**                     | Containerizing the application for easier deployment                   |
| **AWS EC2**                    | Deployed the backend application on Amazon EC2 cloud environment       |

---

## ✨ Features

| Feature                          | Description                                                             |
|-----------------------------------|-------------------------------------------------------------------------|
| ✅ **Authentication & Authorization** | Utilizes JWT and Spring Security for user authentication and access control |
| ✅ **Sign Up & Login**            | Allows users to create an account and log in                           |
| ✅ **CRUD Movies**                | Manage movie information (Add, Edit, Delete, View)                     |
| ✅ **CRUD Theaters**              | Manage theater information                                             |
| ✅ **CRUD Rooms**                 | Manage rooms inside the theaters (Create and configure rooms)          |
| ✅ **CRUD Showtimes**             | Manage movie showtimes, assign rooms and times                          |
| ✅ **CRUD Seats**                 | Manage seat layouts for each room (Available and booked seats)         |
| ✅ **Ticket Booking**             | Allows users to choose seats and create movie tickets                  |
| ✅ **Ticket Management**          | Track ticket history and view ticket details                           |
| ✅ **Upload Media with Cloudinary** | Manage movie, theater, and banner images using Cloudinary API          |
| ✅ **RESTful API Design**         | Follows RESTful principles for easy frontend integration and expansion |

---

## 🔧 Installation & Running the Project

### 1️⃣ Clone the Source
```bash
git clone https://github.com/ducminh1804/booking-ticket-backend.git
cd booking-ticket-backend
```
<p align="center">
    <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131533/z6474999183929_7cb7c001acd232edf39dcc87ab3cd5ae_yfqqmj.jpg" alt="Trang chủ" width="300"/>
      <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131533/z6474999266733_fb23dd296b626eb6af40e0910dde89d8_bopltq.jpg" alt="Trang chủ" width="300"/>
  <br>
  <em>Giao diện Đăng kí, Đăng nhập</em>
    <br></br>
</p>
<p align="center">
    <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131533/z6474999183948_8a6c48c5023d2ff61278bc008f28e5f4_pmohjb.jpg" alt="Trang chủ" width="300"/>
      <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131532/z6474999144978_dd1d1f8c9682a0572403c107b01d8fe5_oe8a6y.jpg" alt="Trang chủ" width="300"/>
  <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131533/z6474999266921_2db2e18b50ed0b71e4d8c7e73201aa18_ym36pu.jpg" alt="Trang chủ" width="300"/>
  <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131534/z6474999183928_e1895eac970b587acb872ec61990f609_j2axbn.jpg" alt="Trang chủ" width="300"/>
  <br>
  <em>Giao diện các màn hình chính của ứng dụng</em>
    <br></br>
</p>

<p align="center">
    <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131533/z6474999225790_35f6c4c0fb48a78f7fa8e76d6eac3fd2_bxmusn.jpg" alt="Trang chủ" width="300"/>
      <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131532/z6474999183845_3ed52dcbddf4d6d20bb24b7ffa1175e6_u1imcd.jpg" alt="Trang chủ" width="300"/>
  <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131532/z6474999104358_3968c02801eddf26c98395f365f78add_i55lfp.jpg" width="300"/>
  <br>
  <em>Giao diện màn hình chọn phim, ghế và combo</em>
    <br></br>
</p>

<p align="center">
    <img src="https://res.cloudinary.com/dpgnm1bdi/image/upload/v1744131532/z6474999144759_cc3a313868c41d2b29f6d4f119190ac2_ajtyyy.jpg" alt="Trang chủ" width="300"/>
  
  <br>
  <em>Giao diện thanh toán</em>
    <br></br>
</p>
