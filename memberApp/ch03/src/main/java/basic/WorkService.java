package basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class WorkService {
    WorkManager workManager;

    public void setWorkManager(WorkManager workManager){
        this.workManager = workManager;
    }

    public void askWork(){
        System.out.println( workManager.doIt() );
    }

    @PostConstruct
    public void onCreated() {
        System.out.println("초기화 되었을 때");
    }

    @PreDestroy
    public void onDestroyed() {
        System.out.println("종료되었을 때");
    }
}
