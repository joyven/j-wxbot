package com.joyven.wxbot.http;

import com.joyven.wxbot.util.CustomHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
        return responseEntity.getBody();
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
        messageConverters.removeIf(converter -> converter instanceof StringHttpMessageConverter);

        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;

    }
}
