package com.filwsx.JavaStudyAdvanced.file;

import org.junit.Test;

import java.io.*;

/**
 * @author filwsx
 * @date 2022-02-17 12:48
 */
public class OtherStreamTest {
    /**标准输入、输出流 的练习
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。输入“exit()”时退出程序。
     * 方法一：使用Scanner实现，调用next()返回一个字符串
     * 方法二：使用System.in实现。System.in--->转换流--->BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("exit()".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //打印流：PrintStream 和 PrintWriter
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("hello.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //数据流:将基本数据类型变量和字符串从内存存储到文件中
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("hello.txt"));
        dos.writeUTF("filwsx-2");
        dos.writeInt(36);
        dos.writeBoolean(false);
        dos.flush();
        dos.close();
    }

    //数据流:将文件中存储的基本数据类型变量和字符串读取到内存中。
    @Test
    public void test4() throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("hello.txt"));

        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);

        dis.close();
    }
}
