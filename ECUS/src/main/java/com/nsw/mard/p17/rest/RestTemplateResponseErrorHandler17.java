package com.nsw.mard.p17.rest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class RestTemplateResponseErrorHandler17
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR
                        || httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        StringWriter writer = new StringWriter();
        IOUtils.copy(httpResponse.getBody(), writer, StandardCharsets.UTF_8.toString());
        String theString = writer.toString();
        System.out.println(theString);
        writer.close();
        httpResponse.getBody().close();
        httpResponse.close();
        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            }
        }
    }
}
