package rooture.com.rooture_server.paymentManagementModule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import rooture.com.rooture_server.paymentManagementModule.model.PaymentDetails;
import rooture.com.rooture_server.paymentManagementModule.model.PaymentRequest;
import rooture.com.rooture_server.paymentManagementModule.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentService paymentService;

    @Test
    void testProcessPayment_ValidRequest_ReturnsSuccessMessage() {
        PaymentRequest request;
        request = new PaymentRequest();
        request.setAmount(100.0);
        request.setMethod("Credit Card");

        when(paymentService.processPayment(any())).thenReturn("Payment processed successfully");

        ResponseEntity<String> response = paymentController.processPayment(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Payment processed successfully", response.getBody());
    }

    @Test
    void testProcessPayment_InvalidRequest_ReturnsBadRequest() {
        PaymentRequest request = new PaymentRequest();
        request.setAmount(0.0);
        request.setMethod(null);

        ResponseEntity<String> response = paymentController.processPayment(request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testViewPaymentDetails_ReturnsPaymentDetails() {
        Long bookingId = 1L;
        PaymentDetails mockDetails = new PaymentDetails(bookingId, 100.0, "2025-05-25", "Credit Card");

        when(paymentService.getPaymentDetails(bookingId)).thenReturn(mockDetails);

        ResponseEntity<PaymentDetails> response = paymentController.viewPaymentDetails(bookingId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bookingId, response.getBody().getBookingId());
    }

    @Test
    void testProcessRefund_ReturnsSuccessMessage() {
        Long bookingId = 1L;

        when(paymentService.processRefund(bookingId)).thenReturn("Refund processed successfully");

        ResponseEntity<String> response = paymentController.processRefund(bookingId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Refund processed successfully", response.getBody());
    }
}
