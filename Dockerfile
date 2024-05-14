FROM openjdk:17-alpine

ENV APP_NAME elementary-math-core-0.0.1-SNAPSHOT

WORKDIR /app

COPY ./target/${APP_NAME}.jar  /app/${APP_NAME}.jar

EXPOSE 8080

CMD java -jar ${APP_NAME}.jar
