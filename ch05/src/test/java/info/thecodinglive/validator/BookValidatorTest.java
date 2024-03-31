package info.thecodinglive.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookValidatorTest {
	private BookValidator bookValidator;
	private Errors errors;

	private BookCover bookCover;
	private Book book;

	@BeforeEach
	void setUp() {
		bookValidator = new BookValidator();
		bookValidator.registerValidators();
	}

	@Test
	void bookTypeCheck() {
		assertTrue(HasIsbn.class.isAssignableFrom(Book.class));
	}

	@Test
	void validTestBook() {
		book = new Book();
		errors = new BeanPropertyBindingResult(book, "book");
		book.setIsbn("979-11-6224-090-8");
		book.setTitle("신작소설만관부");

		bookValidator.validate(book, errors);

		assertTrue(errors.hasFieldErrors("title"));
	}

	@Test
	void validIsbnEmpty() {
		book = new Book();
		book.setIsbn(null);
		book.setTitle("그릿");
		errors = new BeanPropertyBindingResult(book, "book");

		bookValidator.validate(book, errors);

		System.out.println(errors.hasErrors());
		System.out.println(errors.getFieldError());
	}

	@Test
	void validBookCover() {
		book = new Book();
		book.setIsbn("979-11-6224-090-8");
		book.setTitle("가짜노동");
		BookCover cover = BookCover.builder()
			.isbn(book.getIsbn())
			.imgType("I")
			.url("http://blog.naver.com/img/1111.jpg")
			.build();
		errors = new BeanPropertyBindingResult(cover, "cover");

		bookValidator.validate(cover, errors);

		System.out.println(errors.hasErrors());
		System.out.println(errors.getFieldError());
	}
}
