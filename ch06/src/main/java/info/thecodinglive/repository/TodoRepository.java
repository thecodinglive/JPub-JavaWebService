package info.thecodinglive.repository;

import info.thecodinglive.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    List<TodoEntity> findByTitle(String todoTitle);
}

