package com.redhat.openshift.spring.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.redhat.openshift.spring.models.Base64Image;

@RequestMapping("/grayfilters")
@RestController
public class Base64ImageRestResource {

	@Value("${gray.filter.rest.host}")
	private String grayFilterRestHost;
	@Value("${gray.filter.rest.port}")
	private Integer grayFilterRestPort;

	public Base64ImageRestResource() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String transformImage(@RequestBody Base64Image base64Image) {

		final RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(base64Image.getBase64String(), headers);
		final ResponseEntity<String> grayBase64Image = restTemplate
				.postForEntity("http://" + grayFilterRestHost + ":" + grayFilterRestPort + "/grayfilters", entity, String.class);

		return grayBase64Image.getBody();
	}

}
