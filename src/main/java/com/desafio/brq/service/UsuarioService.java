package com.desafio.brq.service;


import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.mapper.UsuarioMapper;
import com.desafio.brq.model.Usuario;
import com.desafio.brq.repository.UsuarioRepository;
import com.desafio.brq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
        Usuario usuario = registraDataCadastroAlteracao(usuarioMapper.converterParaUsuario(usuarioDTO));
        return usuarioMapper.converterParaUsuarioDTO(usuarioRepository.save(usuario));
    }

    public void deletar(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public List<UsuarioDTO> buscarTodosUsuarios() {
        return usuarioRepository.findAll().stream().map(usuario -> usuarioMapper.converterParaUsuarioDTO(usuario)).collect(Collectors.toList());
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO, Long idUsuario) {
        Optional<Usuario> usuarioSalvo = usuarioRepository.findById(idUsuario);
        if (usuarioSalvo.isPresent()) {
            Usuario usuario = usuarioMapper.converterParaUsuario(usuarioDTO);
            usuario.setId(idUsuario);
            usuario.setUltimaAlteracao(DateUtils.getDataHoje());
            usuario.setDataCadastro(usuarioSalvo.get().getDataCadastro());
            return usuarioMapper.converterParaUsuarioDTO(usuarioRepository.save(usuario));
        }
        return null;
    }

    private Usuario registraDataCadastroAlteracao(Usuario usuario) {
        usuario.setDataCadastro(usuario.getDataCadastro() == null ? Timestamp.from(Instant.now()) : usuario.getDataCadastro());
        usuario.setUltimaAlteracao(Timestamp.from(Instant.now()));
        return usuario;
    }
}
