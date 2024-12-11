# FSIII_Tienda_Usuarios_AR
FSIII - SUMATIVA - Arquetipo - Microservicio gestión de usuarios

# Ejecutar app Spring Boot
mvn spring-boot:run

# Levantar contenedor Docker
docker build -t tienda_usuarios_backend .
docker run --name tienda_usuarios_backend -p 8081:8081 tienda_usuarios_backend

# Patrones de diseño
- Builder, para la clase Usuario. Ya que nos ayudara a construir objetos de manera mas limpia y fluida.
- Singleton, para manejar el login del sistema. Gestion centralizada del login.

# Ejecuta los tests con JaCoCo
mvn clean test
mvn jacoco:report