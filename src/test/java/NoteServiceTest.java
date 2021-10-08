import com.martinezsoft.gotthat.GotThatApp;
import com.martinezsoft.gotthat.model.Notes;
import com.martinezsoft.gotthat.service.NoteApiServiceImpl;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = GotThatApp.class)
@AutoConfigureMockMvc
public class NoteServiceTest {

    @MockBean
    private NoteApiServiceImpl noteApiServiceImpl;

    @MockBean
    private MongoTemplate mongoTemplate;

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenPostingANoteShouldReturnCreated() throws Exception {
        File file = ResourceUtils.getFile("classpath:noteExample.json");
        String body = FileUtils.readFileToString(file);

        Notes note = new Notes();
        note.setUserId("1");
        note.setTitle("testTitle");
        note.setText("testText");

        ResponseEntity<Notes> notesResponse = new ResponseEntity<Notes>(note, HttpStatus.CREATED);

        when(noteApiServiceImpl.addNote(note)).thenReturn(notesResponse);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/services/notes/add").contentType(MediaType.APPLICATION_JSON).content(body)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();

        assertEquals(HttpStatus.CREATED.value(), mvcResult.getResponse().getStatus());
    }

}
