package basic;

public class Employee implements WorkManager {
	@Override
	public String doIt() {
		return "do work";
	}

	public void onCreated() {
		System.out.println("Employee 생성");
	}

	public void onDestroyed() {
		System.out.println("Employee 소멸");
	}
}
