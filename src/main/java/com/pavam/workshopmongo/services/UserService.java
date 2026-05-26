package com.pavam.workshopmongo.services;

import com.pavam.workshopmongo.domain.User;

import com.pavam.workshopmongo.repository.UserRepository;
import com.pavam.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        User user = repository.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return user;
    }

}
