import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpReceiverServer extends Thread{
    TcpFileReceiver receiver;
    @Override
    public void run(){
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Env.port);
            System.out.println("Started TCP Receiver File Server");
        } catch (IOException ex) {
            System.out.println("Can't setup Tcp Receiver File server on this port number. ");
        }
        try {
            for (int i = 0; i >= 0; i++) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection : " + socket);
                receiver = new TcpFileReceiver(socket);
                receiver.start();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
