# Digital School Catalog (Catalog Digital)

A modern, Spring Boot-powered management system for educational institutions. This application provides a robust backend for managing students, academic subjects, and student performance through a centralized digital gradebook.

## 🚀 Overview

This project serves as a comprehensive "Digital Catalog" where teachers can:
- **Manage Students:** Keep track of student records (first name, last name, and unique school email).
- **Subject Administration:** Define academic subjects (e.g., Mathematics, Computer Science).
- **Grade Management:** Assign grades (1-10) to students for specific subjects with automatic timestamping.
- **Academic Monitoring:** View a full history of a student's grades across different subjects.

## 🛠️ Technical Stack

- **Java 21:** Utilizing the latest language features and performance improvements.
- **Spring Boot 3.2.2:** For rapid development and production-ready application context.
- **Spring Data JPA:** For seamless Object-Relational Mapping (ORM) and database interaction.
- **H2 Database:** An in-memory database used for development and testing (zero configuration required).
- **Lombok:** To reduce boilerplate code (Getters, Setters, Constructors).
- **VAnilla HTML5/CSS3/JS:** A clean, responsive teacher interface for real-time interaction.

## 📂 Project Structure

- `org.example.model`: JPA entities defining the database schema.
- `org.example.repository`: Data access layer using Spring Data JPA repositories.
- `org.example.service`: Business logic layer handling data processing and validation.
- `org.example.controller`: REST API endpoints for frontend-backend communication.
- `org.example.config`: Configuration classes (e.g., `DataLoader` for seeding the database).

## 🚦 Getting Started

### Prerequisites
- JDK 21 or higher
- Maven 3.8+

### Installation & Execution
1. Clone the repository or extract the archive.
2. Navigate to the project root directory.
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Access the teacher interface:
   - **Frontend:** [http://localhost:8080](http://localhost:8080)
   - **H2 Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: `jdbc:h2:mem:catalogdb`, User: `sa`, Password: `[empty]`)

## 🔗 API Documentation (REST Endpoints)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/students` | Retrieve a list of all students. |
| **POST** | `/api/students` | Register a new student (JSON body). |
| **GET** | `/api/students/{id}/grades` | Get all grades for a specific student. |
| **POST** | `/api/grades` | Assign a grade (Params: `studentId`, `subjectId`, `value`). |
| **POST** | `/api/subjects` | Add a new subject (Param: `name`). |

## 🧪 Testing

The project includes unit tests for core business logic. You can execute them using:
```bash
mvn test
```

---
*Developed as part of the University Portfolio.*
