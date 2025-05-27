package rooture.com.rooture_server.feedbackAndSupportModule.dao;

import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.feedbackAndSupportModule.model.Feedback;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
    @Override
    public String save(Feedback feedback) {
        return "Feedback saved to database (mock)";
    }
}
