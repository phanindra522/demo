package com.demo.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value( "${food.app.url}" )
	private String URL1 ;
	
	@Value( "${food.app.id}" )
	private String foodAppId;
	
	@Value( "${food.app.key}" )
	private String foodAppKey;
	
	public Map food(Map<String, Object> req) {
		//req.put("app_id", "a6cea5e6");
		//req.put("app_key", "a19050ad0627025f90343cf4cec0fe31");
		req.put("app_id", foodAppId);
	    req.put("app_key", foodAppKey);
		return getService(URL1 + "search", req);
	}
	
	@ExceptionHandler
	private Map getService(String url, Map<String, Object> req) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, Object> entry : req.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Map> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        Map.class);
		return response.getBody();
	}
}
