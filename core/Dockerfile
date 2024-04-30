FROM maven:amazoncorretto as build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM amazoncorretto:8u412-alpine3.19
EXPOSE 8080
COPY --from=build /app/target/*.jar app/jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
