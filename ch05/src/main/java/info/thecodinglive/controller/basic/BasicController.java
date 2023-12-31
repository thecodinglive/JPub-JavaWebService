package info.thecodinglive.controller.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.Todo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "basicController")
@RestController
@RequestMapping(value = "/api/basic")
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @Operation(summary = "todo 생성")
    @PostMapping(value = "/v1/todo")
    public Todo basic(){
        return new Todo(counter.incrementAndGet(),"라면사오기");
    }
    @Operation(summary = "todo 제목을 입력하여 생성")
    @ApiResponse(responseCode = "400", description = "파라메터를 입력하지 않으셨습니다.")
    @PostMapping(value = "/v1/todor")
    public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle){
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @Operation(summary = "todo 아이디로 단건 조회")
    @GetMapping(value = "/v1/todos/{todoId}")
    public Todo getPath(@PathVariable int todoId){
         Todo todo1 = new Todo(1L, "문서쓰기");
         Todo todo2 = new Todo(2L, "기획회의");
         Todo todo3 = new Todo(3L, "운동");

        Map<Integer,Todo> todoMap = new HashMap();
        todoMap.put(1, todo1);
        todoMap.put(2, todo2);
        todoMap.put(3, todo3);

        return todoMap.get(todoId);
    }
}
