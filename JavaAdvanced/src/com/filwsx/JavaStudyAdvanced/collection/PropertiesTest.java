package com.filwsx.JavaStudyAdvanced.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author filwsx
 * @date 2022-02-15 17:54
 */
public class PropertiesTest {
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String pwd = pros.getProperty("pwd");

            System.out.println("name = " + name + ", pwd = " + pwd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
