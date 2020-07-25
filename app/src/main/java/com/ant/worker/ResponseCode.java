package com.ant.worker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseCode {
    public static int ResponseCode (URL url) throws IOException {
        //URL url = url;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
       // long stime = System.currentTimeMillis();
        connection.connect();
        //return connection.getResponseCode();
        String Test = connection.getResponseMessage();
        connection.disconnect();
        return connection.getResponseCode();
    }


}
