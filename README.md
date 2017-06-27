# ng-spring-baseline

This is a baseline project for the following stack:

- gradlew 
- Angular 4 / cli
- Springframework 4.3.x
- tomcat/jetty web container

Features:
- Allows integrated development of angular-cli with tomcat/jetty
- Spring java configuration

Getting Started:
- checkout this project and chdir
- cd src/main/webapp/frontend
- import project into IDE and setup web server (tomcat/jetty)
- ./build.sh  # this will create ng artifacts in ../static and watch for changes
- rebuild war (^F9 in Intellij)

As changes are made to .ts files, they will be refreshed in ./static folder
- rebuild war to refresh web context

