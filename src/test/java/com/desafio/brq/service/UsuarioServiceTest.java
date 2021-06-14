package com.desafio.brq.service;


import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.mapper.UsuarioMapper;
import com.desafio.brq.model.Usuario;
import com.desafio.brq.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;


    @Test
    public void deveRetornarUsuarioDTOCadastro() {
        UsuarioDTO usuarioDTOCadastro = new UsuarioDTO();
        usuarioDTOCadastro.setId(1L);
        usuarioDTOCadastro.setNome("Davidson");
        Usuario usuarioCadastro = mock(Usuario.class);
        when(usuarioMapper.converterParaUsuario(usuarioDTOCadastro)).thenReturn(usuarioCadastro);
        when(usuarioRepository.save(usuarioCadastro)).thenReturn(usuarioCadastro);
        when(usuarioMapper.converterParaUsuarioDTO(usuarioCadastro)).thenReturn(usuarioDTOCadastro);
        UsuarioDTO usuarioDTO = usuarioService.cadastrar(usuarioDTOCadastro);
        Assertions.assertEquals(usuarioDTO.getId(), usuarioDTOCadastro.getId());
    }

    @Test
    public void deveDeletarUsuario() {
        Long idUsuario = 1L;
        usuarioService.deletar(idUsuario);
        verify(usuarioRepository).deleteById(idUsuario);
    }

    @Test
    public void deveRetornarListaUsuarios() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(usuario));
        when(usuarioMapper.converterParaUsuarioDTO(usuario)).thenReturn(new UsuarioDTO());
        List<UsuarioDTO> listaUsuarios = usuarioService.buscarTodosUsuarios();
        Assertions.assertNotNull(listaUsuarios);
        Assertions.assertEquals(listaUsuarios.size(), 1);
    }

    @Test
    public void deveRetornarListaVazia() {
        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
        List<UsuarioDTO> listaUsuarios = usuarioService.buscarTodosUsuarios();
        Assertions.assertEquals(listaUsuarios.size(), 0);
    }

    @Test
    public void deveRetornarNull() {
        UsuarioDTO usuarioDTOAntigo = new UsuarioDTO();
        usuarioDTOAntigo.setId(1L);
        usuarioDTOAntigo.setNome("Moises");
        UsuarioDTO usuarioDTO = usuarioService.alterar(usuarioDTOAntigo, usuarioDTOAntigo.getId());
        Assertions.assertNull(usuarioDTO);
    }

    @Test
    public void deveRetornarUsuarioAtualizado() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNome("Moises");

        Usuario usuarioModel = new Usuario();
        usuarioModel.setDataCadastro(Timestamp.from(Instant.now()));
        Optional<Usuario> usuarioSalvo = Optional.of(usuarioModel);

        when(usuarioRepository.findById(1L)).thenReturn(usuarioSalvo);
        Usuario usuario = new Usuario();
        when(usuarioMapper.converterParaUsuario(usuarioDTO)).thenReturn(usuario);
        when(usuarioRepository.save(usuario)).thenReturn(usuario);
        when(usuarioMapper.converterParaUsuarioDTO(usuario)).thenReturn(usuarioDTO);
        UsuarioDTO usuarioDTONovo = usuarioService.alterar(usuarioDTO, usuarioDTO.getId());

        Assertions.assertNotNull(usuarioDTONovo);
    }

}
