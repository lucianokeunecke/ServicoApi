FROM openjdk:17
MAINTAINER leogloria
COPY target/cars-0.0.1-SNAPSHOT.jar cars-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cars-0.0.1-SNAPSHOT.jar"]
