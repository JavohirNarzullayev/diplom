FROM amazoncorretto:11-alpine-jdk
EXPOSE 8091
ADD main-app/main-web/target/dev-main-web-1.0.jar Diplom.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","Diplom.jar"]


#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
##
## Package stage
##
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]