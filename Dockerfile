FROM gradle:jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk-slim

COPY . $APP_DIR

EXPOSE 8080

ENTRYPOINT ["/init", "--", "sh", "init.sh"]
