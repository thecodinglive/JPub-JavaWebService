package info.thecodinglive.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum JpubErrorDetail {
	PARAM_VALID_ERROR(HttpStatus.BAD_REQUEST, "A400", "잘못된 요청입니다.");

	JpubErrorDetail(HttpStatus httpStatus, String errorCode, String errorMessage) {
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	private final HttpStatus httpStatus;
	private final String errorCode;
	private final String errorMessage;
}
