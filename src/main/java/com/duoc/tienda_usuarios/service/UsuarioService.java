package com.duoc.tienda_usuarios.service;

import com.duoc.tienda_usuarios.model.Usuario;
import com.duoc.tienda_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
            .map(usuarioExistente -> {
                if (usuarioActualizado.getNombre() != null) {
                    usuarioExistente.setNombre(usuarioActualizado.getNombre());
                }
                if (usuarioActualizado.getApellido() != null) {
                    usuarioExistente.setApellido(usuarioActualizado.getApellido());
                }
                if (usuarioActualizado.getTelefono() != null) {
                    usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
                }
                if (usuarioActualizado.getDireccion() != null) {
                    usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
                }
                return usuarioRepository.save(usuarioExistente);
            });
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> login(String email, String password) {
        return usuarioRepository.findByEmail(email)
            .filter(usuario -> usuario.getPassword().equals(password));
    }
}