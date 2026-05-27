package com.pavam.workshopmongo.services;

import com.pavam.workshopmongo.domain.User;

import com.pavam.workshopmongo.dto.UserDTO;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public User update(User user){
        User newUser = repository.findById(user.getId()).orElse(null);
        updateData(newUser, user);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }




}
