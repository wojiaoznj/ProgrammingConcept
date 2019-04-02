package test;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.GZIPOutputStream;

/**
 * @author ZNJ
 * @create 2019-04-01 17:22
 */
public class CopyImage {
    public static void main(String [] args) throws IOException {
        File file=new File("C:\\Users\\Diagens\\Pictures\\A181805_slide0_cell16_812.tif");
        String str=byteToString(loadImage(file));
        FileChannel fc = new FileOutputStream("C:\\Users\\Diagens\\Pictures\\Some.text").getChannel();
        fc.write(ByteBuffer.wrap(str.getBytes("ISO-8859-1")));
        fc.close();
        //byte2image(str.getBytes("ISO-8859-1"),"C:\\Users\\Diagens\\Pictures\\A181805_slide0_cell16_813.tif");
    }
    /**
     * 将图片转换为字节数组
     * @return
     */
    private static byte[] loadImage(File file){
        //用于返回的字节数组
        byte[] data=null;
        //打开文件输入流
        FileInputStream fin=null;
        //打开字节输出流
        ByteArrayOutputStream bout=null;
        try{
            //文件输入流获取对应文件
            fin=new FileInputStream(file);
            //输出流定义缓冲区大小
            bout=new ByteArrayOutputStream((int)file.length());
            //定义字节数组，用于读取文件流
            byte[] buffer=new byte[1024];
            //用于表示读取的位置
            int len=-1;
            //开始读取文件
            while((len=fin.read(buffer))!=-1){
                //从buffer的第0位置开始，读取至第len位置，结果写入bout
                bout.write(buffer,0,len);
            }
            //将输出流转为字节数组
            data=bout.toByteArray();
            //关闭输入输出流
            fin.close();
            bout.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    /**
     * 把字节数组转化为字符串----"ISO-8859-1"
     * @param
     * @return
     */
    private static String byteToString(byte[] data){
        String dataString=null;
        try{
            //将字节数组转为字符串，编码格式为ISO-8859-1
            dataString=new String(data,"ISO-8859-1");
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataString;
    }

    public static  void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
}
