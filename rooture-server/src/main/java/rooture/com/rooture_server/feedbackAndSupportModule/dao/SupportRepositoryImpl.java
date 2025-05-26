package rooture.com.rooture_server.feedbackAndSupportModule.dao;

@Repository
public class SupportRepositoryImpl implements SupportRepository {
    @Override
    public String save(SupportQuery query) {
        return "Support query saved to database (mock)";
    }
}
