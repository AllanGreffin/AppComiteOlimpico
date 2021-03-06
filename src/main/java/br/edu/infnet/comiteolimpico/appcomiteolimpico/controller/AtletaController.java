package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Ginastica;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Skate;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Surfe;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.AtletaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.GinasticaService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SkateService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.SurfeService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    
    @Autowired
    private ComissaoService comissaoService;
    
    @RequestMapping(value = "atletas/index", method = RequestMethod.GET)
    public String index(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", atletaService.obterLista(usuario));
        
        return "/atletas/lista";
    }
    
    @GetMapping(value = "/atletas/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            atletaService.excluir(id);
        }catch(Exception e){
            model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o deste solicitante!!!");
        }
        
        return this.index(model, usuario);
        
    }
    
    @RequestMapping(value = "skates/index", method = RequestMethod.GET)
    public String skatesIndex(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", skateService.obterLista(usuario));
        
        return "/skates/lista";
    }
    
    @PostMapping(value = "/skates/incluir")
    public String incluirSkate(@RequestParam("comissaoId") Integer comissaoId, @RequestParam("dataDeNascimento") String dataDeNascimento,
            Model model, Skate skate, @SessionAttribute("user") Usuario usuario) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        skate.setNascimento(LocalDate.parse(dataDeNascimento, formatter).atStartOfDay());
        
        Comissao comissao = comissaoService.obterPorId(comissaoId);
        skate.setComissao(comissao);
        skate.setUsuario(usuario);
        skateService.incluir(skate);

        model.addAttribute("id", skate.getId());

        return skatesIndex(model, usuario);
    }
    
    @GetMapping(value = "/skates/cadastro")
    public String telaCadastroSkate(Model model, @SessionAttribute("user") Usuario usuario) {
        List<Comissao> comissoes = comissaoService.obterLista(usuario);
        model.addAttribute("comissoes", comissoes);
        return "skates/cadastro";
    }
    
    @GetMapping(value = "/skates/{id}/excluir")
    public String excluirSkate(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            skateService.excluir(id);
        }catch(Exception e){
            model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o deste solicitante!!!");
        }
        
        return this.skatesIndex(model, usuario);
    }
    
    @RequestMapping(value = "surfes/index", method = RequestMethod.GET)
    public String surfesIndex(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", surfeService.obterLista(usuario));
        
        return "/surfes/lista";
    }
    
    @PostMapping(value = "/surfes/incluir")
    public String incluirSurfe(@RequestParam("comissaoId") Integer comissaoId, @RequestParam("dataDeNascimento") String dataDeNascimento,
            Model model, Surfe surfe, @SessionAttribute("user") Usuario usuario) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        surfe.setNascimento(LocalDate.parse(dataDeNascimento, formatter).atStartOfDay());
        
        Comissao comissao = comissaoService.obterPorId(comissaoId);
        surfe.setComissao(comissao);
        surfe.setUsuario(usuario);
        surfeService.incluir(surfe);

        model.addAttribute("id", surfe.getId());

        return surfesIndex(model, usuario);
    }
    
    @GetMapping(value = "/surfes/cadastro")
    public String telaCadastroSurfe(Model model, @SessionAttribute("user") Usuario usuario) {
        List<Comissao> comissoes = comissaoService.obterLista(usuario);
        model.addAttribute("comissoes", comissoes);
        return "surfes/cadastro";
    }
    
    @GetMapping(value = "/surfes/{id}/excluir")
    public String excluirSurfes(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            surfeService.excluir(id);
        }catch(Exception e){
            model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o deste solicitante!!!");
        }

        return this.surfesIndex(model, usuario);
        
    }
    
    @RequestMapping(value = "ginasticas/index", method = RequestMethod.GET)
    public String ginasticasIndex(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", ginasticaService.obterLista(usuario));
        
        return "/ginasticas/lista";
    }
    
    @PostMapping(value = "/ginasticas/incluir")
    public String incluirGinastica(@RequestParam("comissaoId") Integer comissaoId, @RequestParam("dataDeNascimento") String dataDeNascimento,
            Model model, Ginastica ginastica, @SessionAttribute("user") Usuario usuario) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ginastica.setNascimento(LocalDate.parse(dataDeNascimento, formatter).atStartOfDay());
        
        Comissao comissao = comissaoService.obterPorId(comissaoId);
        ginastica.setComissao(comissao);
        ginastica.setUsuario(usuario);
        ginasticaService.incluir(ginastica);

        model.addAttribute("id", ginastica.getId());

        return ginasticasIndex(model, usuario);
    }
    
    @GetMapping(value = "/ginasticas/cadastro")
    public String telaCadastroGinastica(Model model, @SessionAttribute("user") Usuario usuario) {
        List<Comissao> comissoes = comissaoService.obterLista(usuario);
        model.addAttribute("comissoes", comissoes);
        return "ginasticas/cadastro";
    }
    
    @GetMapping(value = "/ginasticas/{id}/excluir")
    public String excluirGinasticas(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            ginasticaService.excluir(id);
        }catch(Exception e){
            model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o deste solicitante!!!");
        }

        return this.ginasticasIndex(model, usuario);
        
    }
}
