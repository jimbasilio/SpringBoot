First Spring Boot application.

Will:

* have simple entity to persist
    * works by getting entity by id, not by insert yet
* have multiple profiles for 2 different database providers (probably HSQL and PostgreSQL)
    * hsqldb works.
* MVC JSON RPC
    * works
* Simple angular frontend

NOTES: 
* don't seem to have to use spring.datasource.driverClassName in properties files.  only need spring.jpa.database-platform.  hsqldb worked fine with both specified, but h2 didn't ... removing it and both worked.  don't understand the autoconfig magic here but works fine.
