package info.thecodinglive.service;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Created by yun_dev1 on 2017-01-24.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Iterable<UserVO>> findAllUserInfo(){
        Iterable<UserVO> allUsers = userRepository.getUserInfoAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public void dummyInfo(){
        ServletUriComponentsBuilder.fromCurrentRequest()
                .toUriString();
    }

    public ResponseEntity<?> createUser(UserVO userVO){
        userRepository.adduserInfo(userVO);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    public ResponseEntity<?> findByLikeUserName(String userName){
        Iterable<UserVO> resultUsers = userRepository.findByUserNameLike(userName);
        return new ResponseEntity<Object>(resultUsers, HttpStatus.OK);
    }

    public ResponseEntity<?> findByOneUserName(String userName){
        UserVO userVO = userRepository.findByUserName(userName);
        return new ResponseEntity<Object>(userVO, HttpStatus.OK);
    }

}
