package java;

import com.martinezsoft.gotthat.model.Users;
import com.martinezsoft.gotthat.service.UserApiServiceImpl;
import com.martinezsoft.gotthat.service.UserService;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void WhenPostingAUserShouldReturnOk() throws Exception{
        Path file = Paths.get("userExample.json");
        String body = Files.readString(file);

        List<Users> users = new ArrayList();

        when(UserApiServiceImpl.add(users)).thenReturn(users);
    }
}
