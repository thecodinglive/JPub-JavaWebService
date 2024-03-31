package info.thecodinglive.xmlconfig;

import basic.WorkManager;

public class XBoss implements WorkManager {
	@Override
	public String doIt() {
		return "do boss";
	}

	public void onCreated() {
		System.out.println("boss 생성");
	}

	public void onDestroyed() {
		System.out.println("Boss 소멸");
	}
}
