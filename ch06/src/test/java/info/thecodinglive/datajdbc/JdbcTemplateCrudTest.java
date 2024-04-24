package info.thecodinglive.datajdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JdbcTemplateCrudTest {
	private JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
	private JdbcTemplateCrud jdbcTemplateCrud = new JdbcTemplateCrud(jdbcTemplate);

	@Test
	void createTest() {
		JpubUser jpubUser = new JpubUser(1L, "꾀돌이");
		when(jdbcTemplate.update(eq("INSERT INTO JPUB_USER (id, name) VALUES (?, ?)"), any(Object[].class))).thenReturn(1);

		JpubUser createdJpubUser = jdbcTemplateCrud.create(jpubUser);

		assertThat(createdJpubUser).isEqualTo(jpubUser);
	}

	@Test
	void readTest() {
		long jpubUserId = 1L;
		JpubUser jpubUser = new JpubUser(jpubUserId, "꾀돌이");
		when(jdbcTemplate.queryForObject(eq("SELECT id, name FROM JPUB_USER WHERE id = ?"), any(RowMapper.class), eq(jpubUserId))).thenReturn(jpubUser);

		// Act
		Optional<JpubUser> readJpubUser = jdbcTemplateCrud.read(jpubUserId);

		// Assert
		assertThat(readJpubUser).isPresent();
		assertThat(readJpubUser.get()).isEqualTo(readJpubUser.get());
		verify(jdbcTemplate).queryForObject(eq("SELECT id, name FROM JPUB_USER WHERE id = ?"), any(RowMapper.class), eq(jpubUserId));
	}

	@Test
	void updateTest() {
		JpubUser jpubUser = new JpubUser(1L, "집돌이");
		when(jdbcTemplate.update(eq("UPDATE JPUB_USER SET name = ? WHERE id = ?"), any(Object[].class))).thenReturn(1);

		JpubUser updatedJpubUser = jdbcTemplateCrud.update(jpubUser);


		assertThat(updatedJpubUser).isEqualTo(jpubUser);
	}

	@Test
	void deleteTest() {
		long personId = 1L;
		when(jdbcTemplate.update(eq("DELETE FROM JPUB_USER WHERE id = ?"), eq(personId))).thenReturn(1);

		boolean deleted = jdbcTemplateCrud.delete(personId);
		assertThat(deleted).isTrue();
	}


	@Getter
	@Setter
	@ToString
	private static class JpubUser {
		private Long id;
		private String nickName;

		public JpubUser(Long id, String nickName) {
			this.id = id;
			this.nickName = nickName;
		}
	}

	private static class JdbcTemplateCrud {
		private final JdbcTemplate jdbcTemplate;

		JdbcTemplateCrud(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		JpubUser create(JpubUser jpubUser) {
			jdbcTemplate.update("INSERT INTO JPUB_USER (id, name) VALUES (?, ?)", jpubUser.getId(), jpubUser.getNickName());
			return jpubUser;
		}

		Optional<JpubUser> read(long id) {
			return Optional.ofNullable(jdbcTemplate.queryForObject(
				"SELECT id, name FROM JPUB_USER WHERE id = ?",
				new JpubRowMapper(),
				id
			));
		}

		JpubUser update(JpubUser jpubUser) {
			jdbcTemplate.update("UPDATE JPUB_USER SET name = ? WHERE id = ?", jpubUser.getNickName(), jpubUser.getId());
			return jpubUser;
		}

		boolean delete(long id) {
			return jdbcTemplate.update("DELETE FROM JPUB_USER WHERE id = ?", id) > 0;
		}

		List<JpubUser> readAll() {
			return jdbcTemplate.query("SELECT id, nickname FROM JPUB_USER", new JpubRowMapper());
		}

		private static class JpubRowMapper implements RowMapper<JpubUser> {
			@Override
			public JpubUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new JpubUser(rs.getLong("id"), rs.getString("nickname"));
			}
		}
	}
}
