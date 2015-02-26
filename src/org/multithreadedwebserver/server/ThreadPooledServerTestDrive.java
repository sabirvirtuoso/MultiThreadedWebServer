/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.server;

public class ThreadPooledServerTestDrive {

    private static final int SERVER_PORT = 19999;
    
    public static void main(String[] args) {

        ThreadPooledServer server = new ThreadPooledServer(SERVER_PORT);
        new Thread(server).start();

    }
}