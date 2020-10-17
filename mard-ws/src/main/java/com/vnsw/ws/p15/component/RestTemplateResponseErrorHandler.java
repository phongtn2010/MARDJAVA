package com.vnsw.ws.p15.component;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);

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
        LOGGER.error("ERROR:>>>>>>>>>>>>> {}", theString);
        writer.close();
        httpResponse.getBody().close();
        httpResponse.close();

    }
}