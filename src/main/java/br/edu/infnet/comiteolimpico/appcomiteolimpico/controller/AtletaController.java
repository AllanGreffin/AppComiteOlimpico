package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("atletas")
public class AtletaController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "atletas/index";
    }
}
