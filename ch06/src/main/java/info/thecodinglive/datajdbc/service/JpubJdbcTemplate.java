package info.thecodinglive.datajdbc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpubJdbcTemplate {
	private final JdbcTemplate jdbcTemplate;


	public void add() {
		//jdbcTemplate.query();
	}
}
