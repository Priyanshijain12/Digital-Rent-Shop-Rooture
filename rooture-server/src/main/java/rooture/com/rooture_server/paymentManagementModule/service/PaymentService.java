package rooture.com.rooture_server.paymentManagementModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.paymentManagementModule.dao.PaymentDao;
import rooture.com.rooture_server.paymentManagementModule.model.PaymentDetails;
import rooture.com.rooture_server.paymentManagementModule.model.PaymentRequest;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public String processPayment(PaymentRequest request) {
        return paymentDao.savePayment(request);
    }

    public PaymentDetails getPaymentDetails(Long bookingId) {
        return paymentDao.findByBookingId(bookingId);
    }

    public String processRefund(Long bookingId) {
        return paymentDao.refundPayment(bookingId);
    }
}