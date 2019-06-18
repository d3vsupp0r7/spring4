package org.lba.spring4.springintegration.serviceactivator;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class MessageHandlerWithObject {
    @ServiceActivator
    public String handleMessage(EmployeePayload payload) {
    	System.out.println("** ServiceActivator - START - method: handleMessage");
        System.out.println("Received message: " + payload.toString());
        System.out.println("** ServiceActivator -   END - method: handleMessage");
        return "MESSAGE:" + payload.toString();
    }
}
