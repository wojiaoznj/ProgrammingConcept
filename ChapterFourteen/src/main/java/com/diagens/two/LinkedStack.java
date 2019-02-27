package com.diagens.two;

/**
 * @author ZNJ
 * @create 2019-02-27 11:15
 */
public class LinkedStack<T> {
    private static class Node<T>{
        T item;
        Node<T> next;

        public Node(){
          item=null;
          next=null;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        //判断是否到顶
        boolean end(){return item==null&&next==null;}
    }

    private Node<T> top=new Node<T>();

    public void push(T t){
        //添加一个数值后，创建一个新的对象
        //并将新的对象置为当前项，将新对象的next属性置为上一个对象
        //这样就可以将所有传入的对象绑定起来
        //并且按照先入后出的顺序输出
        top=new Node<T>(t,top);
    }

    public T pop(){
        T result=top.item;
        if(!top.end()){
          top=top.next;
        }
        return result;
    }
}
