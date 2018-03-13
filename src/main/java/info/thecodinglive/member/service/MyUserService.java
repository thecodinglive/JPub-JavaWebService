package info.thecodinglive.member.service;

import java.util.HashSet;
import java.util.Set;

import info.thecodinglive.member.model.Member;
import info.thecodinglive.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class MyUserService implements UserDetailsService{
	@Autowired
    MemberRepository memberRepository;

	private static final String ROLE_PREFIX = "ROLE_";

	@PostConstruct
	private void created(){
		log.debug("체크 로그인");
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("loadUserByUsername user id {} ", email);

		Member member = memberRepository.findByEmail(email);
		log.debug("member", member.toString());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

			grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + member.getRole().name()));
		log.debug("권한체크:", grantedAuthorities.toString());
		return new User(member.getUsername(), member.getPassword(), grantedAuthorities);
	}
}
