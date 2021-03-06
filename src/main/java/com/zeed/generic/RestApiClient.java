package com.zeed.generic;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

@Service
@SuppressWarnings("Duplicates")
public class RestApiClient {

    public <T,V> ResponseEntity<T> apiPostAndGetResponseEntity (String url, Class<T> claz, Object requestData,
                                                        HashMap<String,String> headers) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity httpEntity = getHttpEntityForRequest(requestData,headers);
            ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,claz);
            return responseEntity;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T,V> T apiPostAndGetClass (String url, Class<T> claz, Object requestData,
                                                        HashMap<String,String> headers) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity httpEntity = getHttpEntityForRequest(requestData,headers);
            ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,claz);
            return (responseEntity!=null) ? responseEntity.getBody() : null;
        } catch (RestClientException e) {
            return null;
        }
    }

    public <T,V> T apiPostResponse (String url, Class<T> claz, Object requestData,
                                                        HashMap<String,String> headers) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = getHttpEntityForRequest(requestData,headers);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,claz);
        return responseEntity.getBody();
    }

    public <T,V> T apiPostResponseWithCLass (String url, Class<T> claz, Object requestData,
                                                        HashMap<String,String> headers) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.entrySet().stream().forEach(headers1->{
            httpHeaders.set(headers1.getKey(),headers1.getValue());
        });
        HttpEntity httpEntity = new HttpEntity(requestData,httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,claz);
        return responseEntity.getBody();
    }

    public <T> ResponseEntity<T> apiGetWithHttpEntity (String url, Class<T> claz, Object requestData,
                                                        HashMap<String,String> headers) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.entrySet().stream().forEach(headers1->{
            httpHeaders.set(headers1.getKey(),headers1.getValue());
        });
        HttpEntity httpEntity = new HttpEntity(requestData,httpHeaders);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,claz);
        return responseEntity;
    }

    public <T> HttpEntity getHttpEntityForRequest(Object requestData, HashMap<String,String> headers){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        if (headers!=null) {
            headers.entrySet().stream().forEach(headers1->{
                httpHeaders.set(headers1.getKey(),headers1.getValue());
            });
        }
        HttpEntity httpEntity = new HttpEntity(requestData,httpHeaders);
        return httpEntity;
    }




    public <T> ResponseEntity<T> apiPostWithHttpEntityt(String url, HttpEntity httpEntity, Class<T> claz){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,claz,new Object[0]);
        return responseEntity;
    }

}
