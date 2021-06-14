package com.desafio.brq.controller;

import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @Test
    public void deveRetornarUsuarioCadastrado() {
        UsuarioDTO usuarioDTO = mock(UsuarioDTO.class);
        when(usuarioService.cadastrar(usuarioDTO)).thenReturn(new UsuarioDTO());
        ResponseEntity<UsuarioDTO> usuarioDTOResponseEntity = usuarioController.cadastrarUsuario(usuarioDTO);
        Assertions.assertEquals(usuarioDTOResponseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void deveRetornarListaUsuarios() {
        when(usuarioService.buscarTodosUsuarios()).thenReturn(new ArrayList<UsuarioDTO>());
        ResponseEntity<List<UsuarioDTO>> listaUsuarioDTOResponseEntity = usuarioController.buscarTodosUsuarios();
        Assertions.assertEquals(listaUsuarioDTOResponseEntity.getStatusCode(), HttpStatus.OK);
    }


}
