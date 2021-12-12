package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.AtletaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComissaoController {

    @Autowired
    private ComissaoService comissaoService;
    
    @RequestMapping(value = "comissoes/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("lista", comissaoService.obterLista());
        
        return "/comissoes/lista";
    }
}
