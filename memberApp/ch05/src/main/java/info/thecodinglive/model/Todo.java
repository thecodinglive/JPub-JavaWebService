package info.thecodinglive.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Todo {
    private long id;
    private String title;

    public Todo() {
    }

    public Todo(long id, String title) {
        this.id = id;
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
