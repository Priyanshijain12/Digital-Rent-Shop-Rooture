package rooture.com.rooture_server.feedbackAndSupportModule.dao;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
    @Override
    public String save(Feedback feedback) {
        return "Feedback saved to database (mock)";
    }
}
