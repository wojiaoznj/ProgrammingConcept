package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    /**
     * Socket客户端
     */
    public static void main(String[] args) {
        try {
            //创建Socket对象
            Socket socket=new Socket("localhost",8888);

            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print("服务端你好，我是Balla_兔子");
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流

            System.out.println("客户端发送消息");
            //关闭相对应的资源
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}