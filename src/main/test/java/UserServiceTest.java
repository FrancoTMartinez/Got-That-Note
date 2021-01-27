package java;

import com.martinezsoft.gotthat.GotThatApp;
import com.martinezsoft.gotthat.model.Users;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import com.martinezsoft.gotthat.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


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

    @Autowired
    private Mock mvc;

    @Test
    public void WhenPostingAUserShouldReturnAccepted() throws Exception{
        Path file = Paths.get("userExample.json");
        String body = Files.readString(file);

        Users users = new Users();


        when(userApiServiceImpl.add(users)).thenReturn();

        MvcResult mvcResult = mvc.perfom(
                MockMvcRequestBuilders.post("/services/user/add").contentType(MediaType.APPLICATION_JSON).content(body)
                    .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn();

            assertEquals(HttpStatus.ACCEPTED.value(), mvcResult.getResponse().getStatus());
    }
}
