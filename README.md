# Student CRUD API

REST API for managing students, built with Spring Boot, Spring Data JPA and MySQL.

## Features
- Create, read, update and delete students
- Soft delete (record stays in DB, hidden from reads)
- Proper status codes (201, 200, 404)

## Tech
Java, Spring Boot, Spring Data JPA, MySQL, Postman (testing)

## Endpoints
Base URL: `/api/student`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/create` | Create a student (JSON body) |
| GET | `/get?id=1` | Get one student |
| GET | `/getAll` | Get all active students |
| PUT | `/update?id=1` | Update a student (JSON body) |
| PATCH | `/delete-soft?id=1` | Soft delete |
| DELETE | `/delete?id=1` | Permanent delete |

## Sample body
```json
{
  "name": "vanshika",
  "email": "vanshika@gmail.com",
  "age": 18,
  "rollno": 2,
  "subject": "springboot"
}
```

## Run locally
1. Create a MySQL database: `student_crud_db`
2. Copy `application.properties.example` to `application.properties` and fill in your DB username and password
3. Run `CrudSpringbootDemoApplication`
4. API runs on `http://localhost:8080`