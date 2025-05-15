package juk.playground.reactive.webtest.httpbin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpMethodsClient {

	private final WebClient httpbinWebClient;

	public Mono<ResponseEntity<String>> get() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.get()
				.uri("/get")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(resp -> log.info("httpbin.org - get {}ms\n{}", System.currentTimeMillis() - start, resp));
	}

	public Mono<ResponseEntity<String>> post() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.post()
				.uri("/post")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(resp -> log.info("httpbin.org - post {}ms\n{}", System.currentTimeMillis() - start, resp));
	}

	public Mono<ResponseEntity<String>> put() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.put()
				.uri("/put")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(resp -> log.info("httpbin.org - put {}ms\n{}", System.currentTimeMillis() - start, resp));
	}

	public Mono<ResponseEntity<String>> patch() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.patch()
				.uri("/patch")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(resp -> log.info("httpbin.org - patch {}ms\n{}", System.currentTimeMillis() - start, resp));
	}

	public Mono<ResponseEntity<String>> delete() {
		long start = System.currentTimeMillis();
		return httpbinWebClient.delete()
				.uri("/delete")
				.retrieve()
				.toEntity(String.class)
				.doOnNext(resp -> log.info("httpbin.org - delete {}ms\n{}", System.currentTimeMillis() - start, resp));
	}

}


