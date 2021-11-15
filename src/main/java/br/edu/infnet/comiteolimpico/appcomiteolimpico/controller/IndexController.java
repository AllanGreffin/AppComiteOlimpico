package br.edu.infnet.comiteolimpico.appcomiteolimpico.controller;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.User;
import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user) {
        
        if(user != null){
            UserRepository userRepository = UserRepository.start();
            for(User item: userRepository.getUsers()){
                if(item.getEmail().equals(user.getEmail()) && item.getPassword().equals(user.getPassword())){
                    return "index";
                }
            }
        }
        
        return "errorLogin";
    }
}
