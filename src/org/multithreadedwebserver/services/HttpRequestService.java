/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.services;

import java.io.BufferedReader;
import org.multithreadedwebserver.models.HttpMessage;

public interface HttpRequestService {

    String processClientRequest(HttpMessage httpMessageObject, BufferedReader in);
}
