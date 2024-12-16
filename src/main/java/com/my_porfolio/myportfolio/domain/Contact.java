package com.my_porfolio.myportfolio.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Contact implements Serializable {
    private List<String> phoneNumbers;
    private List<String> emails;
    private List<String> whatsAppLinks;

}
