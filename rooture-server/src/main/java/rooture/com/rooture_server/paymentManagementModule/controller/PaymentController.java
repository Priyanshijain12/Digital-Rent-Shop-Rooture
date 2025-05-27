package rooture.com.rooture_server.paymentManagementModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.paymentManagementModule.model.PaymentDetails;
import rooture.com.rooture_server.paymentManagementModule.model.PaymentRequest;
import rooture.com.rooture_server.paymentManagementModule.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {
        if (request.getAmount() <= 0 || request.getMethod() == null) {
            return ResponseEntity.badRequest().body("Invalid payment request");
        }
        return ResponseEntity.ok(paymentService.processPayment(request));
    }

    @GetMapping("/details/{bookingId}")
    public ResponseEntity<PaymentDetails> viewPaymentDetails(@PathVariable Long bookingId) {
        return ResponseEntity.ok(paymentService.getPaymentDetails(bookingId));
    }

    @PostMapping("/refund/{bookingId}")
    public ResponseEntity<String> processRefund(@PathVariable Long bookingId) {
        return ResponseEntity.ok(paymentService.processRefund(bookingId));
    }
}
