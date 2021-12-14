package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Endereco;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.Usuario;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.EnderecoService;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.service.UsuarioService;
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
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnderecoService enderecoService;

        @RequestMapping(value = "/index", method = RequestMethod.GET)
        public String index(Model model) {
            
            model.addAttribute("lista", usuarioService.obterLista());
            
            return "/usuario/lista";
        }
        
	@PostMapping(value = "/cep")
	public String buscarCep(Model model, @RequestParam String cep) {
		
		model.addAttribute("endereco", enderecoService.obterEnderecoPorCep(cep));
		
		return "/usuario/cadastro";
	}

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "/usuario/cadastro";
	}
	
	@GetMapping(value = "/usuarios")
	public String telaLista(Model model) {
		
		model.addAttribute("lista", usuarioService.obterLista());
		
		return "/usuario/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Model model, Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);

		return "/index";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
            try{
            usuarioService.excluir(id);
            }catch(Exception e){

            }

            return "redirect:/usuario/lista";
	}	
}
