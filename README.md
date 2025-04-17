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

