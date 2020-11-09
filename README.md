#Auspost assignment

## How to run the application

To run the application, we need to start:

        1. Postgres db
        2. TokenService springboot application
        3. AuspostAssignment springboot application

### Running Postgres database

Run using command: docker-compose up

The database will be started on port 5432

### Running TokenService

TokenService is a springboot application. 

Run using command: mvn spring-boot:run

The TokenService is started on port 8443

### Running AuspostAssignment application

AuspostAssignment is a springboot application as well. 

Run the application locally using command:

mvn spring-boot:run -Dspring.profiles.active=local

The AuspostAssignment application is started on port 9443

