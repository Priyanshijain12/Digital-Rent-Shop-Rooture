package rooture.com.rooture_server.notificationModule.service;

@SpringBootTest
public class NotificationServiceTest {

    @MockBean
    private NotificationService notificationService;

    @Autowired
    private NotificationController controller;

    @Test
    void testSendEmailShouldReturnOkWhenValidRequest() {
        EmailRequest request = new EmailRequest();
        request.setTo("test@example.com");
        request.setSubject("Test Subject");
        request.setMessage("Test Message");
        ResponseEntity<String> response = controller.sendEmail(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Email sent", response.getBody());
    }

    @Test
    void testSendSmsShouldReturnOkWhenValidRequest() {
        SmsRequest request = new SmsRequest();
        request.setPhoneNumber("1234567890");
        request.setMessage("Test Message");
        ResponseEntity<String> response = controller.sendSms(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("SMS sent", response.getBody());
    }

    @Test
    void testSendEmailShouldReturnBadRequestWhenMissingFields() {
        EmailRequest request = new EmailRequest();
        ResponseEntity<String> response = controller.sendEmail(request);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testSendSmsShouldReturnBadRequestWhenMissingFields() {
        SmsRequest request = new SmsRequest();
        ResponseEntity<String> response = controller.sendSms(request);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
