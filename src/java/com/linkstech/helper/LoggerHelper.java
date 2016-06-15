/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkstech.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Link
 */
public class LoggerHelper {

    private static LoggerHelper loggerHelper = null;

    private LoggerHelper() {

    }

    public static LoggerHelper getINSTANCE() {
        if (loggerHelper == null) {
            loggerHelper = new LoggerHelper();
        }
        return loggerHelper;
    }

    public void log(String type, Throwable throwable) {
        String error = getStackTrace(throwable);
        String oldline = "";
        File f = new File("./logs/" + type + ".log");
        try {
            FileReader fr = new FileReader(f);
            
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (++count > 1000);
                oldline += System.getProperty("line.separator") + line;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PrintWriter out = new PrintWriter(f);
            
            out.write(new Date().toString() + " " + error);
            out.write(oldline);
            out.close();
            System.out.println(f.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String readLog() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./logs/test.log"));
            System.out.println(br.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
    public static void main(String[] args) {
        try {
            String test = new LoggerHelper().readLog();
        } catch (IOException ex) {
            Logger.getLogger(LoggerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
