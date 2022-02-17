package com.filwsx.JavaStudyAdvanced.NetWork;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author filwsx
 * @date 2022-02-17 19:28
 */
public class UDPtest {

    @Test
    public void sender(){
        try {
            DatagramSocket dgs = new DatagramSocket();
            byte data[] = "upd测试".getBytes(StandardCharsets.UTF_8);
            DatagramPacket pack = new DatagramPacket(data,0,data.length, InetAddress.getByName("127.0.0.1"),8080);
            dgs.send(pack);
            dgs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket dgs = new DatagramSocket(8080);
        byte data[] = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,0,data.length);
        dgs.receive(packet);
        String str = new String(packet.getData(),0, packet.getLength());
        System.out.println(str);
    }
}
