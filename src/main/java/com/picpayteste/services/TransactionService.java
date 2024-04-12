/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.services;

import com.picpayteste.domain.transaction.Transaction;
import com.picpayteste.domain.user.User;
import com.picpayteste.dto.TransactionDTO;
import com.picpayteste.repository.TransactionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author William Toloto
 */
@Service
public class TransactionService {
    
    @Autowired    
    private UserService userService;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private NotificationService notification;
    
    
    public Transaction createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderID());        
        User receiver = this.userService.findUserById(transaction.receiverID());
        
        userService.validateTransaction(sender, transaction.value());
        
        if(!this.authTransaction(sender, transaction.value() )){
            throw new Exception("TRANSAÇÃO NÃO AUTORIZADA! AQUI");
        }
        
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeOp(LocalDateTime.now());
        
        
        //Atualizando os dados da conta 
        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));
        
        
        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
        
        
        this.notification.sendNotification(sender, "Transação realizada com sucesso!");
        this.notification.sendNotification(receiver, "Transação recebida com sucesso!");
        
        
        return newTransaction;
        
    }
    
    public boolean authTransaction(User sender, BigDecimal value){
        ResponseEntity<Map> auth = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        
        if(auth.getStatusCode() == HttpStatus.OK){ //&& auth.getBody().get("message") == "Autorizado"){
            String msgResponse =(String) auth.getBody().get("message");
            if(msgResponse.equals("Autorizado")){
                return true;
            }else{
                return false;
            }
                
        }else{
            return false;
        }
    }
    
}
