package rooture.com.rooture_server.notificationModule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.notificationModule.model.EmailRequest;
import rooture.com.rooture_server.notificationModule.model.SmsRequest;
import rooture.com.rooture_server.notificationModule.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        if (request.getTo() == null || request.getSubject() == null || request.getMessage() == null) {
            return ResponseEntity.badRequest().body("Invalid email request");
        }
        notificationService.sendEmail(request);
        return ResponseEntity.ok("Email sent");
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) {
        if (request.getPhoneNumber() == null || request.getMessage() == null) {
            return ResponseEntity.badRequest().body("Invalid SMS request");
        }
        notificationService.sendSms(request);
        return ResponseEntity.ok("SMS sent");
    }
}

