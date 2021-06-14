package com.desafio.brq.controller;

import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ApiOperation(value = "Busca todos os usuarios cadastrados", nickname = "buscarTodosUsuarios")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        return new ResponseEntity<>(usuarioService.buscarTodosUsuarios(), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar um usuario", nickname = "cadastrarUsuario")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.cadastrar(usuarioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idUsuario}")
    @ApiOperation(value = "Alterar um usuario", nickname = "alterarUsuario")
    public ResponseEntity<UsuarioDTO> alterarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable Long idUsuario) {
        return new ResponseEntity<>(usuarioService.alterar(usuarioDTO, idUsuario), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    @ApiOperation(value = "deletar um usuario", nickname = "deletarUsuario")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long idUsuario) {
        usuarioService.deletar(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
