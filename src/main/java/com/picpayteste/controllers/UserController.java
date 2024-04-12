/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.controllers;

import com.picpayteste.domain.user.User;
import com.picpayteste.dto.UserDTO;
import com.picpayteste.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author William Toloto
 */
@RestController()
@RequestMapping("/users")
public class UserController {
    
    @Autowired  
    private UserService userService;
    
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  this.userService.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
