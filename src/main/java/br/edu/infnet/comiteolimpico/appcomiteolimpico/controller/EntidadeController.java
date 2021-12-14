package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EntidadeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EntidadeController {

    @Autowired
    private EntidadeService entidadeService;
    
    @Autowired
    private ComissaoService comissaoService;
    
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
    public String incluirEntidade(@RequestParam("comissaoId") Integer comissaoId, Model model, Entidade entidade) {

        Comissao comissao = comissaoService.obterPorId(comissaoId);
        entidade.setComissao(comissao);
        entidadeService.incluir(entidade);

        model.addAttribute("id", entidade.getId());

        return index(model);
    }
    
    @GetMapping(value = "/entidades/cadastro")
    public String telaCadastro(Model model) {
        
        List<Comissao> comissoes = comissaoService.obterLista();
        model.addAttribute("comissoes", comissoes);
        
        return "entidades/cadastro";
    }
    
    @GetMapping(value = "/entidades/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        try{
            entidadeService.excluir(id);
        }catch(Exception e){
        
        }

        return "redirect:/entidades/lista";
    }
}
