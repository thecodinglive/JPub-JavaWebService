package info.thecodinglive.repository;

import info.thecodinglive.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    List<Todo> findByTitle(String todoTitle);
}

