package dio.diospringsecurityjwt.controller;

import dio.diospringsecurityjwt.model.User;
import dio.diospringsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }
    /*
    * Quando nós usamos JWT, configuramos filtros na aplicação
    * que são encarregados de acompanhar as requisições e verificar
    * os tokens presentes no header da aplicação
    */
}
