package juk.playground.reactive.webtest.httpbin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HttpMethodsClient extends HttpbinClient {

	public HttpMethodsClient(WebClient httpbinWebClient) {
		super(httpbinWebClient);
	}

	public Mono<ResponseEntity<String>> get() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.get()
				.uri("/get")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("get", start, res));
	}

	public Mono<ResponseEntity<String>> post() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.post()
				.uri("/post")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("post", start, res));
	}

	public Mono<ResponseEntity<String>> put() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.put()
				.uri("/put")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("put", start, res));
	}

	public Mono<ResponseEntity<String>> patch() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.patch()
				.uri("/patch")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("patch", start, res));
	}

	public Mono<ResponseEntity<String>> delete() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.delete()
				.uri("/delete")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(res -> logInfo("delete", start, res));
	}

}


