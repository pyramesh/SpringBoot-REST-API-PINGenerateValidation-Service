Application Name : PINGenerateVerifyService

Technologies used
-----------------------
Spring Boot
Spring REST API
Hibernate/JPA
Spring Data Repository
Swagger
Spring Junit

Non- functional
----------------
Logging
Spring Transaction Management

Application port
-----------------
port : 9999

Package Structure
--------------------

src/main/java
---------------
com.ramesh.controller --> Controller
com.ramesh.service --> Service Layer classes
com.ramesh.repository --> Repository classes
com.ramesh.config --> content negotiation,to produce output based on the requested format.
com.ramesh.domain --> JPA Entity classes
com.ramesh.swagger--> Swagger API classes
com.ramesh.utils --> Random Number generator logic

src/test/java
-------------
com.ramesh.controller -> test cases

