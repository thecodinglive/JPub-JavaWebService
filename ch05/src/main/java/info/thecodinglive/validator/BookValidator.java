package info.thecodinglive.validator;

import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@NoArgsConstructor
@Component
public class BookValidator implements Validator {
	private final Map<Class<?>, BiConsumer<Object, Errors>> validators = new HashMap<>();

	@PostConstruct
	void init() {
		System.out.println("init");
		registerValidators();
	}

	public void registerValidators() {
		System.out.println("register");
		//isbn
		BiConsumer<Object, Errors> isbnValidator = (obj, errors) -> {
			HasIsbn isbn = (HasIsbn) obj;
			if (StringUtils.isEmpty(isbn.getIsbn())) {
				errors.rejectValue("isbn", "isbn.invalid", "isbn must be not empty");
			}
		};

		BiConsumer<Object, Errors> bookValidator = (obj, errors) -> {
			Book book = (Book) obj;
			if (StringUtils.isEmpty(book.getTitle()) ||
				book.getTitle().codePointCount(0, book.getTitle().length()) > 5) {
				errors.rejectValue("title", "title.invalid");
			}
		};

		BiConsumer<Object, Errors> bookCoverValidator = (obj, errors) -> {
			BookCover cover = (BookCover) obj;

			if (StringUtils.isEmpty(cover.getUrl()) || StringUtils.isEmpty(cover.getImgType())) {
				errors.reject("bookCover npe");
				return;
			}

			boolean isInvalidContainType = Arrays.stream(cover.getAllowTypes())
				.anyMatch(cover.getImgType()::contains);

			if (!isInvalidContainType) {
				errors.rejectValue("imgType", "imgType.invalid");
			}

			if (!cover.getUrl().startsWith("http://img.jpub.com")) {
				errors.rejectValue("url", "url domain error");
			}
		};

		validators.put(HasIsbn.class, isbnValidator);
		validators.put(Book.class, bookValidator);
		validators.put(BookCover.class, bookCoverValidator);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return HasIsbn.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof HasIsbn) {
			validators.get(HasIsbn.class).accept(target, errors);
		}

		validators.getOrDefault(target.getClass(), (obj, errs) -> {
			})
			.accept(target, errors);
	}
}
