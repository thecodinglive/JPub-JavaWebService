package info.thecodinglive.handlermapping.requestmapping;

public class CustomGetMock {
	@CustomGet("/custom")
	public String customGetRequest() {
		return "hello from custom get";
	}
}
