package rooture.com.rooture_server.paymentManagementModule.service;

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