package info.thecodinglive.validator;

import lombok.*;


@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	private String errorCode;
	private String message;
}
