# ng-spring-baseline

This is a baseline project for the below stack. The main purpose is the get a basic
stack functioning so development can commence.

- gradle / gradlew (3.5)
- Angular 4 / cli
- Springframework 4.3.x
- tomcat/jetty web container

Features:
- Allows integrated development of angular-cli with tomcat/jetty
- Spring MVC / java configuration

Getting Started:
- checkout this project and chdir to root folder
- import project into IDE and setup web server (tomcat/jetty)

- cd src/main/webapp/frontend
- ./build.sh  # this will create ng artifacts in ../webapp/WEB-INF/static and watch for changes
- rebuild war (^F9 in Intellij)

As changes are made to .ts files, they will be refreshed in ./static folder
- rebuild war to refresh web context

