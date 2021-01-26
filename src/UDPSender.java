import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender extends Thread {


    @Override
    public void run(){
        try {

            File myFile = new File("gymnasiearbete.wav");
            long length = myFile.length();
            System.out.println("file send  length: " + length);
            DatagramSocket ds = null;
            BufferedInputStream bis = null;
            ds = new DatagramSocket();
            DatagramPacket dp;
            int packetsize = 1024;
            double nosofpackets;
            nosofpackets = Math.ceil(length / packetsize);

            bis = new BufferedInputStream(new FileInputStream(myFile));
            for (double i = 0; i < nosofpackets + 1; i++) {
                byte[] mybytearray = new byte[packetsize];
                bis.read(mybytearray, 0, mybytearray.length);
                //System.out.println("Packet Sent:" + (i + 1));
                dp = new DatagramPacket(mybytearray, mybytearray.length, InetAddress.getByName(Env.host), Env.senderport);
                ds.send(dp);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
