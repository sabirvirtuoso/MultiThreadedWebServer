/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.multithreadedwebserver.models.HttpMessage;
import org.multithreadedwebserver.services.HttpRequestServiceImpl;
import org.multithreadedwebserver.services.HttpResponseServiceImpl;
import org.multithreadedwebserver.utils.HttpMessageParserImpl;

public class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
        System.out.println("New Runnable Instance Created");
    }

    public void run() {
        try {
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in =
                    new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String clientRequest = ".";
            String httpMessage = "";
            while (!clientRequest.equals("")) {

                clientRequest = in.readLine();
                httpMessage += clientRequest + "\r\n";
            }
            //System.out.println(httpMessage);
            HttpMessage httpMessageObject = new HttpMessageParserImpl().parseHttpMessage(httpMessage);
            String clientResponse = new HttpRequestServiceImpl().processClientRequest(httpMessageObject, in);
            new HttpResponseServiceImpl().sendClientResponse(clientResponse, out);
            //Need to wait 4 seconds to pretend that processing is ongoing
            /*try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }*/

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}