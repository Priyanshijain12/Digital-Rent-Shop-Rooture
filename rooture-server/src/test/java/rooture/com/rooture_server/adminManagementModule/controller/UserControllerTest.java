package rooture.com.rooture_server.adminManagementModule.controller;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUsers_returnsListOfUsers() throws Exception {
        List<User> mockUsers = List.of(new User(1L, "Admin"));
        Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);

        mockMvc.perform(get("/api/admin/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Admin"));
    }

    @Test
    public void testUpdateUser_updatesUserSuccessfully() throws Exception {
        User updatedUser = new User(1L, "Updated");
        Mockito.when(userService.updateUser(eq(1L), any())).thenReturn(updatedUser);

        mockMvc.perform(put("/api/admin/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Updated\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated"));
    }

    @Test
    public void testDeleteUser_deletesUserSuccessfully() throws Exception {
        mockMvc.perform(delete("/api/admin/users/1"))
            .andExpect(status().isOk());
    }
}
