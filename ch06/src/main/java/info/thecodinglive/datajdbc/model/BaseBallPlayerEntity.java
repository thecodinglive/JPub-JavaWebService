package info.thecodinglive.datajdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "player")
public class BaseBallPlayerEntity implements Persistable<Long> {
	@Id
	private Long id;
	private boolean isNew;

	private Player player;

	public BaseBallPlayerEntity(Player player, boolean isNew) {
		this.player = player;
		this.isNew = isNew;
	}

	@Override
	public Long getId() {
		return player.id();
	}

	@Override
	public boolean isNew() {
		return isNew;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
}

