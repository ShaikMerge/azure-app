package org.shaik.azureapp1.listner;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EntityProcessingListner {

    @ServiceBusListener(destination = "${queue-name}")
    public void handleMessageFromServiceBus(String message) {
        System.out.println("Received message from Service Bus: " + message);
    }
}
