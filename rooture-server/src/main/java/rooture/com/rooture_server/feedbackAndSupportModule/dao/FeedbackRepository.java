package rooture.com.rooture_server.feedbackAndSupportModule.dao;

import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.feedbackAndSupportModule.model.Feedback;

@Repository
public interface FeedbackRepository {
    String save(Feedback feedback);
}
