package info.thecodinglive.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JpubRuntimeException extends RuntimeException {
	private final JpubErrorDetail jpubErrorDetail;

	private String errorCode;
	private String message;

	public JpubRuntimeException(String message, String errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
		this.jpubErrorDetail = null;
	}

	public JpubRuntimeException(String message) {
		super(message);
		this.message = message;
		this.jpubErrorDetail = null;
	}

	public JpubRuntimeException(JpubErrorDetail jpubErrorDetail) {
		super(jpubErrorDetail.getErrorMessage());
		this.jpubErrorDetail = jpubErrorDetail;
	}

	public JpubRuntimeException(JpubErrorDetail jpubErrorDetail, Throwable cause) {
		super(jpubErrorDetail.getErrorMessage(), cause);
		this.jpubErrorDetail = jpubErrorDetail;
	}
}
