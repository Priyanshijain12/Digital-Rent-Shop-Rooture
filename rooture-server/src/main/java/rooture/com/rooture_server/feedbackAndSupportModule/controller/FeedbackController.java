package rooture.com.rooture_server.feedbackAndSupportModule.controller;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
        if (feedback.getMessage().length() < 10) {
            return ResponseEntity.badRequest().body("Feedback message is too short");
        }
        return ResponseEntity.ok(feedbackService.submitFeedback(feedback));
    }
}

