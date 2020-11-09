FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY ./gcloudkey.json gcloudkey.json
ENV GOOGLE_APPLICATION_CREDENTIALS gcloudkey.json
COPY ./build/libs/BlogBackend-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]