/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.utils;

import org.multithreadedwebserver.models.HttpMessage;

public interface HttpMessageParser {

    HttpMessage parseHttpMessage(String httpMessage);
}
