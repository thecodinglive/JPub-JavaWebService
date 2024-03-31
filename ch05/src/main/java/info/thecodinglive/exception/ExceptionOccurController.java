package info.thecodinglive.exception;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionOccurController {

	@GetMapping("/v1/exception")
	public String getException() {
		throw new JpubRuntimeException("이미 등록된 사용자입니다.", "AA001");
	}

	@GetMapping("/v1/param")
	public String getParam(@Valid @RequestBody Param param) {
		System.out.println(param);
		return "OK";
	}


	@ExceptionHandler(JpubRuntimeException.class)
	public ResponseEntity<ErrorInfo> handleJpubException(JpubRuntimeException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ErrorInfo(ex));
	}

	@Getter
	private class ErrorInfo {
		public ErrorInfo(JpubRuntimeException ex) {
			this.errorCode = ex.getErrorCode();
			this.errorMessage = ex.getMessage();
		}

		private String errorCode;
		private String errorMessage;
	}
}
