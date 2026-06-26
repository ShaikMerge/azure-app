package org.shaik.azureapp1.service;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EntityMessageSenderService {

    @Autowired
    private ServiceBusTemplate serviceBusTemplate;
    @Autowired
    private SecretClient secretClient;

    private static final String QUEUE_NAME = "shaik-exchange-dev";


    public void sendMessageToServiceBus(String message) {
        serviceBusTemplate.send(QUEUE_NAME, MessageBuilder.withPayload(message).build());
        System.out.println("QUEUE-NAME FROM SECRETS: " + secretClient.getSecret("queue-name").getValue());
        System.out.println("Sent message to Service Bus: " + message);
    }
}
