package rooture.com.rooture_server.adminManagementModule.controller;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllBookings_returnsDummyMessage() throws Exception {
        mockMvc.perform(get("/api/admin/bookings"))
            .andExpect(status().isOk())
            .andExpect(content().string("Dummy: all bookings fetched"));
    }

    @Test
    public void testCreateBooking_returnsDummyMessage() throws Exception {
        mockMvc.perform(post("/api/admin/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2025-01-01\"}"))
            .andExpect(status().isOk())
            .andExpect(content().string("Dummy: booking created"));
    }
}
