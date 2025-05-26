package rooture.com.rooture_server.feedbackAndSupportModule.controller;

@SpringBootTest
@AutoConfigureMockMvc
public class SupportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testContactSupportWithValidData_ShouldReturnSuccess() throws Exception {
        String query = "{\"userId\":\"1\",\"subject\":\"Issue\",\"description\":\"I need help with my booking";}";
        mockMvc.perform(post("/api/support/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(query))
                .andExpect(status().isOk());
    }

    @Test
    public void testContactSupportWithEmptySubject_ShouldReturnBadRequest() throws Exception {
        String query = "{\"userId\":\"1\",\"subject\":\"\",\"description\":\"Empty subject";}";
        mockMvc.perform(post("/api/support/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(query))
                .andExpect(status().isBadRequest());
    }
}
