package rooture.com.rooture_server.adminManagementModule.controller;

@SpringBootTest
@AutoConfigureMockMvc
public class ListingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllListings_returnsDummyMessage() throws Exception {
        mockMvc.perform(get("/api/admin/listings"))
            .andExpect(status().isOk())
            .andExpect(content().string("Dummy: all listings fetched"));
    }

    @Test
    public void testCreateListing_returnsDummyMessage() throws Exception {
        mockMvc.perform(post("/api/admin/listings")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Listing\"}"))
            .andExpect(status().isOk())
            .andExpect(content().string("Dummy: listing created"));
    }
}

