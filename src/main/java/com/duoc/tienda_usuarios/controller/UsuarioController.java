package com.duoc.tienda_usuarios.controller;

import com.duoc.tienda_usuarios.dto.UsuarioActualizacionDTO;
import com.duoc.tienda_usuarios.model.LoginRequest;
import com.duoc.tienda_usuarios.model.Usuario;
import com.duoc.tienda_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioActualizacionDTO usuarioDTO) {
        
        Usuario usuarioParaActualizar = new Usuario();
        usuarioParaActualizar.setNombre(usuarioDTO.getNombre());
        usuarioParaActualizar.setApellido(usuarioDTO.getApellido());
        usuarioParaActualizar.setTelefono(usuarioDTO.getTelefono());
        usuarioParaActualizar.setDireccion(usuarioDTO.getDireccion());

        return usuarioService.actualizarUsuario(id, usuarioParaActualizar)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest.getEmail(), loginRequest.getPassword())
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}