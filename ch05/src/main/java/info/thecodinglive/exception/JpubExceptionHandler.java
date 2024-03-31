package info.thecodinglive.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "info.thecodinglive")
public class JpubExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(JpubExceptionHandler.class);

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintError(ConstraintViolationException ex, HttpServletRequest request) {
		LOG.error("parameter validation error req url: {}, method: {}, param: {}", request.getRequestURL(), request.getMethod(), request.getParameterMap());
		ErrorResponse errorResponse = new ErrorResponse(JpubErrorDetail.PARAM_VALID_ERROR);

		return ResponseEntity.status(JpubErrorDetail.PARAM_VALID_ERROR.getHttpStatus())
			.body(errorResponse);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		super.handleHttpMessageNotReadable(ex, headers, status, request);
		ErrorResponse errorResponse = new ErrorResponse(JpubErrorDetail.PARAM_VALID_ERROR);
		return ResponseEntity.status(JpubErrorDetail.PARAM_VALID_ERROR.getHttpStatus())
			.body(errorResponse);
	}

	@ExceptionHandler(JpubRuntimeException.class)
	public ResponseEntity<ErrorResponse> handleJpubException(JpubRuntimeException ex, HttpServletRequest request) {
		LOG.error("jpub runtime error req url: {}, method: {}, param: {}", request.getRequestURL(), request.getMethod(), request.getParameterMap());
		ErrorResponse errorResponse = new ErrorResponse(ex.getJpubErrorDetail());

		return ResponseEntity.status(ex.getJpubErrorDetail().getHttpStatus())
			.body(errorResponse);
	}
}
