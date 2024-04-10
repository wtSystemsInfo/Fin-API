/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.repository;

import com.picpayteste.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author William Toloto
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
