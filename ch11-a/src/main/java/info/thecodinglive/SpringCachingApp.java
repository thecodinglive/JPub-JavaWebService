package info.thecodinglive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@EnableCaching
@SpringBootApplication
public class SpringCachingApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringCachingApp.class);

    //cache설정
    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Cache myCache = new ConcurrentMapCache("carName");
        cacheManager.setCaches(Arrays.asList(myCache));
        return cacheManager;
    }

    @Autowired
    NonDbRepository carRepository;

    public static void main(String ar[]){
        SpringApplication.run(SpringCachingApp.class, ar);
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

        //cacheManager로 출력
        logger.info("cacheManager::" + carRepository.getByNameWithCachManager("스팅어"));
        logger.info("cacheManager::" + carRepository.getByNameWithCachManager("스팅어"));
        logger.info("cacheManger ::" + carRepository.getByNameWithCachManager("k5"));
    }
}
