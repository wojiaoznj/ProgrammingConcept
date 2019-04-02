package com.diagens.one;

import javafx.scene.shape.Path;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019-03-08 11:56
 */
public class Demo {
    @Test
    public void test1(){
        File file=new File("D:\\workspace\\ProgrammingConcept\\ChapterSeventeen\\src\\main\\java\\com\\diagens\\one");
        //list()方法会为此目录对象下的每个文件名调用accept(),来判断该文件是否包含在内
        String [] list= file.list(new DirFilter(".*java"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
