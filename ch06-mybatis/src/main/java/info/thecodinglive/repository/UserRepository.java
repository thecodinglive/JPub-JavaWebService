package info.thecodinglive.repository;

        import org.mybatis.spring.SqlSessionTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;

        import java.util.List;

/**
 * Created by yun_dev1 on 2017-01-06.
 */
@Repository
public class UserRepository {
    private static final String MAPPER_NAME_SPACE="sample.mapper.userMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List getUserInfoAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
    }


}
