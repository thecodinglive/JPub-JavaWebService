package info.thecodinglive.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.thecodinglive.member.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
	Member findByUsername(String username);
}
