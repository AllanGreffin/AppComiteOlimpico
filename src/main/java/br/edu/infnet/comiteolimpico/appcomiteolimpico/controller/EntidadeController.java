package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntidadeController {

    @RequestMapping(value = "entidades/index", method = RequestMethod.GET)
    public String index() {
        return "/entidades/lista";
    }
    
    @RequestMapping(value = "entidades/success", method = RequestMethod.POST)
    public String add() {
        return "/entidades/success";
    }
}
