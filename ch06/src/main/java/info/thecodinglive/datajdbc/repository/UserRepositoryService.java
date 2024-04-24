package info.thecodinglive.datajdbc.repository;

import info.thecodinglive.datajdbc.model.BaseBallPlayerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserRepositoryService {
	private final PlayerRepository playerRepository;

	public void createUser(BaseBallPlayerEntity player) {
		try {
			//playerRepository.save(new Player());
		} catch (Exception e) {

		}
	}

	public void updateNickName(String nickName) {
	}

}
