package info.thecodinglive.repository;

import info.thecodinglive.model.Todo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by yun_dev1 on 2016-09-22.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TodoRepository repository;

    @Test
    public void todoInsert(){
        entityManager.persist(new Todo("123"));
        Todo todo = this.repository.findByTitle("123");

        assertEquals(todo.getTitle(), "123");
    }

}
