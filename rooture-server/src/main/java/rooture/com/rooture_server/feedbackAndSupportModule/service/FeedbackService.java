package rooture.com.rooture_server.feedbackAndSupportModule.service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public String submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
