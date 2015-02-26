/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.services;

import java.io.PrintWriter;

public interface HttpResponseService {

    void sendClientResponse(String clientResponse, PrintWriter out);
}
