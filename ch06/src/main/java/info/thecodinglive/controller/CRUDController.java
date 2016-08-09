package info.thecodinglive.controller;

import info.thecodinglive.model.Schedule;

import info.thecodinglive.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;


@RequestMapping(value = "/jpa")
@RestController
public class CRUDController {
    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<String> createTodo(@RequestParam(value = "todoTitle") String todoTitle,
                                             @RequestParam(value = "uname") String uname){
        Schedule schedule = new Schedule(todoTitle);
        todoRepository.save(schedule);

        return new ResponseEntity(schedule, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<Schedule> showTodoList(){
        List<Schedule> schedules = todoRepository.findAll();

        return  new ResponseEntity(schedules, HttpStatus.OK);
    }

    @RequestMapping(value = "/stodos", method = RequestMethod.GET)
    public ResponseEntity<Stream<Schedule>> streamshowTodoList(){
        //Stream<Todo> todos = todoRepository.findAllByTitle();
        List<Schedule> schedules = todoRepository.findByTitle("hello");

        return  new ResponseEntity(schedules, HttpStatus.OK);
    }
}
