package info.thecodinglive.datajdbc.repository;

import info.thecodinglive.datajdbc.model.BaseBallPlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<BaseBallPlayerEntity, Long> {
}
