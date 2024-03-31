package info.thecodinglive.javaconfig;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Boss implements WorkManager {
	@Override
	public String doIt() {
		return "do boss";
	}

	@PostConstruct
	public void onCreated() {
		System.out.println("boss 초기화");
	}

	@PreDestroy
	public void onDestroyed() {
		System.out.println("boss 소멸");
	}

	public void createdHandler() {
		System.out.println("BeanPostProcessor에서 호출");
	}
}
