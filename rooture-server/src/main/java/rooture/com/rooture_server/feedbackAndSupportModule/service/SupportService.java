package rooture.com.rooture_server.feedbackAndSupportModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rooture.com.rooture_server.feedbackAndSupportModule.dao.SupportRepository;
import rooture.com.rooture_server.feedbackAndSupportModule.model.SupportQuery;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    public String submitQuery(SupportQuery query) {
        return supportRepository.save(query);
    }
}
