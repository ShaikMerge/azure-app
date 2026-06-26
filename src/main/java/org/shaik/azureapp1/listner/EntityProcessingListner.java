package org.shaik.azureapp1.listner;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EntityProcessingListner {

    private static final String QUEUE_NAME = "shaik-exchange-dev";

    @ServiceBusListener(destination = QUEUE_NAME)
    public void handleMessageFromServiceBus(String message) {
        System.out.println("Received message from Service Bus: " + message);
    }
}
