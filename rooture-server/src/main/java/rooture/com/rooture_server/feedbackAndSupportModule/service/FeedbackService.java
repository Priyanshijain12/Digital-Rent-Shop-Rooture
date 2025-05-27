package rooture.com.rooture_server.feedbackAndSupportModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.feedbackAndSupportModule.dao.FeedbackRepository;
import rooture.com.rooture_server.feedbackAndSupportModule.model.Feedback;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public String submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
