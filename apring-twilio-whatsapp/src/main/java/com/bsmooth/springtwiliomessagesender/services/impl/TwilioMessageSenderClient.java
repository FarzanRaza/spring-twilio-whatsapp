package com.bsmooth.springtwiliomessagesender.services.impl;

import com.bsmooth.springtwiliomessagesender.constants.MessageConsts;
import com.bsmooth.springtwiliomessagesender.constants.TwilioConsts;
import com.bsmooth.springtwiliomessagesender.domains.twilio.TwilioClient;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.net.URI;
import java.net.URLEncoder;
import static org.apache.commons.codec.CharEncoding.UTF_8;

@Component
public class TwilioMessageSenderClient {

    private TwilioClient twilioClient;

    @Autowired
    public TwilioMessageSenderClient(TwilioClient twilioClient) {
        this.twilioClient = twilioClient;
    }


    public Message sendWhatsApp( String to, String body) {
        final String METHOD = "sendWhatsApp ";
        Message whatsAppMessage = null;

        PhoneNumber toPhoneNumber = new PhoneNumber(TwilioConsts.WHATSAPP_PREFIX + to);
        whatsAppMessage = sendMessage(toPhoneNumber, twilioClient.getWhatsappPhoneNumber(), buildWhatsAppMessage(body));
        return whatsAppMessage;
    }

    private Message sendMessage(PhoneNumber to,PhoneNumber from,String body) {
        return new MessageCreator(to, from, body)
                .create(this.twilioClient.getTwilioRestClient());
    }
    private String buildWhatsAppMessage(String body){
        return MessageConsts.WHATSAPP_MESSAGE_PREFIX + body;
    }




}
