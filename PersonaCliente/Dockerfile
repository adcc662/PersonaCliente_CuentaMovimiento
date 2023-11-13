# Utiliza una imagen base de OpenJDK que coincida con tu versión de Java
FROM openjdk:17-slim

# Argumento para el JAR_FILE
ARG JAR_FILE=build/libs/*.jar

# Copia el JAR_FILE en el contenedor
COPY ${JAR_FILE} app.jar

# Expone el puerto en el que se ejecutará tu aplicación
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java","-jar","/app.jar"]