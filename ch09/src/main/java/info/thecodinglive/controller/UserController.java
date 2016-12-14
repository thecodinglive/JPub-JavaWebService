package info.thecodinglive.controller;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yun_dev1 on 2016-09-02.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("{userId}")
    public UserEntity getUserInfo(@PathVariable Long userId){
        UserEntity user = userRepository.findOne(userId);

        return user;
    }
}
