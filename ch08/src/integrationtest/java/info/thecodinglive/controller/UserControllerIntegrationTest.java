package info.thecodinglive.controller;

import info.thecodinglive.config.IntegrationTestControllerConfig;
import info.thecodinglive.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by yun_dev1 on 2017-01-23.
 */
public class UserControllerIntegrationTest extends IntegrationTestControllerConfig{
    @Autowired
    UserService userService;
    @Before
    public void setup(){
        super.setup();
    }


    @Ignore
    @Test
    public void defaultControllerTest() throws Exception{
        String uri="/";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        System.out.println("Status is :" + status);
        System.out.println("content is :" + content);

        Assert.assertTrue(status == 200);
        Assert.assertTrue(content.trim().length() > 0);


    }


    //@Ignore
    @Test
    public void testUserLoad() throws Exception {

        String uri = "/user/list";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        System.out.println("Status is :" + status);
        System.out.println("content is :" + content);
        Assert.assertTrue(status == 200);
        Assert.assertTrue(content.trim().length() > 0);
    }

}
