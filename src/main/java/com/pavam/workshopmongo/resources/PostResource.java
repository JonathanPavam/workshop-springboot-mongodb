package com.pavam.workshopmongo.resources;


import com.pavam.workshopmongo.domain.Post;
import com.pavam.workshopmongo.domain.User;
import com.pavam.workshopmongo.dto.UserDTO;
import com.pavam.workshopmongo.services.UserService;
import com.pavam.workshopmongo.services.exception.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts/")
public class PostResource {
    @Autowired
    PostService service;

    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findAll(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
