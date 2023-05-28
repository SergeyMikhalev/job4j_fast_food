# Этап 1 - сборка проекта в jar
FROM maven:3.8-openjdk-17 as maven
COPY . ./app
WORKDIR /app
RUN mvn install -Dmaven.test.skip

# Этап 2 - указание как запустить проект
FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY --from=maven /app/dish/target/dish-1.0-SNAPSHOT.jar dish.jar
CMD java -jar dish.jar
