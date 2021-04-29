package com.initiativeCounter.webserverMauven.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass(){
        httpParser = new HttpParser();
    }

    @Test
    void parseHttpRequest() {
        HttpRequest request = httpParser.parseHttpRequest(generateValidGETTestCase());

        assertEquals(request.getMethod(), HttpMethod.GET);
    }

    private InputStream generateValidGETTestCase(){
        String rawData =    "GET / HTTP/1.1\r\n" +
                            "Host: localhost:8080\r\n" +
                            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:88.0) Gecko/20100101 Firefox/88.0\r\n" +
                            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n" +
                            "Accept-Language: de,en-US;q=0.7,en;q=0.3\r\n" +
                            "Accept-Encoding: gzip, deflate\r\n" +
                            "Connection: keep-alive\r\n" +
                            "Upgrade-Insecure-Requests: 1\r\n" +
                            "Cache-Control: max-age=0\r\n" +
                            "\r\n";
        InputStream inputStream = new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII));
        return inputStream;
    }

    private InputStream generateBadTestCaseMethodName1(){
        String rawData =    "GET / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: de,en-US;q=0.7,en;q=0.3\r\n" +
                "\r\n";
        InputStream inputStream = new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII));
        return inputStream;
    }
}