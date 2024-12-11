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

# DockerHub
1. Crear repo en https://hub.docker.com/
2. Primero, asegúrate de estar logueado en Docker Hub desde tu terminal
    docker login
3. Identifica tu imagen local. Puedes ver tus imágenes locales con:
    docker images
4. Etiqueta tu imagen local con el formato requerido por Docker Hub:
    Por ejemplo, si tu imagen local se llama "backend-app:1.0", los comandos serían:
    docker tag tienda_usuarios_backend espanderlof/fs3_tienda_usuarios_ar:latest
    docker push espanderlof/fs3_tienda_usuarios_ar:latest

# Play with Docker
1. ir a https://labs.play-with-docker.com/
2. copiar repo de dockerHub
    docker pull espanderlof/fs3_tienda_usuarios_ar:latest
3. levantar contenedor
    docker run -d --network host --name tienda_usuarios_backend espanderlof/fs3_tienda_usuarios_ar:latest
4. verificar contenedores
    docker ps