package info.thecodinglive.datajdbc.model;

import java.time.LocalDateTime;

public record Player(
	Long id,
	String name,
	Long teamId,
	String position,
	Integer birthYear,

	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
