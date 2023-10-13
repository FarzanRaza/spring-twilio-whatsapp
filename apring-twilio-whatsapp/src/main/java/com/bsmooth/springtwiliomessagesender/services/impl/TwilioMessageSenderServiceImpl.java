package com.bsmooth.springtwiliomessagesender.services.impl;

import com.bsmooth.springtwiliomessagesender.services.MessageSenderService;
import com.bsmooth.springtwiliomessagesender.services.responses.MessageSenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class TwilioMessageSenderServiceImpl implements MessageSenderService {
    @Autowired
    private TwilioMessageSenderClient twilioMessageSenderClient;

    public TwilioMessageSenderServiceImpl(TwilioMessageSenderClient twilioMessageSenderClient) {
        this.twilioMessageSenderClient = twilioMessageSenderClient;
    }


    @Override
    public MessageSenderResponse sendWhatsApp(String to, String body) {
        try {
            twilioMessageSenderClient.sendWhatsApp(to,body);
            return new MessageSenderResponse(true, "WhatsApp message sent successfully", HttpStatus.OK.value());
        } catch (Exception e) {
            // If there's an exception (e.g., message sending failure), build a response from the exception.
            return new MessageSenderResponse(false, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

    }
}

