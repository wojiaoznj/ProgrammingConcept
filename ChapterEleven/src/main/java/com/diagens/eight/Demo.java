package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019/2/24-15:43
 */
public class Demo {
    public static void main(String[] args) {
        try {
            try {
                throw new HoHumException();
            } finally {
                throw new VeryImportantException();
            }
        } catch (VeryImportantException e) {
            throw new NullPointerException();
        } catch (NullPointerException e){
            //会忽略前两个异常
            System.out.println(e);
        }
    }
}
