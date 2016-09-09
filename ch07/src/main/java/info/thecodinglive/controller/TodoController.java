package info.thecodinglive.controller;

import info.thecodinglive.model.Todo;
import info.thecodinglive.model.User;
import info.thecodinglive.repository.TodoRepository;
import info.thecodinglive.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yun_dev1 on 2016-09-02.
 */
@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("{scheduleId}")
    public Todo getSchedule(@PathVariable Long scheduleId) {
        Todo todo = todoRepository.findOne(scheduleId);
        User user = todo.getUser();
        return todo;
    }

    @RequestMapping("/add/{userId}")
    public Todo addTodo(@PathVariable Long userId, @RequestParam(value = "title") String title){
        User user = userRepository.findOne(userId);
        Todo todo = todoRepository.save(new Todo(user, title));

        return todo;
    }

}
