package info.thecodinglive.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import info.thecodinglive.model.User;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;


    @ManyToOne
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Todo() {
    }

    public Todo(long id, String title) {
        this.id = id;
        this.title = title;

    }


    public Todo(User user, String title) {
        this.user = user;
        this.title = title;
    }

    public Todo(String title){
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
