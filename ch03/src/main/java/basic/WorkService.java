package basic;

/**
 * Created by yun_dev1 on 2016-03-28.
 */
public class WorkService {
    WorkManager workManager;

    public void setWorkManager(WorkManager workManager){
        this.workManager = workManager;
    }

    public void askWork(){
        System.out.println( workManager.doIt() );
    }
}
