package com.ant.worker;

public class timeCount {
    public  static float gettime(long beginTime ,long endTime){
    long time= endTime - beginTime;
    System.out.print("TimeCount .GetTime = " + time + '\n');
     return time;
    }

}
