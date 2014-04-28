First Spring Boot application.

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
* don't seem to have to use spring.datasource.driverClassName in properties files.  only need spring.jpa.database-platform.  hsqldb worked fine with both specified, but h2 didn't ... removing it and both worked.  don't understand the autoconfig magic here but works fine.
* painful lesson learned.  on ubuntu you can't have 'node' and 'nodejs' installed or bower (and probably other things) won't work.  'sudo apt-get autoremove node' and everything should work.  (https://github.com/bower/bower/issues/475)