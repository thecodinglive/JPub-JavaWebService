package info.thecodinglive.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.UserVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yun_dev1 on 2017-01-06.
 */
@Repository
public class UserRepository {
    private static final String MAPPER_NAME_SPACE = "sample.mapper.userMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List getUserInfoAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
    }

    public void adduserInfo(UserVO userVO){
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE+ "addUserInfo", userVO);
    }

    public List findByUserNameLike(String userName){
        Map<String,Object> params = new HashMap();
        params.put("userName", userName);

        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserNameLike", params);
    }

    public UserVO findByUserName(String userName){
        Map<String,Object> params = new HashMap();
        params.put("userName", userName);

        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "findByUserName", params);
    }


}
