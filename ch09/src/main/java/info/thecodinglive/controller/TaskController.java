package info.thecodinglive.controller;

import info.thecodinglive.model.TodoEntity;
import info.thecodinglive.model.UserEntity;
import info.thecodinglive.repository.TodoRepository;
import info.thecodinglive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yun_dev1 on 2016-09-02.
 */
@RestController
@RequestMapping("/schedule")
public class TaskController {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("{scheduleId}")
    public TodoEntity getSchedule(@PathVariable Long scheduleId) {
        TodoEntity schedule = todoRepository.findOne(scheduleId);
        UserEntity user = schedule.getUser();
        return schedule;
    }

    @RequestMapping("/add/{userId}")
    public TodoEntity addSchedule(@PathVariable Long userId, @RequestParam(value = "title") String title){
        UserEntity user = userRepository.findOne(userId);
        TodoEntity schedule = todoRepository.save(new TodoEntity(user, title));

        return schedule;
    }

}
