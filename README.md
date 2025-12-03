# Spring Boot + MongoDB + Docker (Product API)

A modern **Product Management REST API** built with:

- **Spring Boot**
- **MongoDB**
- **Docker**
- **Docker Compose**

This project exposes a fully functional backend with CRUD operations, search, category filtering, and discounts — all running inside containers.


----------------------------

## Features

- Create, read, update, delete (CRUD) products  
- Search products by name  
- Filter products by category  
- Discount calculation (percentage-based)  
- MongoDB for scalable NoSQL storage  
- Fully containerized with Docker  
- `docker-compose` for running app + database with one command  
- Environment-variable support for production
  

----------------------------

## Project Structure

spring-docker-app/
├── src/
│ ├── main/java/com/example/spring-docker-app/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ └── service/
│ └── resources/
│ └── application.yml
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md


-------------------------------

## Technologies Used

| Technology | Purpose |
|-----------|---------|
| **Spring Boot** | REST API Framework |
| **MongoDB** | NoSQL Database |
| **Docker** | Containerization |
| **Docker Compose** | Multi-container setup |
| **Java 17** | Language |
| **Maven** | Build Tool |


-------------------------------

## API Endpoints

### **Product Controller → `/api/products`**

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/products` | Get all products |
| `GET` | `/api/products/{id}` | Get product by ID |
| `POST` | `/api/products` | Create a new product |
| `PUT` | `/api/products/{id}` | Update product |
| `DELETE` | `/api/products/{id}` | Delete product |
| `GET` | `/api/products/search?q=text` | Search products by name |
| `GET` | `/api/products/category/{cat}` | Filter by category |


--------------------------------

## Example Product JSON

```json
{
  "code": "P001",
  "name": "Chocolate Bar",
  "description": "Dark chocolate 70%",
  "price": 5.0,
  "quantity": 100,
  "category": "Sweets",
  "discountPercent": 10
}


-------------------------------

Run with Docker Compose

-Make sure Docker Desktop is running, then inside the project root run: -> docker-compose up --build

This starts:
-mongo → MongoDB database
-app → Spring Boot app


Access the API: -> http://localhost:8080/api/products

-------------------------------

**Build Docker Image Manually (optional)

docker build -t spring-docker-app .
docker run -p 8080:8080 spring-docker-app



**Run Locally (without Docker)

mvn spring-boot:run


You need local MongoDB running at:-> mongodb://localhost:27017/productsdb


Environment Variables

Variable	                        Description	                                  Default
SPRING_DATA_MONGODB_URI	          MongoDB connection string	                    mongodb://localhost:27017/productsdb


Example (Docker Compose already uses this):
SPRING_DATA_MONGODB_URI: mongodb://mongo:27017/productsdb


---------------------------------------

Author

Aisha
Spring Boot • Docker • MongoDB Developer






 





