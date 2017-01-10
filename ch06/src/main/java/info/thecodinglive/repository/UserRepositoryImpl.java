package info.thecodinglive.repository;


import com.mysema.query.jpa.JPQLQuery;
import info.thecodinglive.model.QUserEntity;
import info.thecodinglive.model.UserEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by yun_dev1 on 2016-12-26.
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom{

    public UserRepositoryImpl() {
        super(UserEntity.class);
    }




    @Override
    public int maxAge() {
        QUserEntity quserEntity = QUserEntity.userEntity;
        return from(quserEntity).uniqueResult(quserEntity.age.max());
    }

    @Override
    public int minAge() {
        QUserEntity quserEntity = QUserEntity.userEntity;
        return from(quserEntity).uniqueResult(quserEntity.age.min());
    }

    @Override
    public List findAllLike(String keyword){
        QUserEntity qUserEntity = QUserEntity.userEntity;
        JPQLQuery query = from(qUserEntity);
        List resultList = query
                .where(qUserEntity.username.like(keyword))
                .fetch()
                .list(qUserEntity);

        return resultList;
    }

    /*
    @Override
    public Page findAdmin(UserRole userRole) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        JPQLQuery query = from(qUserEntity);
        NumberPath<Integer> adminCheck = new NumberPath<Integer>(Integer.class, qUserEntity, "adminCheck");
        //EnumPath<UserRole>  roleCheck = new EnumPath<UserRole>(UserRole.class, qUserEntity, "roleCheck");
        ParamExpression<UserRole> roleCheck = new ParamExpressionImpl<UserRole>(UserRole.class, "roleCheck");


        PageRequest pr = new PageRequest(0, 10, new Sort(
                new Sort.Order(Sort.Direction.DESC, "name")
        ));

        SearchResults<UserEntity> results = query
                .set(roleCheck, UserRole.ADMIN)
                .limit(pr.getPageSize())
                .offset(pr.getOffset())
                .listResults(qUserEntity);

        return new PageImpl<>(results.getResults(), pr, results.getTotal());
    }
    */

}
