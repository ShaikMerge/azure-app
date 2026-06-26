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

    @Value("${queue-name}")
    private String queueName;



    public void sendMessageToServiceBus(String message) {
        serviceBusTemplate.send(queueName, MessageBuilder.withPayload(message).build());
        System.out.println("Sent message to Service Bus: " + message);
    }
}
