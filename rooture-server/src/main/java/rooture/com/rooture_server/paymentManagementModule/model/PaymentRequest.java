package rooture.com.rooture_server.paymentManagementModule.model;

@Getters
@Setters

public class PaymentRequest {
    private Long bookingId;
    private double amount;
    private String method;
}