package juk.playground.reactive.webtest.httpbin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
public abstract class HttpbinClient {

	protected final WebClient httpbinWebClient;

	void logInfo(String method, long start, Object response) {
		log.info("httpbin.org - {} {}ms\n{}", method, System.currentTimeMillis() - start, response);
	}

	void logError(String method, long start, Throwable throwable) {
		String msg = "httpbin.org - %s %sms".formatted(method, System.currentTimeMillis() - start);
		log.error(msg, throwable);
	}

}
