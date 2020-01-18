package com.hellofresh.challenge.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

public class Logger {

    private static String logFilePath = null;
    private static BufferedWriter out = null;
    private static String logFileName = null;

    public static void initializeLogger(String filePath, String fileName) {
        try {
            logFilePath = filePath;
            logFileName = fileName;
            File newFile = new File(logFilePath + logFileName);
            newFile.createNewFile();
            newFile.setWritable(true);
        } catch (Exception e) {
            Assert.fail("Fail to read file " + e.getLocalizedMessage());
        }
    }

    public static void logTestInfo(String text) {
        try {
            Date currentTimeStamp = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy, HH:mm:ss");
            System.out.println(text);
            out = new BufferedWriter(new FileWriter(logFilePath + logFileName, true));
            out.write("\r\n" + "[" + format.format(currentTimeStamp) + "]" + "[INFO]: ");
            out.write(text);
            out.close();
        } catch (Exception e) {
            Assert.fail("Fail to read file " + e.getLocalizedMessage());
        }
    }
}



