package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComissaoController {

    @Autowired
    private ComissaoService comissaoService;
    
    @RequestMapping(value = "comissoes/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("lista", comissaoService.obterLista());
        
        return "/comissoes/lista";
    }
    
    @PostMapping(value = "/comissoes/incluir")
    public String incluirComissao(Model model, Comissao comissao) {

            comissaoService.incluir(comissao);

            model.addAttribute("id", comissao.getId());

            return index(model);
    }
}
