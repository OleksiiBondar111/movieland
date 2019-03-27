import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)
public class MovieControllerTest extends EntityControllerTest {

    @Test
    public void getAllTest() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nameRussian", is("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", is("Schindlers List")))
                .andExpect(jsonPath("$[0].yearOfRelease", is("1993")))
                .andExpect(jsonPath("$[0].rating", is(8.7)))
                .andExpect(jsonPath("$[0].price", is(150.50)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/1.jpg")));

    }


}
