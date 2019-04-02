package com.diagens.six;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author ZNJ
 * @create 2019-03-11 11:14
 */
public class Demo {
    @Test
    public void test1() throws IOException {
        List list=BufferedInputFile.read("D:\\workspace\\ProgrammingConcept\\ChapterSeventeen\\src\\main\\java\\com\\diagens\\six\\test");
        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
}
