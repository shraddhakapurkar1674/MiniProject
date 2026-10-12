# Inventory Management System (IMS)

A RESTful Inventory Management System built using Java and Spring Boot to manage product information, perform CRUD operations, track stock quantities, and identify low-stock products. The application provides REST APIs for inventory operations and uses MySQL for data storage.

## 🚀 Features

- Product Management: Create, retrieve, update, and delete products.
- Stock Management: Update product stock quantities using a PATCH endpoint.
- Category Search: Retrieve products by category.
- Low-Stock Monitoring: Identify products whose stock falls below a specified threshold.
- REST API Development: Expose inventory operations through HTTP endpoints.
- Input Validation: Validate incoming data using Spring Validation.
- Database Integration: Store and manage product data in MySQL.
- API Documentation: Explore and test endpoints using Swagger UI.
- Exception Handling: Handle invalid requests and application errors appropriately.

## 🛠️ Technologies Used

- Language: Java 17
- Framework: Spring Boot 3.5.4
- Web: Spring Web, REST APIs
- Database Access: Spring Data JDBC
- Database: MySQL
- Validation: Spring Boot Validation
- API Documentation: Springdoc OpenAPI / Swagger UI
- Build Tool: Maven
- IDE: Spring Tool Suite (STS)
- Testing: JUnit and Spring Boot testing support
- Version Control: Git and GitHub

## 🏗️ Project Architecture

The application follows a layered backend architecture:


IMSProject
    |
    v
Controller Layer
    |
    v
Service Layer
    |
    v
Database Access Layer
    |
    v
MySQL Database
```

- **Controller:** Handles HTTP requests and returns API responses.
- **Service:** Contains inventory business logic.
- **Database Access:** Executes database operations using Spring Data JDBC.
- **MySQL:** Stores product information.

## 📡 REST API Endpoints

The following endpoints are provided for product management.

| HTTP Method | Endpoint | Purpose |
|---|---|---|
| POST | `/product/save` | Add a product |
| GET | `/product/getAll` | Retrieve all products |
| GET | `/product/getById/{id}` | Retrieve a product by ID |
| PUT | `/product/update/{id}` | Update product information |
| PATCH | `/product/{id}/stock` | Update product stock |
| DELETE | `/product/delete/{id}` | Delete a product |
| GET | `/product/category/{category}` | Search products by category |
| GET | `/product/low-stock` | Retrieve low-stock products |

**Note:** Confirm the endpoint paths and supported request parameters against your current controller code.

## ⚙️ Getting Started

### Prerequisites

Install the following:

- JDK 17
- MySQL Server
- Spring Tool Suite or another Java IDE
- Maven (if not using the included Maven wrapper)

### 1. Clone the Repository

bash
git clone https://github.com/shraddhakapurkar1674/MiniProject.git


Navigate to the application folder:

bash
cd MiniProject/IMSProject


### 2. Create the Database

Open MySQL and create a database:

sql
CREATE DATABASE ims_db;


Make sure the required product table is created according to your application's model and SQL configuration.

### 3. Configure Database Connectivity

Open `src/main/resources/application.properties` and configure your MySQL connection.

Example:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/ims_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD


Replace the example database name and credentials with the values required by your project. Keep your actual database password private.

### 4. Run the Application

Open the `IMSProject` folder in Spring Tool Suite.

1. Update the Maven project dependencies.
2. Confirm that JDK 17 is configured.
3. Ensure MySQL is running.
4. Run `ImsProjectApplication.java` as a Spring Boot application.

The application is configured to use port `8080` by default, unless changed in your properties.

### 5. Test the REST APIs

Use Postman or another API client to send HTTP requests to the running application.

Example:
GET http://localhost:8080/product/getAll


Use the appropriate HTTP method, request body, and parameters for each endpoint.

### 6. Explore Swagger UI

After starting the application, open:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Swagger UI lets you inspect and test the documented API endpoints.

## 💡 What I Learned

- Designing RESTful APIs using Spring Boot.
- Implementing CRUD operations.
- Connecting a Java application to MySQL using Spring Data JDBC.
- Handling HTTP methods and request parameters.
- Validating input data.
- Managing stock quantities and low-stock conditions.
- Documenting and testing REST APIs with Swagger UI.
- Organizing backend code into layers.

## 👩‍💻 Author

Shraddha Kapurkar

GitHub: [shraddhakapurkar1674](https://github.com/shraddhakapurkar1674)
