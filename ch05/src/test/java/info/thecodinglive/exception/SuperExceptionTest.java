package info.thecodinglive.exception;

import org.junit.jupiter.api.Test;

public class SuperExceptionTest {

	public void method1() {
		method2();
	}

	public void method2() {
		method3();
	}

	public void method3() {
		throw new CustomException("Error exception");
	}

	@Test
	void method1Call() {
		try {
			method1();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
	}


	@Test
	public void methodA() {
		methodB();
	}

	public void methodB() {
		methodC();
	}

	public void methodC() {
		throw new SuperCallException("super exception");
	}

	@Test
	void methodACall() {
		try {
			methodA();
		} catch (SuperCallException e) {
			System.err.println(e.getMessage());
		}
	}


	private static class CustomException extends RuntimeException {
		private String message;

		public CustomException(String message) {
			this.message = message;
		}
	}

	private static class SuperCallException extends RuntimeException {
		private String message;

		public SuperCallException(String message) {
			super(message);
			this.message = message;
		}
	}
}
