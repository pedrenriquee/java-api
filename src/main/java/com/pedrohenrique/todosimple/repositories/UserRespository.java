package com.pedrohenrique.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedrohenrique.todosimple.models.User;



@Repository
public interface UserRespository extends JpaRepository<User, Long > {


    
}