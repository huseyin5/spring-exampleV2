package com.haydikodlayalim.aop.api;

import com.haydikodlayalim.aop.services.MessageService;
import com.haydikodlayalim.aop.services.SecondMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> methodExample(@RequestBody String message) {
        secondMessageService.message(message);
        return ResponseEntity.ok(messageService.getMessage(message));
    }
}
