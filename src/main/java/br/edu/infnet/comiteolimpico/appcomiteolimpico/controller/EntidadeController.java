package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntidadeController {

    @Autowired
    private EntidadeService entidadeService;
    
    @RequestMapping(value = "entidades/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("lista", entidadeService.obterLista());
        
        return "/entidades/lista";
    }
    
    @RequestMapping(value = "entidades/success", method = RequestMethod.POST)
    public String add() {
        return "/entidades/success";
    }
    
    @PostMapping(value = "/entidades/incluir")
    public String incluirEntidade(Model model, Entidade entidade) {

        entidadeService.incluir(entidade);

        model.addAttribute("id", entidade.getId());

        return index(model);
    }
    
    @GetMapping(value = "/entidades/cadastro")
    public String telaCadastro() {
            return "entidades/cadastro";
    }
}
