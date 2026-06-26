package org.shaik.azureapp1.controller;

import org.shaik.azureapp1.service.EntityMessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EntityMessageSenderService
    entityMessageSenderService;

    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }

    @GetMapping("/settings")
    public String getAdminSettings() {
        return "Admin Settings Page";
    }

    @PostMapping("/send-message")
    public void sendMessageToServiceBus(@RequestParam  String message) {

        entityMessageSenderService.sendMessageToServiceBus(message);
    }
}
