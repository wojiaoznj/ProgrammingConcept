package com.diagens.seven;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author ZNJ
 * @create 2019-02-25 14:08
 */
public class ScannerDelimiter {
    @Test
    public void test1() {
        //Scanner根据空白字符对输入进行分词，但是你可以用正则表达式指定自己所需的定界符
        Scanner scanner = new Scanner("12,24,56,36,67,41");
        //使用逗号作为分界符
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }
    }

    @Test
    public void test2() {
        //扫描一个防火墙日志文件中记录的威胁数据
        String threatData = "58.27.82.161@02/10/2005\n" +
                        "58.27.82.161@02/10/2005\n" +
                        "204.45.234.40@02/11/2005\n" +
                        "58.27.82.161@02/10/2005\n" +
                        "58.27.82.161@02/10/2005\n" +
                        "58.27.82.161@02/10/2005\n" +
                        "[Next log section with different data format]";

        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult math = scanner.match();
            String ip = math.group(1);
            String date = math.group(2);
            System.out.format("Threat on %s from %s\n", date, ip);
        }
    }
}
