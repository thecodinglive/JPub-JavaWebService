package info.thecodinglive.repository;

import info.thecodinglive.model.UserRole;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by jins on 2016-12-27.
 */

public interface UserRepositoryCustom {

    int maxAge();
    int minAge();

    List findAllLike(String keyword);

    Page findAdmin(UserRole userRole);


}
