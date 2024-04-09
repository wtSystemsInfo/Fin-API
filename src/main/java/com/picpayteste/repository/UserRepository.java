/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.repository;

import com.picpayteste.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Windows
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByDoc(String doc);
    
    Optional<User> findUserByDoc(Long id);
}
