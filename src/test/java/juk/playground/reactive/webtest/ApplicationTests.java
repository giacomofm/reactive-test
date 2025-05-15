package juk.playground.reactive.webtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Value("${spring.application.name}")
	private String appName;

	@Test
	void contextLoads() {
		assertEquals("reactive-webtest", appName);
	}

}
