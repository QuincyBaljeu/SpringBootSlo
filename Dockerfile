FROM openjdk:8
ADD target/SpringbootSlo.jar SpringbootSlo.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "SpringbootSlo.jar"]