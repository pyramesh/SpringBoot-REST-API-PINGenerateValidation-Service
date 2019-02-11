
-- 1.  database schema creation 

CREATE DATABASE `userpin_db`;

-- 2.table creation 

-- This step is not required since I have mentioned configuration in the application.properties such that
 --  table will create automatically while application start up. I am providing the below script in case required.


CREATE TABLE `user_pin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--3. application .properties

spring.datasource.url=jdbc:mysql://localhost:3306/userpin_db?useSSL=false
spring.datasource.username=root
spring.datasource.password=root

# Hibernate

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
