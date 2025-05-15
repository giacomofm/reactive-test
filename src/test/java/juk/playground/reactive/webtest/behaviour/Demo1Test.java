package juk.playground.reactive.webtest.behaviour;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Demo1Test {

	@Autowired
	private Demo1 demo;

	@Test
	void throwOnSub() {
		assertTrue(demo.throwOnSub());
	}

}
