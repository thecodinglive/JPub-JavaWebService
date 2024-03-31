package info.thecodinglive.validator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Book implements HasIsbn {
	private String isbn;
	private String title;
}
