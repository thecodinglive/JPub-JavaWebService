package info.thecodinglive.model;

import java.io.Serializable;


/**
 * Created by yun_dev1 on 2016-07-28.
 */

public class UserEntity implements Serializable{
    private Long id;
    private String name;
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
