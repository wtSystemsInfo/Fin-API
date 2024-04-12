/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.services;

import com.picpayteste.domain.user.User;
import com.picpayteste.domain.user.UserType;
import com.picpayteste.dto.UserDTO;
import com.picpayteste.repository.UserRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Toloto
 */
@Service    
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    
    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.COMMON){
            throw new Exception("Usuário LOJISTA não está autorizado a fazer a transação!");
        }
        
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo INSUFICIENTE!");
        }
    }
    
    
    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        
    }
    
    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }
    
    public void saveUser(User user){
        this.userRepository.save(user);
    }
    
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    
}
