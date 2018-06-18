package info.thecodinglive.member.support;

import info.thecodinglive.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import info.thecodinglive.member.service.MemberService;

@Component
public class MemberValidator implements Validator{
	@Autowired
	private MemberService memberService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (member.getUsername().length() < 3 || member.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}

		if (memberService.findByUserName(member.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		if (memberService.findByUserEmail(member.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.userForm.email");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (member.getPassword().length() < 7 || member.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!member.getPasswordConfirm().equals(member.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}

	}
}
