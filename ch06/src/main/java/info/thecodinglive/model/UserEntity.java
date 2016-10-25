package info.thecodinglive.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by yun_dev1 on 2016-07-28.
 */
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<TodoEntity> scheduleList;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TodoEntity> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<TodoEntity> scheduleList) {
        this.scheduleList = scheduleList;
    }


}
