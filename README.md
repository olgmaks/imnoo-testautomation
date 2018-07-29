# imnoo-testautomation
 
### Pre-requisites:

 - install JDK 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 - set JAVA_HOME environment variable
 - install maven (https://maven.apache.org/install.html)
 - set M2_HOME environment variable
 - google chrome browser should be installed

### Running tests + Generating report:
 - Edit file user.properties (add email and password for imnoo app)
    
 - Launch test suite with following command:
   ```
   mvn clean verify
   ```
 - Copy report dir:
   ```
   cp -r ./allure-results ./target
   ```
   
 - Launch report:
   ```
   mvn allure:serve
   ```
   
How to set env variable: 
https://www.java.com/en/download/help/path.xml
