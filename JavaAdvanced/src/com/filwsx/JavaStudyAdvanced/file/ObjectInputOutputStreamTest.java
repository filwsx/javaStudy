package com.filwsx.JavaStudyAdvanced.file;

import com.filwsx.JavaStudyAdvanced.Annotation.Person;
import org.junit.Test;

import java.io.*;

/**
 * @author filwsx
 * @date 2022-02-17 17:29
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("I have a dream!"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("filwsx",35));
            oos.flush();

            oos.writeObject(new Person("张学良",99));
            oos.flush();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                //3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
