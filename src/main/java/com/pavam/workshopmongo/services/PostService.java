package com.pavam.workshopmongo.services;

import com.pavam.workshopmongo.domain.Post;

import com.pavam.workshopmongo.repository.PostRepository;
import com.pavam.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id){
         Post post = repository.findById(id).orElse(null);
        if(post == null){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContaining(text);
    }



}
