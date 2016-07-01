import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yun_dev1 on 2016-06-13.
 */
public class RestClient extends RestTemplate{


    private RestClient(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(2000);

        new RestTemplate(factory);
    }

    //싱글톤 아니여도 됨 테스트코드용
    public static RestClient getInstance(){
        return new RestClient();
    }

    public static void main(String ar[]){
        RestClient restClient = RestClient.getInstance();
        restClient.getForEntity("http://www.naver.com", String.class);
    }
}
