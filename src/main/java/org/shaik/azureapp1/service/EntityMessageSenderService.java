package org.shaik.azureapp1.service;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EntityMessageSenderService {

    @Autowired
    private ServiceBusTemplate serviceBusTemplate;
    @Value("${queue.name}")
    private String getQueueName;

    private static final String QUEUE_NAME = "shaik-exchange-dev";


    public void sendMessageToServiceBus(String message) {
        serviceBusTemplate.send(QUEUE_NAME, MessageBuilder.withPayload(message).build());
        System.out.println("QUEUE-NAME FROM SECRETS: " + getQueueName);
        System.out.println("Sent message to Service Bus: " + message);
    }
}
