package com.bsmooth.springtwiliomessagesender.services;

import com.bsmooth.springtwiliomessagesender.services.responses.MessageSenderResponse;

public interface MessageSenderService {
    MessageSenderResponse sendWhatsApp(String to, String body);
}

