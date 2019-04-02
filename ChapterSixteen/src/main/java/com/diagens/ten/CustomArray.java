package com.diagens.ten;

/**
 * @author ZNJ
 * @create 2019-03-07 16:58
 */
public class CustomArray  {
    public String [] strings=new String[10];
    private int size=0;

    public void add(String str){
        if(strings.length==size){
          String[] ss=new String[strings.length*2];
          System.arraycopy(strings,0,ss,0,strings.length);
          strings=ss;
        }
        strings[size]=str;
        size++;
    }
}
