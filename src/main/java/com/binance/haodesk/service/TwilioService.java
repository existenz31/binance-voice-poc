package com.binance.haodesk.service;
import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.*;
import com.twilio.type.PhoneNumber;

public class TwilioService {
    public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("AUTH_TOKEN");

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Recording recording =
                Recording.fetcher("RE7bc9589c7efbb02f11d68de80ced5ce2")
                        .fetch();

        String from = "+17753827206";//"+15854763410";
        String to = "+33631826839";

        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();

        System.out.println(call.getSid());
    }
}
