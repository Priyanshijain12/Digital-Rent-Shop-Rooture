package rooture.com.rooture_server.feedbackAndSupportModule.dao;

import org.springframework.stereotype.Repository;

import rooture.com.rooture_server.feedbackAndSupportModule.model.SupportQuery;

@Repository
public interface SupportRepository {
    String save(SupportQuery query);
}
