package rooture.com.rooture_server.feedbackAndSupportModule.controller;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSubmitFeedbackWithValidMessage_ShouldReturnSuccess() throws Exception {
        String feedback = "{\"userId\":\"1\",\"listingId\":\"123\",\"message\":\"This is a valid feedback message";}";
        mockMvc.perform(post("/api/feedback/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(feedback))
                .andExpect(status().isOk());
    }

    @Test
    public void testSubmitFeedbackWithShortMessage_ShouldReturnBadRequest() throws Exception {
        String feedback = "{\"userId\":\"1\",\"listingId\":\"123\",\"message\":\"short\"}";
        mockMvc.perform(post("/api/feedback/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(feedback))
                .andExpect(status().isBadRequest());
    }
}
