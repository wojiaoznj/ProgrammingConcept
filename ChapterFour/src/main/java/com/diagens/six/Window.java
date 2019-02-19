package com.diagens.six;

/**
 * @author ZNJ
 * @create 2019-02-13 20:26
 */
public class Window {
    Window(int marker){
        System.out.println("Window("+marker+")");
    }
}

class House{
    //1.
    Window window1=new Window(1);
    House(){
        //4.
        System.out.println("House()");
        //5.
        window3=new Window(4);
    }
    //2.
    Window window2=new Window(2);
    //3.
    Window window3=new Window(3);
}
