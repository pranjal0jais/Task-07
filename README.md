# Employee Management System

A console-based Java application for managing employee records with full CRUD (Create, Read, Update, Delete) operations using JDBC and MySQL/PostgreSQL database.

## Features

- Add new employees with name, department, and salary
- View employee details by ID
- List all employees
- Update existing employee information
- Delete employees from the system
- Interactive menu-driven interface

## Technologies Used

- **Java** - Core programming language
- **JDBC** - Database connectivity
- **Lombok** - Reduces boilerplate code with annotations
- **PreparedStatement** - SQL injection prevention
- **Try-with-resources** - Automatic resource management

## Project Structure

```
├── DatabaseConfig.java          # Database connection configuration
├── Employee.java                # Employee entity/model class
├── Service.java                 # Business logic and database operations
└── EmployeeManagementSystem.java # Main application with UI
```

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL or PostgreSQL database
- Lombok library
- JDBC driver for your database (MySQL Connector or PostgreSQL JDBC)

## Database Setup

Create a database and table using the following SQL:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);
```

## Environment Variables

Set the following environment variables before running the application:

```bash
export DB_URL="jdbc:mysql://localhost:3306/employee_db"
export DB_USERNAME="your_username"
export DB_PASSWORD="your_password"
```

For PostgreSQL, use:
```bash
export DB_URL="jdbc:postgresql://localhost:5432/employee_db"
```

### Setting Environment Variables

**Windows (Command Prompt):**
```cmd
set DB_URL=jdbc:mysql://localhost:3306/employee_db
set DB_USERNAME=your_username
set DB_PASSWORD=your_password
```

**Windows (PowerShell):**
```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/employee_db"
$env:DB_USERNAME="your_username"
$env:DB_PASSWORD="your_password"
```

**Linux/Mac:**
```bash
export DB_URL="jdbc:mysql://localhost:3306/employee_db"
export DB_USERNAME="your_username"
export DB_PASSWORD="your_password"
```

## Dependencies

Add the following dependencies to your project:

**Maven:**
```xml
<dependencies>
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
        <scope>provided</scope>
    </dependency>
    
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```

**Gradle:**
```gradle
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.30'
    annotationProcessor 'org.projectlombok:lombok:1.18.30'
    implementation 'mysql:mysql-connector-java:8.0.33'
}
```

## How to Run

1. Ensure your database is running and the table is created
2. Set the environment variables for database connection
3. Compile the Java files:
   ```bash
   javac -cp ".:lombok.jar:mysql-connector.jar" *.java
   ```
4. Run the application:
   ```bash
   java -cp ".:lombok.jar:mysql-connector.jar" EmployeeManagementSystem
   ```

## Usage

Once the application starts, you'll see a menu with the following options:

```
1. Add Employee
2. Get Employee By Id
3. Get All Employees
4. Update Employee
5. Delete Employee
6. Exit
```

### Example Operations

**Adding an Employee:**
1. Select option 1
2. Enter employee name, department, and salary when prompted
3. Employee will be added to the database

**Viewing an Employee:**
1. Select option 2
2. Enter the employee ID
3. Employee details will be displayed

**Updating an Employee:**
1. Select option 4
2. Enter employee ID and new details
3. Employee information will be updated

## Code Structure

### DatabaseConfig
Manages database connection using environment variables for security.

### Employee
POJO (Plain Old Java Object) with Lombok annotations for automatic getter/setter generation and builder pattern.

### Service
Contains all database operations (DAO layer):
- `addEmployee()` - Inserts new employee record
- `getEmployeeById()` - Retrieves employee by ID
- `getAllEmployees()` - Fetches all employee records
- `updateEmployee()` - Updates existing employee
- `deleteEmployee()` - Removes employee from database

### EmployeeManagementSystem
Main class with console interface and menu system.

## Security Features

- Uses PreparedStatement to prevent SQL injection
- Database credentials stored in environment variables
- Try-with-resources ensures proper connection cleanup

## Technical Details

### Scanner Buffer Management

The application uses `sc.nextLine()` after `sc.nextInt()` in several methods to consume leftover newline characters from the input buffer. This prevents input skipping issues.

**Example:**
```java
public void addEmployee(){
    sc.nextLine();  // Consumes leftover newline from menu choice
    System.out.println("Enter Employee Name");
    String name = sc.nextLine();
    ...
}
```

### Application Flow

1. Main loop displays menu continuously
2. User enters choice (1-6)
3. Switch statement routes to appropriate method
4. Method collects input and calls Service layer
5. Service performs database operation
6. Returns to menu (unless exit is chosen)

### Proper Resource Cleanup

The Scanner is properly closed when exiting:
```java
case 6:
    sc.close();
    System.exit(0);
```

## Known Issues

- No validation for negative salaries or empty strings
- No error handling for invalid input types (e.g., entering text when number expected)

## Future Enhancements

- Add input validation
- Implement search by name or department
- Add salary range filtering
- Export employee data to CSV
- Add logging functionality
- Implement unit tests

## License

This project is open source and available for educational purposes.

## Author

Created as a demonstration of JDBC and Java console application development.
