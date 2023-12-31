package info.thecodinglive.controller.basic;

import static org.springframework.http.HttpStatus.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.User;

@RestController
public class UserController {
    private static List<User> userList = new ArrayList<>();

    {
        userList.add(new User(1, "jpub01", "user01@test.com", "remine", new Date()));
        userList.add(new User(2, "jpub02", "user02@test.com", "restart", new Date()));
        userList.add(new User(3, "jpub03", "user03@test.com", "nine", new Date()));
        userList.add(new User(4, "jpub04", "user04@test.com", "namu", new Date()));
    }

    @GetMapping(value = "/user/{userNo}")
    public ResponseEntity<User> getuserInfo(@PathVariable int userNo) {
        User user = userList.get(userNo);
        return new ResponseEntity(user, OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUserList() {
        HashMap<String, Object> resultList = new HashMap();
        resultList.put("result", userList);
        return new ResponseEntity(resultList, OK);
    }
}
