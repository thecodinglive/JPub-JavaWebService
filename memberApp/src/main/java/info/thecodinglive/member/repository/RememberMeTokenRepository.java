package info.thecodinglive.member.repository;

import info.thecodinglive.member.model.RememberMeToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RememberMeTokenRepository extends JpaRepository<RememberMeToken, String>{
    RememberMeToken findBySeries(String series);
    List<RememberMeToken> findByUsername(String username);
}
