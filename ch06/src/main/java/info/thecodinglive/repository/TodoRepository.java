package info.thecodinglive.repository;

import info.thecodinglive.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Schedule,Long> {
    //Stream<Todo> findAllByCustomQueryAndStream();
    //@Query("select title from todo")
    //Stream<Todo> findAllByTitle();
    List<Schedule> findByTitle(String todoTitle);
}

