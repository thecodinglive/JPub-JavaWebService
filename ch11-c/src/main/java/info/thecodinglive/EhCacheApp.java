package info.thecodinglive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;


@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class EhCacheApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(EhCacheApp.class);

    @Autowired
    NonDbRepository carRepository;

    public static void main(String ar[]) {
        SpringApplication.run(EhCacheApp.class, ar);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("자동차 정보");
        logger.info("no1::" + carRepository.getByName("스팅어"));
        logger.info("no2::" + carRepository.getByName("k5"));
        logger.info("no3::" + carRepository.getByName("BMW"));
        logger.info("no4::" + carRepository.getByName("벤츠"));
        logger.info("no5::" + carRepository.getByName("페라리"));
        //cache 확인을 위해서 한번 더 같은 내용 출력
        logger.info("no1::" + carRepository.getByName("스팅어"));
        logger.info("no1::" + carRepository.getByName("스팅어"));
        logger.info("no2::" + carRepository.getByName("k5"));

        logger.info("truck01:" + carRepository.getByTruck("탑차"));
        logger.info("truck02:" + carRepository.getByTruck("덤프"));
        logger.info("truck03:" + carRepository.getByTruck("트랙터"));
        logger.info("truck04:" + carRepository.getByTruck("픽업트럭"));
        logger.info("truck05:" + carRepository.getByTruck("몬스터트럭"));
        //cache확인을 위해 한번 더 같은 내용 출력
        logger.info("truck01:" + carRepository.getByTruck("탑차"));
        logger.info("truck02:" + carRepository.getByTruck("덤프"));
        logger.info("truck03:" + carRepository.getByTruck("트랙터"));
        logger.info("truck04:" + carRepository.getByTruck("픽업트럭"));
        logger.info("truck05:" + carRepository.getByTruck("몬스터트럭"));
    }
}
