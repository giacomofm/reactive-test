package juk.playground.reactive.webtest.httpbin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class StatusCodesClient extends HttpbinClient {

	public StatusCodesClient(WebClient httpbinWebClient) {
		super(httpbinWebClient);
	}

	public Mono<ResponseEntity<String>> get(HttpStatusCode code) {
		long start = System.currentTimeMillis();
		return httpbinWebClient.get()
				.uri("/status/" + code.value())
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("get (status)", start, res))
				.doOnError(err -> logError("get (status)", start, err));
	}

	public Mono<ResponseEntity<String>> post(HttpStatusCode code) {
		long start = System.currentTimeMillis();
		return httpbinWebClient.post()
				.uri("/status/" + code.value())
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("post (status)", start, res))
				.doOnError(err -> logError("post (status)", start, err));
	}

	public Mono<ResponseEntity<String>> put(HttpStatusCode code) {
		long start = System.currentTimeMillis();
		return httpbinWebClient.put()
				.uri("/status/" + code.value())
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("put (status)", start, res))
				.doOnError(err -> logError("put (status)", start, err));
	}

	public Mono<ResponseEntity<String>> patch(HttpStatusCode code) {
		long start = System.currentTimeMillis();
		return httpbinWebClient.patch()
				.uri("/status/" + code.value())
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("patch (status)", start, res))
				.doOnError(err -> logError("patch (status)", start, err));
	}

	public Mono<ResponseEntity<String>> delete(HttpStatusCode code) {
		long start = System.currentTimeMillis();
		return httpbinWebClient.delete()
				.uri("/status/" + code.value())
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("delete (status)", start, res))
				.doOnError(err -> logError("delete (status)", start, err));
	}

}

