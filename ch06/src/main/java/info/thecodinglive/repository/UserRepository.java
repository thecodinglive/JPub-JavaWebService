package info.thecodinglive.repository;

import info.thecodinglive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yun_dev1 on 2016-07-29.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
