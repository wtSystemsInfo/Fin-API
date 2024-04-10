/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.picpayteste.dto;

import java.math.BigDecimal;

/**
 *
 * @author Windows
 */
public record TransactionDTO(BigDecimal value, Long senderID, Long receiverID) {

}
