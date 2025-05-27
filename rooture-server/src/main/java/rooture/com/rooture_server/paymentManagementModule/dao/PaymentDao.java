package rooture.com.rooture_server.paymentManagementModule.dao;

import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.paymentManagementModule.model.PaymentDetails;
import rooture.com.rooture_server.paymentManagementModule.model.PaymentRequest;

@Repository
public class PaymentDao {

    public String savePayment(PaymentRequest request) {
        return "Payment processed successfully";
    }

    public PaymentDetails findByBookingId(Long bookingId) {
        return new PaymentDetails(bookingId, 100.0, "2025-05-25", "Credit Card");
    }

    public String refundPayment(Long bookingId) {
        return "Refund processed successfully for bookingId: " + bookingId;
    }
}
