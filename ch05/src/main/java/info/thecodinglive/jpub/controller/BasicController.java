package info.thecodinglive.jpub.controller;

import info.thecodinglive.model.Todo;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Tag(name = "basicController")
@RestController
@RequestMapping(value = "/api/basic")
public class BasicController {
	private final AtomicLong counter = new AtomicLong();

	private static Map<Integer, Todo> generateTodos() {
		Todo todo1 = new Todo(1L, "문서쓰기");
		Todo todo2 = new Todo(2L, "기획회의");
		Todo todo3 = new Todo(3L, "운동");

		Map<Integer, Todo> todoMap = new HashMap<>();
		todoMap.put(1, todo1);
		todoMap.put(2, todo2);
		todoMap.put(3, todo3);
		return todoMap;
	}

	@Operation
	@GetMapping(value = "/v1/todo")
	public Todo basic() {
		return new Todo(counter.incrementAndGet(), "라면사오기");
	}

	@Operation
	@PostMapping(value = "/v1/todo")
	public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
		return new Todo(counter.incrementAndGet(), todoTitle);
	}

	@ApiResponse(responseCode = "400", description = "파라메터를 입력하지 않으셨습니다.")
	@Operation
	@PostMapping(value = "/v1/todo-title")
	public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle) {
		return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.OK);
	}

	@Hidden
	@Operation
	@GetMapping("/v1/hidden")
	public String hiddenOk() {
		return "OK";
	}


	@Operation
	@GetMapping(value = "/v1/todos/{todoId}")
	public Todo getPath(@Parameter(name = "todoId") @PathVariable Integer todoId) {
		Map<Integer, Todo> todoMap = generateTodos();

		return todoMap.get(todoId);
	}

	@Operation
	@GetMapping("/v1/todo/header/{todoId}")
	public Todo getTodoWIthHeader(@Parameter(name = "todoId") @PathVariable Integer todoId, @RequestHeader("reqPlatform") String reqPlatform) {
		System.out.println(reqPlatform);
		return generateTodos().get(todoId);
	}
}
