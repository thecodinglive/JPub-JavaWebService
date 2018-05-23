package info.thecodinglive.querydsl;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Integer age;

    private Date createdAt;

    /**
     * EnumType.ORDINAL -- int value
     * EnumType.STRING  -- String enum name value
     */
    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @PrePersist
    public void beforeCreate() {
        createdAt = new Date();
    }

    public UserEntity() {
    }

    public UserEntity(String username) {
        this.username = username;
    }

    public UserEntity(String username, Integer age, UserRole role) {
        this.username = username;
        this.age = age;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
