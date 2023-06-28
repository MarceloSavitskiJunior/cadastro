package br.com.marcelo.cadastro.controller;

import br.com.marcelo.cadastro.domain.usuario.DadosAlteracaoUsuario;
import br.com.marcelo.cadastro.domain.usuario.DadosCadastroUsuario;
import br.com.marcelo.cadastro.domain.usuario.Usuario;
import br.com.marcelo.cadastro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class cadastroNomesController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var usuario = usuarioRepository.getReferenceById(id);
            model.addAttribute("usuario", usuario);
        }

        return "usuarios/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", usuarioRepository.findAll());
        return "usuarios/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraUsuario(DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);

        return "redirect:/usuarios";
    }

    @PutMapping
    @Transactional
    public String alteraUsuario(DadosAlteracaoUsuario dados) {
        var usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.atualizaDados(dados);

        return "redirect:/usuarios";
    }

    @DeleteMapping
    @Transactional
    public String removeUsuario(Long id) {
        usuarioRepository.deleteById(id);

        return "redirect:/usuarios";
    }

}
