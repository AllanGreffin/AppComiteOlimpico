package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("entidades")
public class EntidadeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "entidades/index";
    }
    
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String add() {
        return "entidades/success";
    }
}
