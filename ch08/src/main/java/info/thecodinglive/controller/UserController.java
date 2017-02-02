package info.thecodinglive.controller;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yun_dev1 on 2017-01-24.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResponseEntity<?> findUserInfoAll() throws Exception{
        return new ResponseEntity(userService.findAllUserInfo(), HttpStatus.OK);
    }

    @RequestMapping("/regist")
    public ResponseEntity<?> registUser(@RequestBody UserVO userVO){
        userService.createUser(userVO);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<?> findUserListbyNames(@RequestParam("username") String userName){
        return new ResponseEntity(userService.findByLikeUserName(userName), HttpStatus.OK);
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName){
        return new ResponseEntity(userService.findByOneUserName(userName), HttpStatus.OK);
    }
}
