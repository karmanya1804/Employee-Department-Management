# Employee and Department Management System

 ### This is a simple backend project made to manage Employee and Department records.

## Software Used:

- IntelliJ Idea CE
- JDK 11
- Spring Boot
- Mysql Database
- Postman



## To run this project:
Import project in Intellij Idea or any other IDE. Then navigate to the java file named SpringEmployeeCrudAppApplication.java : <br >

Employee-Department-Management/src/main/java/com/karmanya/springemployeecrudapp/SpringEmployeeCrudAppApplication.java <br >

Run the given file.

Then open ```localhost:8080``` in any browser or in postman.

### Various links in this project:

For Department table: <br >
```localhost:8080/api/v1/department```  : Get all department records <br >
```localhost:8080/api/v1/department/{deptId}```  : Get Department by ID <br >
```localhost:8080/api/v1/department```  : Post <br >
```localhost:8080/api/v1/department/{departmentId}?name={}``` : Update <br >
```localhost:8080/api/v1/department/{departmentId}``` : Delete <br >

For Employee table: <br >
```localhost:8080/api/v1/employee``` : Get all employee records <br >
```localhost:8080/api/v1/employee/{employeeId}``` : Get employee by Employee <br >
```localhost:8080/api/v1/employee/department/{departmentId}``` : Get employee by Department id <br >
```localhost:8080/api/v1/employee/{departmentId}``` : Post  <br >
```localhost:8080/api/v1/employee/{employeeId}?Name={}&email={}&age={}&department_id={}``` : Update <br >
```localhost:8080/api/v1/employee/{employeeId}``` : Delete Employee <br >
