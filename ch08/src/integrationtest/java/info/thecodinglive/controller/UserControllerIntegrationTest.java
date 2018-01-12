package info.thecodinglive.controller;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import info.thecodinglive.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerIntegrationTest {
	private MockMvc mockMvc;

    @Autowired
	private WebApplicationContext webApplicationContext;
	@MockBean
	private UserService userServiceMock;

    @Before
    public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


    @Test
    public void defaultControllerTest() throws Exception{
		String uri = "/user/list";
		assertNotNull(this.userServiceMock);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andReturn();
		//header
		String contentType = result.getResponse().getContentType();

        String content = result.getResponse().getContentAsString();
		Collection<String> headerNames = result.getResponse().getHeaderNames();
		int status = result.getResponse().getStatus();
        System.out.println("Status is :" + status);
        System.out.println("content is :" + content);

		assertTrue(status == 200);
	}

	@Ignore
	@Test
    public void testUserLoad() throws Exception {

        String uri = "/user/list";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        System.out.println("Status is :" + status);
        System.out.println("content is :" + content);
		assertTrue(status == 200);
		assertTrue(content.trim().length() > 0);
	}
}
