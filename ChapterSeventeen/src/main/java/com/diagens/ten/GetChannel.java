package com.diagens.ten;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ZNJ
 * @create 2019-03-11 18:37
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    private int a;

    @Test
    public void test() throws IOException {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining())
            System.out.print((char) buffer.get());
    }

    @Test
    public void test1() throws IOException {
        String[] args = {"src\\main\\java\\com\\diagens\\ten\\ChannelCopy.txt", "src\\main\\java\\com\\diagens\\ten\\test"};
        FileChannel in = new FileInputStream(args[1]).getChannel(),
                out = new FileOutputStream(args[0]).getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(BSIZE);
        //返回-1时表示读取到输入的末尾了
        while (in.read(buffer)!=-1){
            //flip准备缓冲器以便它的信息可以由write获取
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    @Test
    public void test2() throws IOException {
        String[] args = {"src\\main\\java\\com\\diagens\\ten\\ChannelCopy.txt", "src\\main\\java\\com\\diagens\\ten\\test"};
        FileChannel in = new FileInputStream(args[1]).getChannel(),
                out = new FileOutputStream(args[0]).getChannel();
        //将一个管道和另一个相连
        in.transferTo(0,in.size(),out);
        //或者
        //out.transferForm(in,0,in.size);
    }
}
