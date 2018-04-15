package com.zeed.generic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericUtilsApplicationTests {

	@Autowired
	private RestApiClient restApiClient;

	@Test
	public void contextLoads() {

		String base64encodedString = Base64.getEncoder().encodeToString("isms-service:secret".getBytes());
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Basic " + base64encodedString);
		MultiValueMap<String, Object> request = new LinkedMultiValueMap();
		request.add("username", "superuser");
		request.add("password", "password");
		request.add("grant_type", "password");
		String url = "http://127.0.0.1:8011/oauth/token" + "?grant_type=password&username=" + "superuser" + "&password=" + "password";
//		ResponseEntity<OAuth2AccessToken> object = restApiClient.apiPostWithHttpEntity(url, OAuth2AccessToken.class,request,headers);
		return;
	}

}
