package info.thecodinglive.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by yun_dev1 on 2016-07-28.
 */
@Entity
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private Date createdAt;

    @Column(name="role")
    /**
     *  EnumType.ORDINAL -- int value
     *  EnumType.STRING  -- String enum name value
    * */
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @PrePersist
    public void beforeCreate(){
        createdAt = new Date();
    }

    public UserEntity() {
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity(String name, Integer age, UserRole role) {
        this.name = name;
        this.age  = age;
        this.role = role;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
