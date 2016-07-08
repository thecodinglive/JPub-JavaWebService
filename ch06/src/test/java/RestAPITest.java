import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import info.thecodinglive.RestApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yun_dev1 on 2016-07-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestApp.class)
@WebIntegrationTest("server.port=0")
public class RestAPITest {
    RestTemplate restTemplate;


    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }


    private String jsonStringFromObject(Object object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();

        return  mapper.writeValueAsString(object);
    }

    @Test
    public void testGoogle() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        Charset utf8 = Charset.forName("UTF-8");
        MediaType mediaType = new MediaType("text", "html", utf8);
        headers.setContentType(mediaType);
        headers.set("User-Agent", "mozilla");
        headers.set("Accept-Language", "ko");
        HttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        List<HttpMessageConverter<?>> httpMessageConverter = Lists.newArrayList();
        httpMessageConverter.add(stringHttpMessageConverter);
        restTemplate.setMessageConverters(httpMessageConverter);

        String uri = "http://google.co.kr";
        ResponseEntity result = restTemplate.getForObject("http://google.com", ResponseEntity.class);

    }
}
