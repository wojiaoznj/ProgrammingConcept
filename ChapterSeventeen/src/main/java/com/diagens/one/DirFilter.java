package com.diagens.one;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author ZNJ
 * @create 2019-03-08 11:49
 */
public class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    //接受一个代表某个特定文件所在目录的File对象，以及包含那个文件名的一个String
    //list()方法会为此目录对象下的每个文件名调用accept(),来判断该文件是否包含在内
    public boolean accept(File dir, String name) {
        //判断文件名是否满足此表达式
        return pattern.matcher(name).matches();
    }
}
