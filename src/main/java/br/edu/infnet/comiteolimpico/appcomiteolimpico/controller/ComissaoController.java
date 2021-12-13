package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Atleta;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EntidadeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComissaoController {

    @Autowired
    private ComissaoService comissaoService;
    
    @Autowired
    private EntidadeService entidadeService;
    
    @RequestMapping(value = "comissoes/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        model.addAttribute("lista", comissaoService.obterLista());
        
        return "/comissoes/lista";
    }
    
    @PostMapping(value = "/comissoes/incluir")
    public String incluirComissao(@RequestParam("entidadeId") Integer entidadeId, Model model, Comissao comissao) {

        Entidade entidade = entidadeService.obterPorId(entidadeId);
        comissao.setEntidade(entidade);
        comissao.setAtletas(new ArrayList<Atleta>());
        comissaoService.incluir(comissao);

        model.addAttribute("id", comissao.getId());

        return index(model);
    }
    
    @GetMapping(value = "/comissoes/cadastro")
    public String telaCadastro(Model model) {
        
        List<Entidade> entidades = entidadeService.obterLista();
        model.addAttribute("entidades", entidades);
        
        return "comissoes/cadastro";
    }
}
