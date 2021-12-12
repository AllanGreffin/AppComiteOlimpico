package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComissaoController {

    @RequestMapping(value = "comissoes/index", method = RequestMethod.GET)
    public String index() {
        return "/comissoes/lista";
    }
}
