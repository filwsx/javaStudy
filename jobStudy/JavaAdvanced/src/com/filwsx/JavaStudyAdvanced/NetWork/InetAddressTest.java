package com.filwsx.JavaStudyAdvanced.NetWork;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author filwsx
 * @date 2022-02-17 18:43
 */
public class InetAddressTest {
    @Test
    public void test(){
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.youtube.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());
            //getHostAddress()
            System.out.println(inet2.getHostAddress());

        }catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
