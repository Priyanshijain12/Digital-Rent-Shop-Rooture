package rooture.com.rooture_server.paymentManagementModule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PaymentDetails {
    private Long bookingId;
    private double amount;
    private String date;
    private String method;

    public PaymentDetails(Long bookingId, double amount, String date, String method) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    public long getBookingId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
