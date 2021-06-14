package com.desafio.brq.mapper;

import com.desafio.brq.dto.UsuarioDTO;
import com.desafio.brq.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.desafio.brq.utils.DateUtils.converterTimestampComPrimeiraHoraDia;

@ExtendWith(SpringExtension.class)
public class UsuarioMapperTest {

    @InjectMocks
    private UsuarioMapperImpl usuarioMapper;

    @Test
    public void deveRetornarUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNome("Davidson");
        usuarioDTO.setSobrenome("Denis");
        usuarioDTO.setDataNascimento("30/08/1996");
        usuarioDTO.setCpf("0546262842");
        usuarioDTO.setEndereco("rua lancha");
        usuarioDTO.setCep("78523695");
        usuarioDTO.setTelefone("67 85412354");
        usuarioDTO.setDataCadastro("10/01/2020 01:00:00");
        usuarioDTO.setUltimaAlteracao("10/01/2020 01:10:00");

        Usuario usuario = usuarioMapper.converterParaUsuario(usuarioDTO);

        Assertions.assertEquals(usuario.getId(), usuarioDTO.getId());
        Assertions.assertEquals(usuario.getNome(), usuarioDTO.getNome());
        Assertions.assertEquals(usuario.getSobrenome(), usuarioDTO.getSobrenome());
        Assertions.assertEquals(usuario.getDataNascimento(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getDataNascimento()));
        Assertions.assertEquals(usuario.getCpf(), usuarioDTO.getCpf());
        Assertions.assertEquals(usuario.getEndereco(), usuarioDTO.getEndereco());
        Assertions.assertEquals(usuario.getCep(), usuarioDTO.getCep());
        Assertions.assertEquals(usuario.getTelefone(), usuarioDTO.getTelefone());
        Assertions.assertEquals(usuario.getDataCadastro(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getDataCadastro()));
        Assertions.assertEquals(usuario.getUltimaAlteracao(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getUltimaAlteracao()));
    }


    @Test
    public void deveRetornarUsuarioDTO() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Davidson");
        usuario.setSobrenome("Denis");
        usuario.setDataNascimento(converterTimestampComPrimeiraHoraDia("30/08/1996"));
        usuario.setCpf("0546262842");
        usuario.setEndereco("rua lancha");
        usuario.setCep("78523695");
        usuario.setTelefone("67 85412354");
        usuario.setDataCadastro(converterTimestampComPrimeiraHoraDia("10/01/2020 01:00:00"));
        usuario.setUltimaAlteracao(converterTimestampComPrimeiraHoraDia("10/01/2020 01:10:00"));

        UsuarioDTO usuarioDTO = usuarioMapper.converterParaUsuarioDTO(usuario);

        Assertions.assertEquals(usuario.getId(), usuarioDTO.getId());
        Assertions.assertEquals(usuario.getNome(), usuarioDTO.getNome());
        Assertions.assertEquals(usuario.getSobrenome(), usuarioDTO.getSobrenome());
        Assertions.assertEquals(usuario.getDataNascimento(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getDataNascimento()));
        Assertions.assertEquals(usuario.getCpf(), usuarioDTO.getCpf());
        Assertions.assertEquals(usuario.getEndereco(), usuarioDTO.getEndereco());
        Assertions.assertEquals(usuario.getCep(), usuarioDTO.getCep());
        Assertions.assertEquals(usuario.getTelefone(), usuarioDTO.getTelefone());
        Assertions.assertEquals(usuario.getDataCadastro(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getDataCadastro()));
        Assertions.assertEquals(usuario.getUltimaAlteracao(), converterTimestampComPrimeiraHoraDia(usuarioDTO.getUltimaAlteracao()));
    }
}
