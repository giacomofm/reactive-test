package juk.playground.reactive.webtest.httpbin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.test.StepVerifier;

import java.util.List;

@Disabled
@SpringBootTest
class StatusCodesClientTest {

	@Autowired
	private StatusCodesClient client;

	record StatusErrorVerifier(
			HttpStatusCode statusCode,
			Class<? extends WebClientResponseException> exceptionClass
	) {}

	static List<StatusErrorVerifier> errors4xxAnd5xx() {
		return List.of(new StatusErrorVerifier(HttpStatus.BAD_REQUEST, WebClientResponseException.BadRequest.class),
				new StatusErrorVerifier(HttpStatus.UNAUTHORIZED, WebClientResponseException.Unauthorized.class),
				new StatusErrorVerifier(HttpStatus.FORBIDDEN, WebClientResponseException.Forbidden.class),
				new StatusErrorVerifier(HttpStatus.NOT_FOUND, WebClientResponseException.NotFound.class),
				new StatusErrorVerifier(HttpStatus.METHOD_NOT_ALLOWED,
						WebClientResponseException.MethodNotAllowed.class),
				new StatusErrorVerifier(HttpStatus.INTERNAL_SERVER_ERROR,
						WebClientResponseException.InternalServerError.class),
				new StatusErrorVerifier(HttpStatus.SERVICE_UNAVAILABLE,
						WebClientResponseException.ServiceUnavailable.class));
	}

	@Test
	void get200() {
		StepVerifier.create(client.get(HttpStatus.OK))
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@ParameterizedTest
	@MethodSource("errors4xxAnd5xx")
	void statusGetError4xxAnd5xx(StatusErrorVerifier statusErrorVerifier) {
		StepVerifier.create(client.get(statusErrorVerifier.statusCode)).verifyError(statusErrorVerifier.exceptionClass);
	}

	@Test
	void post200() {
		StepVerifier.create(client.post(HttpStatus.OK))
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@ParameterizedTest
	@MethodSource("errors4xxAnd5xx")
	void statusPostError4xxAnd5xx(StatusErrorVerifier statusErrorVerifier) {
		StepVerifier.create(client.post(statusErrorVerifier.statusCode))
				.verifyError(statusErrorVerifier.exceptionClass);
	}

	@Test
	void put200() {
		StepVerifier.create(client.put(HttpStatus.OK))
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@ParameterizedTest
	@MethodSource("errors4xxAnd5xx")
	void statusPutError4xxAnd5xx(StatusErrorVerifier statusErrorVerifier) {
		StepVerifier.create(client.put(statusErrorVerifier.statusCode)).verifyError(statusErrorVerifier.exceptionClass);
	}

	@Test
	void patch200() {
		StepVerifier.create(client.patch(HttpStatus.OK))
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@ParameterizedTest
	@MethodSource("errors4xxAnd5xx")
	void statusPatchError4xxAnd5xx(StatusErrorVerifier statusErrorVerifier) {
		StepVerifier.create(client.patch(statusErrorVerifier.statusCode))
				.verifyError(statusErrorVerifier.exceptionClass);
	}

	@Test
	void delete200() {
		StepVerifier.create(client.delete(HttpStatus.OK))
				.assertNext(response -> response.getStatusCode().is2xxSuccessful())
				.verifyComplete();
	}

	@ParameterizedTest
	@MethodSource("errors4xxAnd5xx")
	void statusDeleteError4xxAnd5xx(StatusErrorVerifier statusErrorVerifier) {
		StepVerifier.create(client.delete(statusErrorVerifier.statusCode))
				.verifyError(statusErrorVerifier.exceptionClass);
	}

}
