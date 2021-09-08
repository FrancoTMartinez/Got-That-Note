import com.martinezsoft.gotthat.GotThatApp;
import com.martinezsoft.gotthat.model.Users;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest(classes = GotThatApp.class)
@AutoConfigureMockMvc
public class UserServiceTest {
    @MockBean
    private UserApiServiceImpl userApiServiceImpl;

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenPostingAnUserShouldReturnAccepted() throws Exception {
        File file = ResourceUtils.getFile("classpath:userExample.json");
        String body = FileUtils.readFileToString(file);

        Users users = new Users();
        users.setid(1);
        users.setEmail("test@test");
        users.setUserPassword("test123");
        ResponseEntity<Users> usersResponse = new ResponseEntity<Users>(users, HttpStatus.ACCEPTED);

        when(userApiServiceImpl.add(users)).thenReturn(usersResponse);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/services/user/add").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void whenUpdatingAnUserShouldReturnOk() throws Exception {
        File file = ResourceUtils.getFile("classpath:userExample.json");
        String body = FileUtils.readFileToString(file);

        Users users = new Users();
        users.setid(1);
        users.setEmail("test1@test1");
        users.setUserPassword("passwordTest1");

        ResponseEntity<Users> usersResponse = new ResponseEntity<Users>(users, HttpStatus.OK);

        when(userApiServiceImpl.update(users.getid(),users)).thenReturn(usersResponse);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/services/user/update/1").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
    @Test
    public void whenLookUpUserShouldReturnOk() throws Exception {
        File file = ResourceUtils.getFile("classpath:userExample.json");
        String body = FileUtils.readFileToString(file);

        Users users = new Users();
        users.setid(1);

        ResponseEntity<Users> usersResponse = new ResponseEntity<Users>(users, HttpStatus.OK);

        when(userApiServiceImpl.lookUp(users.getid())).thenReturn(usersResponse);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/services/user/1").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
    @Test
    public void whenSearchingUserShouldReturnOk() throws Exception {
        File file = ResourceUtils.getFile("classpath:userExample.json");
        String body = FileUtils.readFileToString(file);

        Users users = new Users();
        users.setid(1);
        List<Users> usersReturned = new ArrayList();
        usersReturned.add(users);

        ResponseEntity<List<Users>> usersResponse= new ResponseEntity<>(HttpStatus.OK);

        when(userApiServiceImpl.search()).thenReturn(usersResponse);


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/services/user").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
    @Test
    public void whenDeleteAnUserShouldReturnOk() throws Exception {
        File file = ResourceUtils.getFile("classpath:userExample.json");
        String body = FileUtils.readFileToString(file);

        Users users = new Users();
        users.setid(1);

        ResponseEntity<String> usersResponse = new ResponseEntity<>(HttpStatus.OK);

        when(userApiServiceImpl.delete(users.getid())).thenReturn(usersResponse);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/services/user/1").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
