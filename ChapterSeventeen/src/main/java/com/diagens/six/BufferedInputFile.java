package com.diagens.six;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZNJ
 * @create 2019-03-11 11:10
 */
public class BufferedInputFile {
    public static List read(String filename) throws IOException {
        List list = new LinkedList();
        BufferedReader in=new BufferedReader(new FileReader(filename));
        String s;
        while ((s=in.readLine())!=null){
            list.add(s.toUpperCase());
        }
        in.close();
        return list;
    }
}
