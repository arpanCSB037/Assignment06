# Student Registry — JSP & Servlet

**Web Technology Lab | Assignment 06**

A web-based Student Registration and Record Management System developed using **JSP, Java Servlets, JDBC, and MySQL**.

The application allows users to register student details, store them in a MySQL database, and view the registered student records through a web interface.

---

## 1. Technologies Used

| Technology | Purpose |
|---|---|
| HTML | Web page structure |
| CSS | User interface styling |
| JSP | Dynamic web pages |
| Java Servlets | HTTP request handling and application logic |
| JDBC | Java-to-database connectivity |
| MySQL | Database management |
| Apache Tomcat 10.1 | Servlet container and web server |
| Apache Maven | Dependency management and WAR packaging |
| MySQL Connector/J | MySQL JDBC driver |
| Visual Studio Code | Development environment |

## 2. Features

- Register students through a web form.
- Store student information in a MySQL database.
- Validate submitted student details on the server.
- Handle duplicate roll numbers.
- Retrieve all registered student records.
- Display student details in a tabular directory.
- Responsive interface with custom CSS styling.

## 3. Project Structure

```text
Assignment06/
├── README.md
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── webtech/
        │           ├── DBConnection.java
        │           ├── Student.java
        │           └── StudentServlet.java
        └── webapp/
            ├── index.jsp
            ├── result.jsp
            ├── students.jsp
            └── css/
                └── style.css
```

## 4. Database Setup

The application uses a MySQL database named `5thSemWebTechLab` and a student table named `2024CSB037`.

Create the database:

```sql
CREATE DATABASE `5thSemWebTechLab`;
USE `5thSemWebTechLab`;
```

Create the student table:

```sql
CREATE TABLE `2024CSB037` (
    rollno VARCHAR(15) PRIMARY KEY,
    name VARCHAR(50),
    gender VARCHAR(10),
    department VARCHAR(20),
    CGPA DECIMAL(4,2)
);
```

### Database configuration

| Property | Value |
|---|---|
| Database | `5thSemWebTechLab` |
| Table | `2024CSB037` |
| Host | `localhost` |
| Port | `3306` |
| Username | `root` |

Update the username and password in `DBConnection.java` to match your local MySQL configuration.

> **Important:** Do not commit real database passwords or other credentials to a public repository.

## 5. Requirements

Install the following software:

- Java JDK 17 or later
- Apache Maven
- Apache Tomcat 10.1
- MySQL Server

The project uses the Jakarta Servlet API, so it is intended for a Jakarta-compatible servlet container such as Tomcat 10.1.

## 6. How to Run the Project

### Step 1 — Configure MySQL

1. Start the MySQL server.
2. Create the `5thSemWebTechLab` database and the `2024CSB037` table using the SQL commands above.
3. Update the database credentials in `DBConnection.java`.

### Step 2 — Open the project

Open the `Assignment06` folder in Visual Studio Code or another Java IDE.

### Step 3 — Build the application

Open a terminal in the project directory and run:

```bash
mvn clean package
```

After a successful build, Maven generates the WAR file:

```text
target/Assignment06.war
```

### Step 4 — Deploy on Apache Tomcat

1. Copy `target/Assignment06.war` into the Tomcat `webapps` directory.
2. Start the Tomcat server.
3. Wait for Tomcat to deploy the application.

### Step 5 — Open the application

Visit:

```text
http://localhost:8080/Assignment06/
```

## 7. Application Workflow

1. The user opens the registration page (`index.jsp`).
2. The user enters student details and submits the form using HTTP POST.
3. `StudentServlet` receives and processes the request.
4. `DBConnection` establishes a connection to MySQL.
5. JDBC uses a `PreparedStatement` to insert the student record.
6. The registration outcome is displayed through `result.jsp`.
7. The user can open the student directory.
8. `StudentServlet` handles the HTTP GET request, retrieves student records, and forwards them to `students.jsp` for display.

## 8. Learning Outcomes

This assignment provides practical experience with:

- JavaServer Pages (JSP).
- Java Servlets and HTTP GET/POST request handling.
- JDBC database connectivity.
- MySQL database creation and manipulation.
- PreparedStatement and parameterized SQL queries.
- Maven dependency management and WAR packaging.
- Deploying a Java web application on Apache Tomcat.

---

**Course:** Web Technology Lab  
**Assignment:** 06  
**Project:** Student Registry — JSP & Servlet
