package info.thecodinglive.javaconfig;

public class WorkService {
	private WorkManager workManager;

	public void setWorkManager(WorkManager workManager) {
		this.workManager = workManager;
	}

	public void askWork() {
		System.out.println(workManager.doIt());
	}
}
