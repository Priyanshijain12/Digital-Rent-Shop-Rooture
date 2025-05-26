package rooture.com.rooture_server.feedbackAndSupportModule.service;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    public String submitQuery(SupportQuery query) {
        return supportRepository.save(query);
    }
}
