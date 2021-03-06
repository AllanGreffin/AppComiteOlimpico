package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Comissao;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Entidade;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
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
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EntidadeController {

    @Autowired
    private EntidadeService entidadeService;
    
    @Autowired
    private ComissaoService comissaoService;
    
    @RequestMapping(value = "entidades/index", method = RequestMethod.GET)
    public String index(Model model, @SessionAttribute("user") Usuario usuario) {
        
        model.addAttribute("lista", entidadeService.obterLista(usuario));
        
        return "/entidades/lista";
    }
    
    @RequestMapping(value = "entidades/success", method = RequestMethod.POST)
    public String add() {
        return "/entidades/success";
    }
    
    @PostMapping(value = "/entidades/incluir")
    public String incluirEntidade(Model model, Entidade entidade, @SessionAttribute("user") Usuario usuario) {

//        Comissao comissao = comissaoService.obterPorId(comissaoId);
//        entidade.setComissao(comissao);
        entidade.setUsuario(usuario);
        entidadeService.incluir(entidade);

        model.addAttribute("id", entidade.getId());

        return index(model, usuario);
    }
    
    @GetMapping(value = "/entidades/cadastro")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {
        
        List<Comissao> comissoes = comissaoService.obterLista(usuario);
        model.addAttribute("comissoes", comissoes);
        
        return "entidades/cadastro";
    }
    
    @GetMapping(value = "/entidades/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        try{
            List<Comissao> comissoes = comissaoService.obterLista(usuario);
            boolean hasComissao = false;
            for(Comissao comissao : comissoes){
                if(comissao.getEntidade().getId() == id){
                    model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o de uma Entidade vinculada ?? uma Comiss??o!");
                    hasComissao = true;
                    break;
                }
            }
            if(hasComissao == false){
                entidadeService.excluir(id);
            }
        }catch(Exception e){
            model.addAttribute("mensagem", "Imposs??vel realizar a exclus??o deste item!!!");
        }

        return this.index(model, usuario);
        
    }
}
