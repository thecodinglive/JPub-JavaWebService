package info.thecodinglive.controller;

import info.thecodinglive.model.Todo;

import info.thecodinglive.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/jpa")
@RestController
public class CRUDController {
    @Autowired
    //private TodoService todoService;
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<String> createTodo(@RequestParam(value = "todoTitle") String todoTitle){
        Todo todo = new Todo(todoTitle);
        //todoService.save(todo);
        todoRepository.save(todo);

        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<Todo> showTodoList(){
        //List<Todo> todos = todoService.findTodoList();
        List<Todo> todos = todoRepository.findAll();

        return  new ResponseEntity(todos, HttpStatus.OK);
    }
}
