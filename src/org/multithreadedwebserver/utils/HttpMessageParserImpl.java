/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.utils;

import org.multithreadedwebserver.models.HttpMessage;

public class HttpMessageParserImpl implements HttpMessageParser {

    private static final int HTTP_REQUEST_LINE = 0;

    @Override
    public HttpMessage parseHttpMessage(String httpMessage) {
        HttpMessage httpMessageObject = new HttpMessage();
        String httpMessageFields[] = httpMessage.split("\r\n");

        httpMessageObject.setRequestMethod(httpMessageFields[HTTP_REQUEST_LINE].split(" ")[0].toString());
        httpMessageObject.setRequestObject(httpMessageFields[HTTP_REQUEST_LINE].split(" ")[1].toString());
        httpMessageObject.setProtocolVersion(httpMessageFields[HTTP_REQUEST_LINE].split(" ")[2].split("/")[1].toString());

        for (int i = 1; i < httpMessageFields.length; i++) {
            if (httpMessageFields[i].startsWith("Host: ")) {
                httpMessageObject.setHost(httpMessageFields[i].split(" ")[1].split(":")[0].toString());
                httpMessageObject.setPort(httpMessageFields[i].split(" ")[1].split(":")[1].toString());
            } else if (httpMessageFields[i].startsWith("User-Agent: "))
                httpMessageObject.setUserAgent(httpMessageFields[i].split(" ")[1].toString());
            else if (httpMessageFields[i].startsWith("Content-Type: "))
                httpMessageObject.setContentType(httpMessageFields[i].split(" ")[1].toString());
            else if (httpMessageFields[i].startsWith("Content-Length: "))
                httpMessageObject.setContentLength(Integer.parseInt(httpMessageFields[i].split(" ")[1].substring(0, 2)));
        }
        
        return httpMessageObject;
    }
}
