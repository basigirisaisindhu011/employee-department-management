# 👨‍💼 Employee & Department Management System

A RESTful Spring Boot application for managing Departments and Employees. This project demonstrates CRUD operations, layered architecture, DTO pattern, exception handling, and One-to-Many entity relationships using Spring Boot, Spring Data JPA, Hibernate, and MySQL.

---

## 🚀 Features

### Department Management
- Create Department
- Get Department by ID
- Get All Departments
- Update Department
- Delete Department

### Employee Management
- Add Employee to a Department
- Get Employee by ID
- Get All Employees in a Department
- Update Employee Details
- Delete Employee

### Additional Features
- RESTful APIs
- DTO Pattern
- Global Exception Handling
- Layered Architecture
- One-to-Many Relationship Mapping
- MySQL Database Integration

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

---

## 📂 Project Structure

```text
src/main/java/com/project/employee_management

├── controller
│   ├── DepartmentController
│   └── EmployeeController
│
├── dto
│   ├── DepartmentDto
│   └── EmployeeDto
│
├── entity
│   ├── Department
│   └── Employee
│
├── exception
│   ├── ResourceNotFoundException
│   ├── BadRequestException
│   └── GlobalExceptionHandler
│
├── repository
│   ├── DepartmentRepo
│   └── EmployeeRepo
│
├── service
│   ├── DepartmentService
│   ├── EmployeeService
│   └── impl
│       ├── DepartmentServiceImpl
│       └── EmployeeServiceImpl
│
└── EmployeeManagementApplication
```

---

## 🔗 Entity Relationship

```text
Department (1) ---------> (Many) Employees
```

- One Department can have multiple Employees.
- Each Employee belongs to one Department.
- Employees are managed through nested REST APIs.

---

## 📌 Department API Endpoints

### Create Department

```http
POST /api/departments
```

Request Body

```json
{
  "departmentName": "Information Technology",
  "departmentDescription": "Handles software development"
}
```

---

### Get Department By ID

```http
GET /api/departments/{id}
```

---

### Get All Departments

```http
GET /api/departments
```

---

### Update Department

```http
PUT /api/departments/{id}
```

---

### Delete Department

```http
DELETE /api/departments/{id}
```

---

## 📌 Employee API Endpoints

### Add Employee To Department

```http
POST /api/departments/{departmentId}/employees
```

Request Body

```json
{
  "firstName": "Harish",
  "lastName": "Kumar",
  "email": "harish@example.com"
}
```

---

### Get Employee By ID

```http
GET /api/departments/{departmentId}/employees/{id}
```

---

### Get All Employees In Department

```http
GET /api/departments/{departmentId}/employees
```

---

### Update Employee

```http
PUT /api/departments/{departmentId}/employees/{id}
```

---

### Delete Employee

```http
DELETE /api/departments/{departmentId}/employees/{employeeId}
```

---

## ⚠️ Exception Handling

Custom exception handling is implemented using:

- ResourceNotFoundException
- BadRequestException
- GlobalExceptionHandler

Common scenarios handled:

- Department not found
- Employee not found
- Invalid request data

---

## 📸 API Screenshots

Stored my Postman screenshots in:

```text
screenshots/
```

Recommended screenshots:

```text
create-department.png
get-department.png
get-all-departments.png
update-department.png
delete-department.png

create-employee.png
get-employee.png
get-all-employees.png
update-employee.png
delete-employee.png
```

Example:

```markdown
### Create Department
![Create Department](screenshots/create-department.png)

### Create Employee
![Create Employee](screenshots/create-employee.png)
```

---

## ▶️ Running the Application

### Clone Repository

```bash
git clone https://github.com/your-username/employee-management.git
```

### Navigate to Project

```bash
cd employee-management
```

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

### Run Application

```bash
mvn spring-boot:run
```

Application runs at:

```text
http://localhost:8080
```

---

## 🎯 Learning Outcomes

This project demonstrates:

- Spring Boot REST API Development
- CRUD Operations
- Layered Architecture
- DTO Pattern
- One-to-Many Relationships
- Exception Handling
- JPA/Hibernate ORM
- MySQL Integration
- Clean Code Practices

---

## 🔮 Future Enhancements

- JWT Authentication & Authorization
- Role-Based Access Control
- Swagger/OpenAPI Documentation
- Docker Support
- Unit & Integration Testing
- Pagination & Sorting
- Search & Filtering APIs

---

## 👨‍💻 Author

**Sindhu**

Java | Spring Boot | Backend Developer

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
