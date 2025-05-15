package juk.playground.reactive.webtest.httpbin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@Disabled
@SpringBootTest
class HttpMethodsClientTest {

	@Autowired
	private HttpMethodsClient client;

	@Test
	void get() {
		StepVerifier.create(client.get())
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@Test
	void post() {
		StepVerifier.create(client.post())
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@Test
	void put() {
		StepVerifier.create(client.put())
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@Test
	void patch() {
		StepVerifier.create(client.patch())
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@Test
	void delete() {
		StepVerifier.create(client.delete())
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

}
