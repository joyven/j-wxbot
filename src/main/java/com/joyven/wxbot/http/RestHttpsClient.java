package com.joyven.wxbot.http;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.joyven.wxbot.util.CustomHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/5
 * Time: 下午5:36
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class RestHttpsClient {
    public static <T> T getOutputStream(String url, Class<T> claszz) {
        RestTemplate restTemplate = defaultRestTemplate();
        URI uri = URI.create(url);
        ResponseEntity entity = restTemplate.getForEntity(uri, claszz);
        return (T) entity.getBody();
    }

    public static <T> T getObject(String strUrl, Map<String, Object> headers, Class<T> clazz) throws MalformedURLException, URISyntaxException {
        RestTemplate restTemplate = defaultRestTemplate();
        URL url = new URL(strUrl);
        URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach((k,v)->{httpHeaders.add(k, String.valueOf(v));});
        }
        HttpEntity entity = new HttpEntity(null, httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, clazz);
        if (responseEntity != null) {
            return responseEntity.getBody();
        }
        return null;
    }

    public static <T> String postJson(String strUrl, Map<String, Object> headers, T body)
            throws MalformedURLException, URISyntaxException {
        RestTemplate restTemplate = defaultRestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null && headers.size() >0) {
            headers.forEach((k,v) -> httpHeaders.set(k, String.valueOf(v)));
        }
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String json = JSONObject.toJSONString(body);
        System.out.println(json);
        HttpEntity<String> entity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange(strUrl, HttpMethod.POST, entity, String.class);
        if (responseEntity != null) {
            return (String) responseEntity.getBody();
        }
        return null;

    }

    public static String postFormUrlEncode(String url, Map<String, ?> params) {
        RestTemplate restTemplate = defaultRestTemplate();
        StringBuilder builder = new StringBuilder();
        builder.append(url).append("?");
        if (params != null && params.size() > 0) {
            params.forEach((k, v) -> builder.append("&").append(k).append("=").append(v));
        }
        URI uri = URI.create(builder.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity(null, headers);
        ResponseEntity responseEntity = restTemplate.postForEntity(uri, entity, String.class);
        if (responseEntity.getStatusCodeValue() == SC_OK) {
            return (String) responseEntity.getBody();
        }
        return null;
    }

    private static RestTemplate defaultRestTemplate() {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = CustomHttpClient.acceptsUntrustedCertsHttpClient();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.removeIf(StringHttpMessageConverter.class::isInstance);
        messageConverters.removeIf(MappingJackson2HttpMessageConverter.class::isInstance);

        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new FastJsonHttpMessageConverter());
        return restTemplate;

    }
}
