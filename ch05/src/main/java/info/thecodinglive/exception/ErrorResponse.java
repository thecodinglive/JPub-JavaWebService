package info.thecodinglive.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private String errorCode;
	private String errorMessage;
	@JsonIgnore
	private HttpStatus httpStatus;

	public ErrorResponse(JpubErrorDetail jpubErrorDetail) {
		this.errorCode = jpubErrorDetail.getErrorCode();
		this.errorMessage = jpubErrorDetail.getErrorMessage();
		this.httpStatus = jpubErrorDetail.getHttpStatus();
	}
}
