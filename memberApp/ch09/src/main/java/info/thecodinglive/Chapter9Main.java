package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Chapter9Main implements CommandLineRunner, ApplicationListener<ApplicationStartingEvent> {
	public static void main(String[] args) {
		SpringApplication.run(Chapter9Main.class, args);
        }

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		new ApplicationPidFileWriter("Ch09.pid");
	}

	@Override
    public void run(String... args) throws Exception {
    }
}
