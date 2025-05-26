package rooture.com.rooture_server.notificationModule.controller;

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

