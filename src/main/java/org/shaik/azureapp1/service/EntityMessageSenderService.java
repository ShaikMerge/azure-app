package org.shaik.azureapp1.service;

import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EntityMessageSenderService {

    @Autowired
    private ServiceBusTemplate serviceBusTemplate;
    private static final String QUEUE_NAME = "shaik-exchange-dev";


    public void sendMessageToServiceBus(String message) {
        serviceBusTemplate.send("shaik-exchange-dev", MessageBuilder.withPayload(message).build());
        System.out.println("Sent message to Service Bus: " + message);
    }
}
