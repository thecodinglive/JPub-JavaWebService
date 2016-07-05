package info.thecodinglive.controller;

import info.thecodinglive.model.Todo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping(value = "/basic")
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/todo")
    public Todo basic(){
        return new Todo(counter.incrementAndGet(),"라면사오기");
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle){
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todor", method = RequestMethod.POST)
    public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle){
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public Todo getPath(@PathVariable int todoId){
         Todo todo1 = new Todo(1L, "문서쓰기");
         Todo todo2 = new Todo(2L, "기획회의");
         Todo todo3 = new Todo(3L, "운동");

        Map<Integer,Todo> todoMap = new HashMap<>();
        todoMap.put(1, todo1);
        todoMap.put(2, todo2);
        todoMap.put(3, todo3);

        return todoMap.get(todoId);
    }

}
