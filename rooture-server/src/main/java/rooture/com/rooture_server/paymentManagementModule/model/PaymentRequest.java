package rooture.com.rooture_server.paymentManagementModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PaymentRequest {
    private Long bookingId;
    private double amount;
    private String method;

    public void setMethod(String credit_Card) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAmount(double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}