/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.services;

import java.io.PrintWriter;

public class HttpResponseServiceImpl implements HttpResponseService {

    @Override
    public void sendClientResponse(String clientResponse, PrintWriter out) {
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        out.println("");
        out.println(clientResponse);
        out.flush();
    }
}
