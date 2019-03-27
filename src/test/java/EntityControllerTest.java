import com.bonolex.movieland.config.AppConfig;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = {AppConfig.class})
@TestPropertySource("classpath:application-test.yml")
@WebAppConfiguration
public abstract class EntityControllerTest {

    public MockMvc mockMvc;
    private List<String> scripts = Arrays.asList("/scripts/db/ddl_initial.sql", "/scripts/db/dml_initial.sql");

    @Autowired
    public WebApplicationContext webApplicationContext;

    @Autowired
    public DataSource dataSource;

    @Before
    public void setup() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        for (String script : scripts) {
            resourceDatabasePopulator.addScript(new ClassPathResource(script));
        }
        DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


}
