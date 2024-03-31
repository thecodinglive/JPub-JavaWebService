package info.thecodinglive.validator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookCover implements HasIsbn {
	private String isbn;
	@NotBlank(message = "url not empty")
	private String url;
	private String imgType;

	@JsonIgnore
	@Builder.Default
	private String[] allowTypes = {"M", "G", "I"};
}
