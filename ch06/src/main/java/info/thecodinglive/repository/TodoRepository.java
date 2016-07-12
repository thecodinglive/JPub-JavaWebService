package info.thecodinglive.repository;

import info.thecodinglive.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface TodoRepository extends JpaRepository<Todo,Long> {
}
