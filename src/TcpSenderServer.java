import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSenderServer extends Thread {
    TCPFileSender receiver;
    @Override
    public void run(){
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Env.senderport);
            System.out.println("Started TCP Sender File  Server");
        } catch (IOException ex) {
            System.out.println("Can't setup Tcp Sender File server on this port number. ");
        }
        try {
            for (int i = 0; i >= 0; i++) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection : " + socket);
                receiver = new TCPFileSender(socket, Env.filesize, "gymnasiearbete.wav");
                receiver.start();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

