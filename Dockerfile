FROM adoptopenjdk/openjdk13:ubi
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=embedmongo", "app.jar"]