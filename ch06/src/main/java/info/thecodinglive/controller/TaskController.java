package info.thecodinglive.controller;

import info.thecodinglive.model.Task;
import info.thecodinglive.model.User;
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
    public Task getSchedule(@PathVariable Long scheduleId) {
        Task schedule = todoRepository.findOne(scheduleId);
        User user = schedule.getUser();
        return schedule;
    }

    @RequestMapping("/add/{userId}")
    public Task addSchedule(@PathVariable Long userId, @RequestParam(value = "title") String title){
        User user = userRepository.findOne(userId);
        Task schedule = todoRepository.save(new Task(user, title));

        return schedule;
    }

}
