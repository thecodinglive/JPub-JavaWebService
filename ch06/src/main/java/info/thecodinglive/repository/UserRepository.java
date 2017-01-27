package info.thecodinglive.repository;

import info.thecodinglive.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
    UserEntity findByUsername(@Param("username") String username);
}
