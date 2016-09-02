package info.thecodinglive.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by yun_dev1 on 2016-07-28.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long uid;
    private String uname;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private List<Schedule> scheduleList;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

}
