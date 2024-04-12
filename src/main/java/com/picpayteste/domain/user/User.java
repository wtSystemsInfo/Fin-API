/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.picpayteste.domain.user;
import com.picpayteste.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author William Toloto
 */


@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class User {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
    private String firstName;
    
    private String lastName;
    
    @Column(unique=true)
    private String doc;
    
    @Column(unique=true)
    private String email;
    
    private String password;
    
    private BigDecimal balance;
    
    @Enumerated(EnumType.STRING)    
    private UserType userType;
    
    public User(UserDTO user){
        this.firstName = user.firstname();
        this.lastName = user.lastname();
        this.doc = user.doc();
        this.balance = user.balance();
        this.password = user.password();
        this.email = user.email();
        this.userType = user.userType();
    }
}
