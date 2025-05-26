package rooture.com.rooture_server.feedbackAndSupportModule.dao;

@Repository
public interface SupportRepository {
    String save(SupportQuery query);
}
