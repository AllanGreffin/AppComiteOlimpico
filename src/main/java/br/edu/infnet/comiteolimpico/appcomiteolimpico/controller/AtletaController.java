package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.AtletaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class AtletaController {

    @Autowired
    private AtletaService atletaService;
    
    @Autowired
    private GinasticaService ginasticaService;
    
    @Autowired
    private SurfeService surfeService;
    
    @Autowired
    private SkateService skateService;
    
    @RequestMapping(value = "atletas/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("listaAtletas", atletaService.obterLista());
        
        return "/atletas/lista";
    }
    
    @RequestMapping(value = "skates/index", method = RequestMethod.GET)
    public String skatesIndex(Model model) {
        
        model.addAttribute("listaAtletas", skateService.obterLista());
        
        return "/skates/lista";
    }
    
    @RequestMapping(value = "surfes/index", method = RequestMethod.GET)
    public String surfesIndex(Model model) {
        
        model.addAttribute("listaAtletas", surfeService.obterLista());
        
        return "/surfes/lista";
    }
    
    @RequestMapping(value = "ginasticas/index", method = RequestMethod.GET)
    public String ginasticasIndex(Model model) {
        
        model.addAttribute("listaAtletas", ginasticaService.obterLista());
        
        return "/ginasticas/lista";
    }
}
