package com.ant.worker;

import net.bytebuddy.asm.Advice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GMTDateTime {
    public  static  void main(String [] atr) {
        final Date currentTime = new Date();

      //  final SimpleDateFormat sdf =   new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hh:mm:ss");

// Give it to me in GMT time.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("GMT time: " + sdf.format(currentTime));

    }

    public static String Date(){
        final Date currentTime = new Date();
        //  final SimpleDateFormat sdf =   new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
// Give it to me in GMT time.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
      //  System.out.println("GMT time: " + sdf.format(currentTime));
        return sdf.format(currentTime);
    }

    public static String DateTime(){
        final Date currentTime = new Date();
        //  final SimpleDateFormat sdf =   new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hh_mm_ss");
// Give it to me in GMT time.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
       // System.out.println("GMT time: " + sdf.format(currentTime));
        return sdf.format(currentTime);
    }




}

