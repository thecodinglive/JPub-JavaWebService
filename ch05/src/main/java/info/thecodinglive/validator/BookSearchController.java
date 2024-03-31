package info.thecodinglive.validator;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookSearchController {
	private final BookValidator bookValidator;

	public BookSearchController(BookValidator bookValidator) {
		this.bookValidator = bookValidator;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(bookValidator);
	}

	@PostMapping("/api/v1/book")
	@Operation
	public ResponseEntity<?> newBook(@RequestBody @Validated Book book, BindingResult result) {
		System.out.println("book: " + book);

		if (result.hasErrors()) {
			return ResponseEntity.badRequest()
				.body(ErrorResponse.builder()
					.errorCode(result.getFieldError().getCode().toString())
					.build());
		}

		return ResponseEntity.ok().body(BookResponse.EMPTY);
	}
}
