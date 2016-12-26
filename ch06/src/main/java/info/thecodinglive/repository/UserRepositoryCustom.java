package info.thecodinglive.repository;

import info.thecodinglive.model.QUserEntity;
import info.thecodinglive.model.UserEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Iterator;

/**
 * Created by jins on 2016-12-27.
 */

public abstract class UserRepositoryCustom extends QueryDslRepositorySupport{
    public UserRepositoryCustom(Class<UserEntity> user) {
        super(user);
    }
    public int minUserAge(){
        QUserEntity quserEntity = QUserEntity.userEntity;
        return from(quserEntity).uniqueResult(quserEntity.age.min());
    }
    public int maxUserAge(){
        QUserEntity quserEntity = QUserEntity.userEntity;
        return from(quserEntity).uniqueResult(quserEntity.age.max());
    }
}
