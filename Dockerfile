FROM adoptopenjdk/openjdk11

ARG port=8081
ARG JAR_FILE_PATH=build/libs/*.jar

EXPOSE ${port}

COPY ${JAR_FILE_PATH} app.jar
COPY entrypoint.sh run.sh
RUN chmod 774 run.sh

ENV PROFILE=dev
ENTRYPOINT ["./run.sh"]
#ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]