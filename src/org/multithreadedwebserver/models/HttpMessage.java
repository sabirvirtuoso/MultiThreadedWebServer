/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.models;

public class HttpMessage {

    private String requestMethod;
    private String requestObject;
    private String protocolVersion;
    private String host;
    private String port;
    private String userAgent;
    private String contentType;
    private int contentLength;

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(String requestObject) {
        this.requestObject = requestObject;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String toString() {
        return "Request Method: " + this.requestMethod
                + "Request Object: " + this.requestObject
                + "HTTP Protocol Version: " + this.protocolVersion
                + "Host: " + this.host
                + "Port: " + this.port
                + "User Agent: " + this.userAgent
                + "Content Type: " + this.contentType
                + "Content Length: " + this.contentLength;
    }
}
