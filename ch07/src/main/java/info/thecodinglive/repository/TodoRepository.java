package info.thecodinglive.repository;

import info.thecodinglive.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodoRepository extends JpaRepository<Todo,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    ///;List<Todo> findByTitle(String todoTitle);
    Todo findByTitle(String todoTitle);
}

