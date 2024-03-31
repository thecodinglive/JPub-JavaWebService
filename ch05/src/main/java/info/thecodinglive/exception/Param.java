package info.thecodinglive.exception;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class Param {
	@NotBlank
	private String reqId;
	private String name;
}
