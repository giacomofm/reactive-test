package juk.playground.reactive.webtest.behaviour;

import juk.playground.reactive.webtest.httpbin.StatusCodesClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.Duration;

/// To run check the corresponding test class
@Slf4j
@Component
@RequiredArgsConstructor
public class Demo1 {

	private final StatusCodesClient statusCodesClient;

	boolean throwOnSub() {
		log.info("throwOnSub - start");
		try {
			statusCodesClient.get(HttpStatus.NOT_FOUND)
					.subscribe(res -> log.info("This will not be printed, {}", res), err -> {
						log.info("Inner error, as expected", err);
						// This exception will never be catched outside
						throw new RuntimeException("new error");
					});
			// Wait for the async call to complete
			Thread.sleep(Duration.ofSeconds(10));
			return true;
		} catch (Exception e) {
			log.info("Outer error, will never be called", e);
			return false;
		}
	}

}
