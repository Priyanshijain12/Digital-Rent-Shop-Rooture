package rooture.com.rooture_server.paymentManagementModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PaymentRequest {
    private Long bookingId;
    private double amount;
    private String method;
}