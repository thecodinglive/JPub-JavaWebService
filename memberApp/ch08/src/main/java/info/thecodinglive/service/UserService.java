package info.thecodinglive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<UserVO> findAllUserInfo(){
        Iterable<UserVO> allUsers = userRepository.getUserInfoAll();
        return allUsers;
    }

    public void dummyInfo(){
        ServletUriComponentsBuilder.fromCurrentRequest()
                .toUriString();
    }

    public void createUser(UserVO userVO){
        System.out.println("userVO::" + userVO.toString());
        userRepository.adduserInfo(userVO);
    }

    public Iterable<? extends UserVO> findByLikeUserName(String userName){
        Iterable<UserVO> resultList = userRepository.findByUserNameLike(userName);
        return resultList;
    }

    public UserVO findByOneUserName(String userName){
        UserVO userVO = userRepository.findByUserName(userName);
        return userVO;
    }
}
