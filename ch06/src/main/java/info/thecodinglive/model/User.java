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
    private Long id;

    private String uname;

    public User(String uname) {
        this.uname = uname;
    }

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Schedule> scheduleList;



    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }


}
