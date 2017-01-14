package info.thecodinglive.repository;

import info.thecodinglive.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    List<TodoEntity> findByTitle(String todoTitle);
}

