FROM openjdk:jre-slim as builder

COPY . /home/app/src
WORKDIR /home/app/src
RUN /home/app/src/gradlew build

FROM openjdk:jre-slim
EXPOSE 8080
COPY --from=builder /home/app/src/build/libs/gs-spring-boot-0.1.0.jar /home/app/
WORKDIR /home/app
CMD ["java","-jar","gs-spring-boot-0.1.0.jar"]