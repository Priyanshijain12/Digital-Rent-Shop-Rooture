package rooture.com.rooture_server.feedbackAndSupportModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rooture.com.rooture_server.feedbackAndSupportModule.model.Feedback;
import rooture.com.rooture_server.feedbackAndSupportModule.service.FeedbackService;

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

