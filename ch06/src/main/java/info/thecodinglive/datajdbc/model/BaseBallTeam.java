package info.thecodinglive.datajdbc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BaseBallTeam(
	Long id,
	String teamName,
	String teamColor,
	String city,
	String stadium,

	LocalDate establishedYear,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
