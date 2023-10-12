package com.haydikodlayalim.aop.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage(String param) {
        System.out.println("Metod mesajı verdi param: " + param);
        return param;
    }
}
