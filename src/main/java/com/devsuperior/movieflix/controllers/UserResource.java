package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id){
        UserDTO dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> findUserAuthenticated(){
        UserDTO dto = userService.findUserAuthenticated();
        return ResponseEntity.ok().body(dto);
    }


}
