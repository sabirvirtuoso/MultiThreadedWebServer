/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.multithreadedwebserver.models.HttpMessage;
import org.multithreadedwebserver.utils.FileOperationImpl;

public class HttpRequestServiceImpl implements HttpRequestService {

    private static final String URL_GET_PARAMETER_BEGIN_SYMBOL = "?";
    private static final String URL_GET_PARAMETER_SEPARATOR = "&";
    private String[] formFields;
    private String fullFormData = "";
    private String clientResponse;

    @Override
    public String processClientRequest(HttpMessage httpMessageObject, BufferedReader in) {
        if (httpMessageObject.getRequestMethod().equals("GET") == true
                && httpMessageObject.getRequestObject().contains("favicon.ico") == false) {
            if (httpMessageObject.getRequestObject().contains(URL_GET_PARAMETER_BEGIN_SYMBOL)) {
                System.out.println("User inputs are:\n" + processFormSubmitUsingGET(httpMessageObject));
                clientResponse = "<h3>Your inputs have been processed</h3>";
            } else {
                clientResponse = processFileRequest(httpMessageObject);
            }
        } else if (httpMessageObject.getRequestMethod().equals("POST")) {
            System.out.println("User inputs are:\n" + processFormSubmitUsingPost(httpMessageObject, in));
            clientResponse = "<h3>Your inputs have been processed</h3>";
        }
        return clientResponse;
    }

    private String processFormSubmitUsingGET(HttpMessage httpMessageObject) {
        formFields = httpMessageObject.getRequestObject().split("\\" + URL_GET_PARAMETER_BEGIN_SYMBOL)[1].split(URL_GET_PARAMETER_SEPARATOR);
        for (int i = 0; i < formFields.length; i++) {
            fullFormData += formFields[i] + "\n";
        }
        return fullFormData;
    }

    private String processFormSubmitUsingPost(HttpMessage httpMessageObject, BufferedReader in) {
        int contentLength = httpMessageObject.getContentLength();
        char[] responseBody = new char[contentLength];
        try {
            in.read(responseBody, 0, contentLength);
        } catch (IOException ex) {
            Logger.getLogger(HttpRequestServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] formFields = String.valueOf(responseBody).split(URL_GET_PARAMETER_SEPARATOR);
        for (int i = 0; i < formFields.length; i++) {
            fullFormData += formFields[i] + "\n";
        }
        return fullFormData;
    }

    private String processFileRequest(HttpMessage httpMessageObject) {
        String fileName = httpMessageObject.getRequestObject().split("/")[1].toString();
        String htmlFileContent = new FileOperationImpl().readRequestedFileContents(fileName);
        return htmlFileContent;
    }
}
