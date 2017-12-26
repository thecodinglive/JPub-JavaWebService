package info.thecodinglive;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheResult;
import java.util.Random;

/**
 * Created by ysj on 2017-10-04.
 */
@Component
public class NonDbRepository {
    private final long sleepTime = 3000L;
    private final Logger logger = LoggerFactory.getLogger(NonDbRepository.class);

    private void makeSlowService() {
        logger.info("start sleep");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ire) {
            throw new IllegalStateException(ire);
        }
        logger.info("end sleep");
    }

    private Car randomCarColor(Car car) {
        Random rn = new Random();
        rn.setSeed(System.currentTimeMillis());

        String colors[] = {"red", "blue", "gray", "white", "purple"};

        for (int i = 0; i < 5; i++) {
            int b = rn.nextInt(5);
            car.setColor(colors[b]);
        }
        return car;
    }

    @Cacheable("carName")
    public Car getByName(String name) {
        makeSlowService();
        Car myCar = new Car(name);
        return randomCarColor(myCar);
    }

    @Cacheable("carName")
    public Car getByTruck(String name) {
        makeSlowService();
        Car myCar = new Car(name);
        return randomCarColor(myCar);
    }
}
