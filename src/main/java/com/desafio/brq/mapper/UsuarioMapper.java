package com.desafio.brq.mapper;

import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.model.Usuario;
import com.desafio.brq.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "dataNascimento", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataCadastro", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(target = "ultimaAlteracao", dateFormat = "dd/MM/yyyy HH:mm:ss")
    Usuario converterParaUsuario(UsuarioDTO usuarioDTO);

    @Mapping(target = "dataNascimento", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "dataCadastro", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(target = "ultimaAlteracao", dateFormat = "dd/MM/yyyy HH:mm:ss")
    UsuarioDTO converterParaUsuarioDTO(Usuario usuario);

    default Timestamp map(String dataString) {
        return dataString == null || dataString.isEmpty() ? null : DateUtils.converterTimestampComPrimeiraHoraDia(dataString);
    }
}
