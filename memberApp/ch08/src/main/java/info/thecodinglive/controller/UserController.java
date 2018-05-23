package info.thecodinglive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.exception.UserNotFoundException;
import info.thecodinglive.model.UserVO;
import info.thecodinglive.service.UserService;

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

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ResponseEntity<?> registUser(@Validated @RequestBody UserVO userVO){
        System.out.println("controller vo check::" + userVO.toString() );
        userService.createUser(userVO);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<?> findUserListbyNames(@RequestParam("username") String userName){
        return new ResponseEntity(userService.findByLikeUserName(userName), HttpStatus.OK);
    }

    @RequestMapping("/{username}")
    public ResponseEntity<?> findByUserOne(@PathVariable("username") String userName){
        UserVO user = userService.findByOneUserName(userName);
        if(user == null){
            throw new UserNotFoundException("user not found");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
