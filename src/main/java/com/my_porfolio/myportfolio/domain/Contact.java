package com.my_porfolio.myportfolio.domain;

import lombok.Data;

import java.util.List;

@Data
public class Contact {
    private List<String> phoneNumbers;
    private List<String> emails;
    private List<String> whatsAppLinks;

}
