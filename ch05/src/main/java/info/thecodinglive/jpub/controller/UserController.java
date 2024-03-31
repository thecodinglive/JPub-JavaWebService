package info.thecodinglive.jpub.controller;

import info.thecodinglive.model.User;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class UserController {
	private static List<User> userList = new ArrayList<User>();

	{
		userList.add(new User(1, "jpub01", "user01@test.com", "remine", new Date()));
		userList.add(new User(2, "jpub02", "user02@test.com", "restart", new Date()));
		userList.add(new User(3, "jpub03", "user03@test.com", "nine", new Date()));
		userList.add(new User(4, "jpub04", "user04@test.com", "namu", new Date()));
	}

	@RequestMapping("/user/{userNo}")
	public ResponseEntity<User> getuserInfo(@PathVariable int userNo) {
		User user = userList.get(userNo);
		return new ResponseEntity(user, OK);
	}

	@RequestMapping("/user")
	public ResponseEntity<List<User>> getUserList() {
		HashMap<String, Object> resultList = new HashMap();
		resultList.put("result", userList);
		return new ResponseEntity(resultList, OK);
	}


	@PostMapping("/api/v1/user")
	@Operation
	public ResponseEntity<?> user(@RequestBody @Valid User user) {
		userAdd(user);
		return ResponseEntity.ok().body(new User());
	}

	private void userAdd(User user) {
		System.out.println("user: " + user.toString());
	}
}
