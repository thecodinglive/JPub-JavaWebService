package info.thecodinglive.datajdbc.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "baseballTeam")
public class BaseBallTeamEntity implements Persistable<Long> {
	private final BaseBallTeam baseBallTeam;

	@Id
	private Long id;
	private boolean isNew;

	public BaseBallTeamEntity(BaseBallTeam baseBallTeam, boolean isNew) {
		this.baseBallTeam = baseBallTeam;
		this.id = baseBallTeam.id();
		this.isNew = isNew;
	}

	@Override
	public Long getId() {
		return baseBallTeam.id();
	}

	@Override
	public boolean isNew() {
		return isNew;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
}
