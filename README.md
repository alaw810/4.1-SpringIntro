# 🧩 Introduction to Spring Boot

## 📄 Description – Exercise Statement

This project is part of the IT Academy Java Back-End Bootcamp.  
It focuses on building the first REST API using **Spring Boot**, applying good practices such as layered architecture, dependency injection, and automated testing with **JUnit 5** and **Mockito**.

The exercise is divided into three levels:

1. **Level 1:** Create a basic Spring Boot API with a health check endpoint (`/health`) returning JSON.
2. **Level 2:** Build a simple in-memory user management API with endpoints for listing, creating, and retrieving users.
3. **Level 3:** Refactor the application into a three-layer architecture (Controller, Service, Repository) and add unit tests with Mockito for the service layer.

---

## 💻 Technologies Used

- **Java 21**
- **Spring Boot** (Spring Web, DevTools)
- **JUnit 5**
- **Mockito**
- **Maven**
- **Postman** (for manual testing)
- **IntelliJ IDEA** (IDE)
- **Git & GitHub**

---

## 📋 Requirements

To run this project, make sure you have:

- **Java 21**
- **Maven 3.9+**
- **An IDE** (IntelliJ IDEA recommended)
- **Postman** (optional, for testing API endpoints)

---

## 🛠️ Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/alaw810/4.1-SpringIntro.git
   ```
2. Navigate to the project directory:
   ```bash
   cd 4.1-SpringIntro
   ```
3. Open the project in IntelliJ IDEA or your preferred IDE.
4. Let Maven download the dependencies automatically.

---

## ▶️ Execution

You can run the project in two different ways:

### Option 1 – Using Maven
```bash
mvn spring-boot:run
```

### Option 2 – Using the JAR file
1. Package the project:
   ```bash
   mvn clean package
   ```
2. Execute the generated JAR:
   ```bash
   java -jar target/userapi-0.0.1-SNAPSHOT.jar
   ```

Once the application is running, open your browser or Postman and access:

- Health Check:  
  👉 [http://localhost:9000/health](http://localhost:9000/health)


---


📘 *Developed by Adrià Lorente as part of the IT Academy Java Back-End Bootcamp.*
