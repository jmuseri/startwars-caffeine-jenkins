package com.museri.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        logger.info("Request URI: {}", request.getURI());
        logger.info("Request Method: {}", request.getMethod());
        logger.info("Request Headers: {}", request.getHeaders());
        logger.info("Request Body: {}", new String(body));
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        logger.info("Response Status Code: {}", response.getStatusCode());
        logger.info("Response Headers: {}", response.getHeaders());

        if (response.getStatusCode() == HttpStatus.OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            logger.info("Response Body: {}", responseBody.toString());
        }
    }
}