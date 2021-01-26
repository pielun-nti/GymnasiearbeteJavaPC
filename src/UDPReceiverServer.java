import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UDPReceiverServer extends Thread {

    DatagramSocket serverSocket;

    @Override
    public void run(){
        try {
            serverSocket = new DatagramSocket(Env.port);
            System.out.println("Started UDP Server");
            FileOutputStream out = new FileOutputStream("udpfile.wav");
            byte[] recData = new byte[Env.filesize];
            boolean stop = false;
            while(!stop)
        {
            DatagramPacket recPacket = new DatagramPacket(recData, recData.length);
            serverSocket.receive(recPacket);
            System.out.println("\n Packet length: " + recPacket.getLength());
            out.write(recPacket.getData(), 0, recPacket.getLength());
            System.out.println("\nPacket written to file");
            out.flush();
            //out.close();
            //received file, now send back with udp
            UDPSender udpSender = new UDPSender();
            udpSender.start();
            stop = true;
        }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        /*try {
            serverSocket = new DatagramSocket(Env.port);
            System.out.println("Started UDP server");
            int packetsize = 1024;
            FileOutputStream fos = null;
            fos = new FileOutputStream("udpfile.wav");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            double nosofpackets = Math.ceil(thelength / packetsize);
            byte[] mybytearray = new byte[packetsize];
            DatagramPacket receivePacket = new DatagramPacket(mybytearray, mybytearray.length);
            System.out.println(nosofpackets + " " + mybytearray.length + " " + packetsize);
            for (double i = 0; i < nosofpackets; i++) {
                serverSocket.receive(receivePacket);
                byte audioData[] = receivePacket.getData();
                System.out.println("Packet:" + (i + 1));
                bos.write(audioData, 0, audioData.length);
            }
            //long elapsedTimeMillis = System.currentTimeMillis()- Receiver.timeStarted;
            //float timeTakenSec = elapsedTimeMillis/1000F * (-1);
            //System.out.println("Time taken: " + timeTakenSec + " seconds");
            System.out.println("UDP Done received!" + new Date().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

    }
}
