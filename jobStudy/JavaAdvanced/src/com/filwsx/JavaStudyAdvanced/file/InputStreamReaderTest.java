package com.filwsx.JavaStudyAdvanced.file;

import org.junit.Test;

import java.io.*;

/**
 * @author filwsx
 * @date 2022-02-17 11:44
 */
public class InputStreamReaderTest {
    @Test
    public void test2() throws Exception {
        //1.造文件、造流
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        //3.关闭资源
        isr.close();
        osw.close();
    }
}
