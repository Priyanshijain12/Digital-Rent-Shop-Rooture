package rooture.com.rooture_server.reportingModule.controller;

@WebMvcTest(ReportController.class)
public class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    public void testGetUserReports_returnsSuccess() throws Exception {
        Mockito.when(reportService.getUserReports())
                .thenReturn(List.of(new ReportDTO("Total Users", "100")));

        mockMvc.perform(get("/api/reports/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Total Users"));
    }

    @Test
    public void testGetListingReports_returnsSuccess() throws Exception {
        Mockito.when(reportService.getListingReports())
                .thenReturn(List.of(new ReportDTO("Total Listings", "50")));

        mockMvc.perform(get("/api/reports/listings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].value").value("50"));
    }

    @Test
    public void testGetBookingReports_returnsSuccess() throws Exception {
        Mockito.when(reportService.getBookingReports())
                .thenReturn(List.of(new ReportDTO("Total Bookings", "30")));

        mockMvc.perform(get("/api/reports/bookings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Total Bookings"));
    }

    @Test
    public void testGetPaymentReports_returnsSuccess() throws Exception {
        Mockito.when(reportService.getPaymentReports())
                .thenReturn(List.of(new ReportDTO("Total Payments", "$5000")));

        mockMvc.perform(get("/api/reports/payments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].value").value("$5000"));
    }
}

