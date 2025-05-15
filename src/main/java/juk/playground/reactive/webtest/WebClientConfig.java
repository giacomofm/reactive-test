package juk.playground.reactive.webtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class WebClientConfig {

	static final String BASE_URL = "https://httpbin.org";

	@Bean
	WebClient httpbinWebClient() {
		return WebClient.builder().baseUrl(BASE_URL).build();
	}

}
