package rooture.com.rooture_server.feedbackAndSupportModule.dao;

import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.feedbackAndSupportModule.model.SupportQuery;

@Repository
public class SupportRepositoryImpl implements SupportRepository {
    @Override
    public String save(SupportQuery query) {
        return "Support query saved to database (mock)";
    }
}
