package br.com.sampaio.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.sampaio.enums.TipoUsuario;
import br.com.sampaio.model.Usuario;
import br.com.sampaio.service.ServiceUsuario;

public class DataInitializer implements CommandLineRunner {

    @Autowired       
    private ServiceUsuario usuarioService;       
    
    @Override       
    public void run(String... args) throws Exception {           
        Usuario novoUsuario = new Usuario();
        TipoUsuario tipoUsuario = TipoUsuario.ADMINISTRADOR; // Defina o tipo de usuário desejado aqui           
        novoUsuario.setLogin("everton");
        novoUsuario.setEmail("everton@example.com");         
        novoUsuario.setSenha("123");  
        novoUsuario.setTipoUsuario(tipoUsuario); // Defina o tipo de usuário desejado aqui  
        usuarioService.cadastrarUsuario(novoUsuario);
    }
}
