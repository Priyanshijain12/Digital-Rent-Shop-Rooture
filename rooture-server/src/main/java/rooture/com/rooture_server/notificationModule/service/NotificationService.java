package rooture.com.rooture_server.notificationModule.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import rooture.com.rooture_server.notificationModule.dao.NotificationRepository;
import rooture.com.rooture_server.notificationModule.model.EmailRequest;
import rooture.com.rooture_server.notificationModule.model.NotificationLog;
import rooture.com.rooture_server.notificationModule.model.SmsRequest;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendEmail(EmailRequest request) {
        System.out.println("Sending email to: " + request.getTo());
        NotificationLog log = new NotificationLog();
        log.setType("EMAIL");
        log.setRecipient(request.getTo());
        log.setMessage(request.getMessage());
        log.setTimestamp(LocalDateTime.now());
        notificationRepository.save(log);
    }

    public void sendSms(SmsRequest request) {
        System.out.println("Sending SMS to: " + request.getPhoneNumber());
        NotificationLog log = new NotificationLog();
        log.setType("SMS");
        log.setRecipient(request.getPhoneNumber());
        log.setMessage(request.getMessage());
        log.setTimestamp(LocalDateTime.now());
        notificationRepository.save(log);
    }
}
