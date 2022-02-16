package com.filwsx.JavaStudyAdvanced.file;

import org.junit.Test;

import java.io.File;

/**
 * @author filwsx
 * @date 2022-02-16 9:43
 */
public class FileTest {



    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module
        File file2 =  new File("C:\\Users\\hello.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("C:\\","Users");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }
}
