package com.filwsx.JavaStudyAdvanced.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author filwsx
 * @date 2022-02-17 10:20
 */
public class FileInputOutputStreamTest {
    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "\\\\DESKTOP-RHK68LS\\tv2\\老友记S03.Friends.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS\\Friends.S03E03.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS.mkv";
        String destPath = "C:\\Users\\filwsx\\Downloads\\Friends.S03E03.1996.1080p.Blu-ray.x265.AC3￡cXcY@FRDS.mkv";
        copyByteFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618

    }

    //复制文本文件也可，因为文本文件本质也是二进制啊！1040
    //本代码为纯自己靠理解手敲，自己也能写出来！
    public static void copyByteFile(String sourcePath ,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            byte buffer[] = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
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
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
