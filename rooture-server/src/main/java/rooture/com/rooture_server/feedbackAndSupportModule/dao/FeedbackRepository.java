package rooture.com.rooture_server.feedbackAndSupportModule.dao;

@Repository
public interface FeedbackRepository {
    String save(Feedback feedback);
}
