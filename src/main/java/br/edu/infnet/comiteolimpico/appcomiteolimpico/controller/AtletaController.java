package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.AtletaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        
        model.addAttribute("lista", atletaService.obterLista());
        
        return "/atletas/lista";
    }
    
    @RequestMapping(value = "skates/index", method = RequestMethod.GET)
    public String skatesIndex(Model model) {
        
        model.addAttribute("lista", skateService.obterLista());
        
        return "/skates/lista";
    }
    
    @PostMapping(value = "/skates/incluir")
    public String incluirSkate(Model model, Skate skate) {

            skateService.incluir(skate);

            model.addAttribute("id", skate.getId());

            return skatesIndex(model);
    }
    
    @GetMapping(value = "/skates/cadastro")
    public String telaCadastroSkate() {
            return "skates/cadastro";
    }
    
    @RequestMapping(value = "surfes/index", method = RequestMethod.GET)
    public String surfesIndex(Model model) {
        
        model.addAttribute("lista", surfeService.obterLista());
        
        return "/surfes/lista";
    }
    
    @PostMapping(value = "/surfes/incluir")
    public String incluirSurfe(Model model, Surfe surfe) {

            surfeService.incluir(surfe);

            model.addAttribute("id", surfe.getId());

            return surfesIndex(model);
    }
    
    @GetMapping(value = "/surfes/cadastro")
    public String telaCadastroSurfe() {
            return "surfes/cadastro";
    }
    
    @RequestMapping(value = "ginasticas/index", method = RequestMethod.GET)
    public String ginasticasIndex(Model model) {
        
        model.addAttribute("lista", ginasticaService.obterLista());
        
        return "/ginasticas/lista";
    }
    
    @PostMapping(value = "/ginasticas/incluir")
    public String incluirGinastica(Model model, Ginastica ginastica) {

            ginasticaService.incluir(ginastica);

            model.addAttribute("id", ginastica.getId());

            return ginasticasIndex(model);
    }
    
    @GetMapping(value = "/ginasticas/cadastro")
    public String telaCadastroGinastica() {
            return "ginasticas/cadastro";
    }
}
