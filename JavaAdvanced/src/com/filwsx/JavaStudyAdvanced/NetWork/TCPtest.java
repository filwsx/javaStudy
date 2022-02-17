package com.filwsx.JavaStudyAdvanced.NetWork;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 有计算机网络基础，已下载跳过好多课，有点爽！1929写
 * @author filwsx
 * @date 2022-02-17 19:27
 */
public class TCPtest {


    @Test
    public void client3() throws IOException {

        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8080);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("filwsx.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }

        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    @Test
    public void server3() throws IOException {

        ServerSocket ss = new ServerSocket(8080);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("filwsx-copy2.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");

        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我已收到，非常漂亮！".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }

    @Test
    public void client2(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8080);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("filwsx.jpg"));
            byte buffer [] = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                os.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server2(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(8080);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("filwsx-copy.jpg"));
            byte buffer[] = new byte[1024];
            int len;
            while((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void client1() {
        Socket socket =  null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8080);
            os = socket.getOutputStream();
            os.write("这是一条客户端的请求".getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server1(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8080);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

