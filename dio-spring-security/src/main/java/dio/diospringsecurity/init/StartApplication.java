package dio.diospringsecurity.init;

import dio.diospringsecurity.model.User;
import dio.diospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if (user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }

        user = repository.findByUsername("user");
        if (user==null){
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }

    }
    /*
    *
    * Classe que dá uma carga inicial com os perfis de usuários
    *
    * Cria user e admin
    *
    * Adicionamos o H2 como base de dados no pom.xml pois ele
    * é um banco de dados em memória
    */
}

