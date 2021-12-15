package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Atleta;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.ComissaoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EntidadeService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ComissaoController {

    @Autowired
    private ComissaoService comissaoService;
    
    @Autowired
    private EntidadeService entidadeService;
    
    @RequestMapping(value = "comissoes/index", method = RequestMethod.GET)
    public String index(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", comissaoService.obterLista(usuario));
        
        return "/comissoes/lista";
    }
    
    @PostMapping(value = "/comissoes/incluir")
    public String incluirComissao(@RequestParam("entidadeId") Integer entidadeId, Model model, Comissao comissao, @SessionAttribute("user") Usuario usuario) {

        Entidade entidade = entidadeService.obterPorId(entidadeId);
        comissao.setEntidade(entidade);
        comissao.setAtletas(new ArrayList<Atleta>());
        comissao.setUsuario(usuario);
        comissaoService.incluir(comissao);

        model.addAttribute("id", comissao.getId());

        return index(model, usuario);
    }
    
    @GetMapping(value = "/comissoes/cadastro")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
        
        List<Entidade> entidades = entidadeService.obterLista(usuario);
        model.addAttribute("entidades", entidades);
        
        return "comissoes/cadastro";
    }
    
    @GetMapping(value = "/comissoes/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            comissaoService.excluir(id);
        }catch(Exception e){
            model.addAttribute("mensagem", "Impossível realizar a exclusão deste solicitante!!!");
        }

        return this.index(model, usuario);
    }
}
