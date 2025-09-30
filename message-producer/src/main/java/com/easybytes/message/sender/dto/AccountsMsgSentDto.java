package com.easybytes.message.sender.dto;

// creates getters for the fields and once the object is created all are gonna be final
public record AccountsMsgSentDto(Long accountNumber, String name, String email, String mobileNumber) {

}
