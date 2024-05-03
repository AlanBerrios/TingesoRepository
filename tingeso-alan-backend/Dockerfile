FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tingeso_backend_alan.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/tingeso_backend_alan.jar"]