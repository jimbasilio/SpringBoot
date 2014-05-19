First Spring Boot application.

MUST PASS ARGUMENT TO JVM TO SELECT ACTIVE PROFILE:
user@machine:~/your/projects$ mvn clean package
user@machine:~/your/projects$ java -Dspring.profiles.active=dev -jar target/springboot-0.0.1-SNAPSHOT.jar


Todo:
* have simple entity to persist
    * works by getting entity by id, not by insert yet
* Simple angular frontend
    * angular loaded but not doing anyting of interest.  index.html served though.
* MVC integration tests
* protractor tests
* jUnit tests
* automatically run bower install on maven build
    * soon
    
Done:
* MVC JSON RPC
    * works
* have multiple profiles for 2 different database providers (HSQL and H2)
    * works now.  can set profile at will in application.properties to use h2db or hsqldb independant of dev/prod setting.


NOTES: 
* painful lesson learned.  on ubuntu you can't have 'node' and 'nodejs' installed or bower (and probably other things) won't work.  'sudo apt-get autoremove node' and everything should work.  (https://github.com/bower/bower/issues/475)
* NOTE ABOUT THE NODE NOTE!!  Apparently ubuntu packages don't always link 'node' to 'nodejs'.  You can manually create this link if you are getting a '/usr/bin/env: node: No such file or directory' error.  Run 'sudo ln -s /usr/bin/nodejs /usr/bin/node' and it'll create a link to the nodejs app which will then allow bower to run.  I don't understand the packaging issues .. but I'm moving on from it.