package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZNJ
 * @create 2019-04-01 16:04
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while (true) {
            Socket client = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String str = in.readLine();
            System.out.println(new String( str.getBytes("utf-8") , "utf-8"));
            client.close();
        }
    }
}
