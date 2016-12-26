package info.thecodinglive.repository;


import info.thecodinglive.model.QUserEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Created by yun_dev1 on 2016-12-26.
 */
public class UserRepositorySupport extends QueryDslRepositorySupport{
    public UserRepositorySupport(Class<?> domainClass) {
        super(domainClass);
    }

    public int minUserAge(){
        QUserEntity userEntity = QUserEntity.userEntity;



        return from(userEntity).uniqueResult(userEntity.age.min());
    }
}
