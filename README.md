# <span style="vertical-align: sub"><img src="src/main/resources/img/knowledge-app.png"></span> Knowledge Application <span style="vertical-align: sub"><img src="src/main/resources/img/knowledge-app.png"></span>

### <span style="vertical-align: middle"><img src="src/main/resources/img/info.png"></span> Project description:

This app is a simple implementation of a knowledge library, created using Spring and Hibernate frameworks, SQL database, REST principles and supports CRUD operations.
All data is displayed to user in JSON format.

### <span style="vertical-align: middle"><img src="src/main/resources/img/features.png"></span> Features:

This application uses database to store information about knowledge packages and knowledge package sets.
Each knowledge pack can be included in several knowledge pack sets
Each knowledge pack set can contain several knowledge packs

- create knowledge pack/knowledge pack set
- get list of knowledge packs/knowledge pack sets
- get knowledge pack/knowledge pack set by id
- remove knowledge pack/knowledge pack set by id

### <span style="vertical-align: middle"><img src="src/main/resources/img/structure.png"></span> Structure:

1. `main.java` package folders:

    - `config` - contains configuration classes
    - `controller` - contains presentation layer's classes
    - `dao` - contains DAO layer's interfaces and classes
    - `dto` - contains models' request and response DTOs
    - `exception` - contains custom exceptions
    - `model` - contains models of knowledge pack and knowledge pack set
    - `service` - contains business logic layer's interfaces/classes and DTO mappers

2. `resources` package:
    - properties for connecting to database and creating/managing required schema and tables
    - icons for `README.md`

### <span style="vertical-align: middle"><img src="src/main/resources/img/endpoints.png"></span> List of endpoints:

- `POST`: /kpacs - add knowledge package
- `GET`: /kpacs - get all knowledge packages
- `GET`: /kpacs/{id} - get knowledge package by id
- `DELETE`: /kpacs/{id} - delete knowledge package by id
- `POST`: /sets - add knowledge package set
- `GET`: /sets - get all knowledge package sets
- `GET`: /sets/{id} - get knowledge package set by id
- `DELETE`: /sets/{id} - delete knowledge package set by id

### <span style="vertical-align: middle"><img src="src/main/resources/img/tech.png"></span> Technologies:

- `Spring`
- `Hibernate`
- `Maven`
- `JPA`
- `REST`
- `MySQL`
- `Tomcat`

### <span style="vertical-align: middle"><img src="src/main/resources/img/config.png"></span> Instructions to run the project

- Install IDE to your PC
- Clone the project to your IDE (e.g. IntelliJ IDEA)
- Install MySQL to your PC and create new MySQL connection
- Change parameters in `db.properties`: `db.user`, `db.password` for yours (they should match `username` and `password` from your MySQL connection)
- Download Tomcat and add configuration in your IDE (for this project `v9.0.50` was used)
- Run project with Tomcat
- Use `Postman` and send GET/POST/PUT/DELETE requests

POST request example using Postman:
```
http://localhost:8080/kpacs - URL
{"title":"your title", "description":"your description"} - body;
```
