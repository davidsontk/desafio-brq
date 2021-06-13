package com.desafio.brq.controller;

import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        return new ResponseEntity<>(usuarioService.buscarTodosUsuarios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuarioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> alterarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long idUsuario) {
        return new ResponseEntity<>(usuarioService.alterar(usuarioDTO, idUsuario), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long idUsuario) {
        usuarioService.deletar(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
