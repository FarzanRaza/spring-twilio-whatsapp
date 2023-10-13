package com.bsmooth.springtwiliomessagesender.controllers;

import com.bsmooth.springtwiliomessagesender.services.MessageSenderService;
import com.bsmooth.springtwiliomessagesender.services.responses.MessageSenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageSenderController {


     MessageSenderService messageSenderService;

    public MessageSenderController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/whatsapp")
    public ResponseEntity<MessageSenderResponse> sendWhatsApp(@RequestParam("to") String to, @RequestParam("body") String body) {
        MessageSenderResponse messageSenderResponse = messageSenderService.sendWhatsApp(to, body);
        return new ResponseEntity<>(messageSenderResponse, HttpStatus.OK);
    }
}
