package az.kapitalbank.e2e.pages.KimlikVeGuvenlikAltyapisi;

import java.io.Serializable;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import net.serenitybdd.core.pages.PageObject;

@Component
public class LoginPage extends PageObject implements Serializable  {

	private static final long serialVersionUID = 1L;
	

	@Value("${login.site.url}")
	private String hostIpPort;

	private static final String loginPath = "/login";

	public String login(String auth) {

		String encoded = Base64.getEncoder().encodeToString(auth.getBytes());

		String url = hostIpPort + loginPath;

		RestTemplate rt = new RestTemplate();
		rt.getMessageConverters().add(new StringHttpMessageConverter());
		String reqId = UUID.randomUUID().toString();
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", "Basic " + encoded);
		headers.add("req-id", reqId);
		HttpEntity<String> headersSent = new HttpEntity<String>(headers);
		String response = rt.postForEntity(url, headersSent, String.class).getBody();

		return response;

	}

}
