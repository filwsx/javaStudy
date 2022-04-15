package com.filwsx.JavaStudyAdvanced.file;

import org.junit.Test;

import java.io.*;

/**
 * @author filwsx
 * @date 2022-02-17 10:44
 */
public class BufferTest {

    @Test
    public void testCopyByteFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "\\\\DESKTOP-RHK68LS\\tv2\\老友记S03.Friends.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS\\Friends.S03E05.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS.mkv";
        String destPath = "C:\\Users\\filwsx\\Downloads\\Friends.S03E05.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS.mkv";
        copyByteFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618 - 176
    }

    public static void copyByteFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        File srcFile = new File(srcPath);
        File destFile = new File(destPath);

        try {
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte buffer[] = new byte[1024];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
        }
    }
}
