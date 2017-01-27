package info.thecodinglive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by yun_dev1 on 2017-01-23.
 */
@WebAppConfiguration
@IntegrationTest("server.port:0")
@Transactional
public abstract class IntegrationTestControllerConfig extends IntegrationTestConfig {

    protected MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
