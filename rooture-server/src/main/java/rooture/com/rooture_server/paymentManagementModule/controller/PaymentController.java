package rooture.com.rooture_server.paymentManagementModule.controller;

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
