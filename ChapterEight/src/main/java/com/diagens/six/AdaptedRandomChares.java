package com.diagens.six;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author ZNJ
 * @create 2019/2/17-23:04
 */
public class AdaptedRandomChares extends RandomChares implements Readable {
    private int count;

    public AdaptedRandomChares(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count--==0){
           return -1;
        }
        String result=next()+" ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(new AdaptedRandomChares(7));
        while (scanner.hasNext())
            System.out.println(scanner.next());
    }
}
