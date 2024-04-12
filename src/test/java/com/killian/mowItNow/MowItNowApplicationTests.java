package com.killian.mowItNow;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MowItNowApplicationTests {
	static final String RESOURCES_PATH = "src/test/resources/"; 

	@Test
	public void main_basic_test() throws IllegalArgumentException, IOException {
		String[] test = {RESOURCES_PATH + "basic_test.txt"};
		MowItNowApplication.main(test);
	}

	@Test
	public void main_no_arg() throws IllegalArgumentException, IOException {
		String[] test = {};
		assertThrows(IllegalArgumentException.class, () -> {
			MowItNowApplication.main(test);
		});
	}

	@Test
	public void main_many_args() throws IllegalArgumentException, IOException {
		String[] test = {"test.txt", "toto.txt"};
		assertThrows(IllegalArgumentException.class, () -> {
			MowItNowApplication.main(test);
		});
	}

	@Test
	public void main_wrong_file() throws IllegalArgumentException, IOException {
		String[] test = {"test.txt"};
		assertThrows(IOException.class, () -> {
			MowItNowApplication.main(test);
		});
	}
}
