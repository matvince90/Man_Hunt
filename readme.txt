/apache-tomcat-7.0.55 
Contains the Tomcat server used for hosting the ManhuntServerSide webservice's generated .war file.
To run:
apache-tomcat-7.0.55/bin/catalina.bat run --set to run on port 80 or 8081

/Manhunt2
An Android Studio project using gradle for depenency and project config. Builds the APK file for the Android map application, the map application key
must be updated with the ADB hash or keystore to access the map.

/ManhuntDB
DDL schema

/ManhuntServerSide
The webservice, must be exported to WAR format and placed in apache-tomcat-7.0.55/webapps folder

/ManhuntServerTest
A tester for the Manhunt web service.