/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multithreadedwebserver.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperationImpl implements FileOperation {

    private static final String RELATIVE_PATH_TO_RESOURCE = "webpages/";

    @Override
    public String readRequestedFileContents(String fileName) {
        String sCurrentLine;
        String returnHtmlContent = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(RELATIVE_PATH_TO_RESOURCE + fileName));
            while ((sCurrentLine = reader.readLine()) != null) {
                returnHtmlContent += sCurrentLine;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOperationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOperationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnHtmlContent;
    }
}
