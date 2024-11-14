package com.duoc.tienda_usuarios.config;

import com.duoc.tienda_usuarios.model.Role;
import com.duoc.tienda_usuarios.model.Usuario;
import com.duoc.tienda_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) {
        // Verifica si no hay usuarios en la base de datos
        if (usuarioRepository.count() == 0) {
            System.out.println("Inicializando datos de usuarios...");
            
            // Crear usuario administrador
            Usuario admin = new Usuario();
            admin.setNombre("Admin");
            admin.setApellido("Sistema");
            admin.setEmail("admin@tienda.com");
            admin.setPassword("admin123");
            admin.setRole(Role.ADMIN);
            admin.setTelefono("+56912345678");
            admin.setDireccion("Oficina Central");
            admin.setFechaCreacion(LocalDateTime.now());
            admin.setUltimaActualizacion(LocalDateTime.now());
            usuarioRepository.save(admin);
            System.out.println("Usuario administrador creado");

            // Crear primer cliente de prueba
            Usuario cliente1 = new Usuario();
            cliente1.setNombre("Juan");
            cliente1.setApellido("Pérez");
            cliente1.setEmail("juan@email.com");
            cliente1.setPassword("cliente123");
            cliente1.setRole(Role.CLIENTE);
            cliente1.setTelefono("+56987654321");
            cliente1.setDireccion("Av. Principal 123");
            cliente1.setFechaCreacion(LocalDateTime.now());
            cliente1.setUltimaActualizacion(LocalDateTime.now());
            usuarioRepository.save(cliente1);
            System.out.println("Cliente 1 creado");

            // Crear segundo cliente de prueba
            Usuario cliente2 = new Usuario();
            cliente2.setNombre("María");
            cliente2.setApellido("González");
            cliente2.setEmail("maria@email.com");
            cliente2.setPassword("cliente456");
            cliente2.setRole(Role.CLIENTE);
            cliente2.setTelefono("+56976543210");
            cliente2.setDireccion("Calle Secundaria 456");
            cliente2.setFechaCreacion(LocalDateTime.now());
            cliente2.setUltimaActualizacion(LocalDateTime.now());
            usuarioRepository.save(cliente2);
            System.out.println("Cliente 2 creado");

            System.out.println("Inicialización de datos completada!");
        } else {
            System.out.println("La base de datos ya contiene usuarios. No se requiere inicialización.");
        }
    }
}