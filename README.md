# FSIII_Tienda_Usuarios_AR
FSIII - SUMATIVA - Arquetipo - Microservicio gestión de usuarios

# Ejecutar app Spring Boot
mvn spring-boot:run

# Levantar contenedor Docker
docker build -t tienda_usuarios_backend .
docker run --name tienda_usuarios_backend -p 8080:8080 tienda_usuarios_backend