package java;

import com.martinezsoft.gotthat.model.Users;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import com.martinezsoft.gotthat.service.UserService;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;
@SpringBootTest(clases = GotThatApp.class)
@AutoConfigureMockMvc
public class UserServiceTest {

    @MockBean
    private UserApiServiceImpl userApiServiceImpl;

    @Autowire
    private Mock mvc;

    @Test
    public void WhenPostingAUserShouldReturnAccepted() throws Exception{
        Path file = Paths.get("userExample.json");
        String body = Files.readString(file);


        when(userApiServiceImpl.add(users).thenReturn(users);

        MvcResult mvcResult = mvc.perfom(
                MockMvcRequestBuilders.post("/services/user/add").contentType(MediaType.APPLICATION_JSON).content(body)
                    .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn();

            assertEquals(HttpStatus.ACCEPTED.value(), mvcResult.getResponse().getStatus(202));
        )
    }
}
