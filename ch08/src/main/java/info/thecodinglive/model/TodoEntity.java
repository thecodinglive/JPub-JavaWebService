package info.thecodinglive.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;


    @ManyToOne
    @JsonBackReference
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public TodoEntity() {
    }

    public TodoEntity(long id, String title) {
        this.id = id;
        this.title = title;

    }


    public TodoEntity(UserEntity user, String title) {
        this.user = user;
        this.title = title;
    }

    public TodoEntity(String title){
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
