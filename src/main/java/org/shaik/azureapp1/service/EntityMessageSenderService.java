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


    public void sendMessageToServiceBus(String message) {
        serviceBusTemplate.send("${queue-name}", MessageBuilder.withPayload(message).build());
        System.out.println("Sent message to Service Busssss: " + message);
    }
}
