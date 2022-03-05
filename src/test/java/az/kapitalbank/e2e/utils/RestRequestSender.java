package az.kapitalbank.e2e.utils;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestRequestSender {

	public static <T, S> S postRestForObject(String url, String token, T resource, Class<S> clazz) {
		String reqId = UUID.randomUUID().toString();
		try{
			HttpEntity<T> request = createRequest(token, resource,reqId);
			RestTemplate restTemplate = createTemplate();
			return restTemplate.postForObject(url, request, clazz);
		}finally {
			logToAppender(url, reqId);
		}
	}


	public static <T> ResponseEntity<Void> postRestForEntity(String url, String token, T resource) {
		String reqId = UUID.randomUUID().toString();
		try{
			HttpEntity<T> request = createRequest(token, resource, reqId);
			RestTemplate restTemplate = createTemplate();
			return restTemplate.postForEntity(url, request, Void.class);
		}finally {
			logToAppender(url, reqId);
		}
	}

	public static <T, S> S postRestForObjectWithoutToken(String url, T resource, Class<S> clazz) {
		return postRestForObject(url, null, resource, clazz);
	}

	public static <T> ResponseEntity<Void> postRestForEntityWithoutToken(String url, T resource) {
		return postRestForEntity(url, null, resource);
	}

	private static <T> HttpEntity<T> createRequest(String token, T resource, String reqId) {
		HttpHeaders headers = new HttpHeaders();

		if (token != null) {
			headers.add("X-Auth-Token", token);
		}

		headers.add("Content-Type", "application/json");
		headers.add("req-id", reqId);
		

		HttpEntity<T> request = new HttpEntity<T>(resource, headers);

		return request;
	}

	private static RestTemplate createTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate;
	}
	
	private static void logToAppender(String url, String reqId) {

	}

}
