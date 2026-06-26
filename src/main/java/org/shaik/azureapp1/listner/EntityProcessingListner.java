package org.shaik.azureapp1.listner;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import org.springframework.stereotype.Service;

@Service
public class EntityProcessingListner {

    public static final String ENTITY_PROCESSING_QUEUE = "shaik-exchange-dev";

    @ServiceBusListener(destination = ENTITY_PROCESSING_QUEUE)
    public void handleMessageFromServiceBus(String message) {
        System.out.println("Received message from Service Bus: " + message);
    }
}
