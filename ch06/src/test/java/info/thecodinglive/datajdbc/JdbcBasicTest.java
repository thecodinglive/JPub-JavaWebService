package info.thecodinglive.datajdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JdbcBasicTest {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void setup() {
		dataSource = Mockito.mock(DataSource.class);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Test
	void executeQueryMockTest() throws SQLException {
		Connection connection = Mockito.mock(Connection.class);
		PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
		ResultSet resultSet = Mockito.mock(ResultSet.class);


		when(resultSet.next()).thenReturn(true, false);
		when(resultSet.getInt("COLUMN1")).thenReturn(77);

		when(dataSource.getConnection()).thenReturn(connection);
		when(connection.prepareStatement("SELECT COLUMN1 FROM NW_TABLE WHERE ID = ?")).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(resultSet);

		List<Integer> values = jdbcTemplate.query("SELECT COLUMN1 FROM NW_TABLE WHERE ID = ?", (rs, rowNum) -> rs.getInt("COLUMN1"), 123);
		assertThat(values).containsExactly(77);


		verify(dataSource).getConnection();
		verify(connection).prepareStatement("SELECT COLUMN1 FROM NW_TABLE WHERE ID = ?");
		verify(preparedStatement).setObject(1, 123);
		verify(preparedStatement).executeQuery();
		verify(resultSet, Mockito.times(2)).next();
		verify(resultSet).getInt("COLUMN1");

		verify(resultSet).close();
		verify(preparedStatement).close();
		verify(connection).close();
	}
}
