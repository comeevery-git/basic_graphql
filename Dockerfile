FROM adoptopenjdk/openjdk11
ARG port
ARG JAR_FILE_PATH=build/libs/*.jar
EXPOSE ${port}
COPY ${JAR_FILE_PATH} app.jar
ENV docker-app 'Hello'
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
