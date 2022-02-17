package com.filwsx.JavaStudyAdvanced.file;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * @author filwsx
 * @date 2022-02-17 18:17
 */
public class NIO2Text {

    @Test
    public void test2() throws IOException {
        Path path1 = Paths.get("hello.txt");//new File(String filepath)

        Path path2 = Paths.get("c:\\", "Users\\","filwsx\\hello.txt");//new File(String parent,String filename);

        System.out.println(path1);
        System.out.println(path2);

        Path path3 = Paths.get("c:\\", "Users");
        System.out.println(path3);
    }

    @Test
    public void test1() throws IOException {
        File srcFile = new File("17312919.jpg");
        File destFile = new File("17312919-copy.jpg");

        long checksum = FileUtils.checksum(srcFile, new CRC32()).getValue();
        System.out.println(checksum);

        FileUtils.copyFile(srcFile,destFile);
    }
}
