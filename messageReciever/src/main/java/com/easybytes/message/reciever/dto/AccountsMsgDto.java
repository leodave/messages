package com.easybytes.message.reciever.dto;

// creates getters for the fields and once the object is created all are gonna be final
public record AccountsMsgDto(Long accountNumber, String name, String email, String mobileNumber) {

}
