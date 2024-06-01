package com.pedrohenrique.todosimple.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pedrohenrique.todosimple.models.User;
import com.pedrohenrique.todosimple.repositories.UserRespository;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    
    public User findById(Long id) {
        Optional<User> user = this.userRespository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuario não encontrado ! Id: " + id + ", tipo:" + User.class.getName()

        ));
        
    }

    @Transactional
    public User create(User obj, User user) {
        //caso o jpa não consiga gerar novos ids provalvemente o erro está aqui
        //user.setId( null);
        obj = this.userRespository.save(obj);
        return obj;
    }

    @Transactional
    public User update(User obj) {
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRespository.save(newObj);

    }

    public void delete(Long id) {
        findById(id);
        try {
            this.userRespository.deleteById(id);
        } catch (Exception e) {
           throw new RuntimeException("Não é possivel excluir pois há entidades relacionadas");
        }
    }
}
