FROM gradle:jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk-slim

COPY . $APP_DIR

EXPOSE 8080

FROM postgres:9.3
ENV POSTGRES_DB newtion
ADD init.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["--", "sh", "init.sh"]
