package info.thecodinglive.datajdbc.model;

import info.thecodinglive.datajdbc.repository.UserRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
public class EntityMappingTest {

	@Autowired
	private RelationalMappingContext mappingContext;
	@MockBean
	private UserRepositoryService userRepositoryService;


	@Test
	void testTableMapping() {
		String tableName = mappingContext.getRequiredPersistentEntity(UserEntity.class).getTableName().toString();


		assertThat(tableName).isEqualTo("jpub_user");
	}
}
