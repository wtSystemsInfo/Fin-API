/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.picpayteste.dto;

import com.picpayteste.domain.user.UserType;
import java.math.BigDecimal;

/**
 *
 * @author William Toloto
 */


public record UserDTO( String firstname, String lastname, String doc, BigDecimal balance, String password, String email, UserType userType) {

}
