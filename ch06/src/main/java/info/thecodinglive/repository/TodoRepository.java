package info.thecodinglive.repository;

import info.thecodinglive.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Task,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    List<Task> findByTitle(String todoTitle);
}

