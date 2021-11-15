package br.edu.infnet.comiteolimpico.appcomiteolimpico.model.repositories;

import br.edu.infnet.comiteolimpico.appcomiteolimpico.model.domain.User;
import java.util.ArrayList;

public class UserRepository {
    
    public static UserRepository userRepository;
    public static ArrayList<User> Users;

    public UserRepository() {
        Users = new ArrayList<>();
        User user = new User();
        user.setEmail("teste@teste.com");
        user.setPassword("123456");
        Users.add(user);
    }
    
    public static UserRepository start(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }
    
    public static ArrayList<User> getUsers() {
        return Users;
    }
}
