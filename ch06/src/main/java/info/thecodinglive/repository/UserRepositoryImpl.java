package info.thecodinglive.repository;


import com.mysema.query.annotations.QueryEntity;
import info.thecodinglive.model.QUserEntity;
import info.thecodinglive.model.UserEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * Created by yun_dev1 on 2016-12-26.
 */
public class UserRepositoryImpl extends  UserRepositoryCustom{
    public UserRepositoryImpl(Class<UserEntity> user) {
        super(user);
    }

    @Override
    public int minUserAge(){
        QUserEntity quserEntity = QUserEntity.userEntity;
       return from(quserEntity).uniqueResult(quserEntity.age.min());
    }
    @Override
    public int maxUserAge(){
        QUserEntity quserEntity = QUserEntity.userEntity;
        return from(quserEntity).uniqueResult(quserEntity.age.max());
    }
}
