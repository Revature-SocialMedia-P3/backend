FROM openjdk:11-jdk
# cp target/spring-boot-web.jar /opt/app/app.jar
COPY target/*.jar app.jar
EXPOSE 8080
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]