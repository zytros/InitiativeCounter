package com.initiativeCounter.webserverMauven.http;

import com.initiativeCounter.webserverMauven.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpParser.class);

    private static final int SP = 0x20; //32
    private static final int CR = 0x0D; //13
    private static final int LF = 0x0A; //10

    public HttpRequest parseHttpRequest(InputStream inputStream){
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);

        HttpRequest request = new HttpRequest();

        try {
            parseRequestLine(reader, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseHeaders(reader, request);
        parseBody(reader, request);

        return request;
    }

    private void parseRequestLine(InputStreamReader reader, HttpRequest request) throws IOException {
        StringBuilder processingDataBuffer = new StringBuilder();

        boolean methodParsed = false;
        boolean requestTargetParsed = false;

        int _byte;
        while((_byte = reader.read()) >= 0){
            if(_byte == CR){
                _byte = reader.read();
                if(_byte == LF){
                    LOGGER.debug("Request Line VERSION to Process : {}", processingDataBuffer.toString());
                    return;
                }
            }
            if(_byte == SP){
                // TODO process prev data
                if(!methodParsed){
                    LOGGER.debug("Request Line METHOD to Process : {}", processingDataBuffer.toString());
                    request.setMethod(processingDataBuffer.toString());
                    methodParsed = true;
                }else if(!requestTargetParsed){
                    LOGGER.debug("Request Line REQ TQRGET to Process : {}", processingDataBuffer.toString());
                    requestTargetParsed = true;
                }
                processingDataBuffer.delete(0, processingDataBuffer.length());
            }else{
                processingDataBuffer.append((char) _byte);
            }
        }

    }

    private void parseHeaders(InputStreamReader reader, HttpRequest request) {

    }

    private void parseBody(InputStreamReader reader, HttpRequest request) {

    }


}
