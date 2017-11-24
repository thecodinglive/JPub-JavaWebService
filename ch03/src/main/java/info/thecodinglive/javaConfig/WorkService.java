package info.thecodinglive.javaConfig;

public class WorkService {
    WorkManager workManager;

    public void setWorkManager(WorkManager workManager) {
        this.workManager = workManager;
    }

    public void askWork() {
        System.out.println(workManager.doIt());
    }
}
