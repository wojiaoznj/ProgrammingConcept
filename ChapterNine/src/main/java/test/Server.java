package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    /**
     * Socket服务端
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            System.out.println("服务端已启动，等待客户端连接..");
            Socket socket=serverSocket.accept();//侦听并接受到此套接字的连接,返回一个Socket对象

            //根据输入输出流和客户端连接
            InputStream inputStream=socket.getInputStream();//得到一个输入流，接收客户端传递的信息
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//提高效率，将自己字节流转为字符流
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//加入缓冲区
            String temp=null;
            String info="";
            while((temp=bufferedReader.readLine())!=null){
                info+=temp;
                System.out.println("已接收到客户端连接");
                System.out.println("服务端接收到客户端信息："+info+",当前客户端ip为："+socket.getInetAddress().getHostAddress());
            }

            System.out.println("你好，服务端已接收到您的信息");

            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}