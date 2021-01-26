import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/*
public class TcpTimeTaker {
    static Receiver receiver;
    public static void main(String[]args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Env.timeTakerPort);
            System.out.println("Started TCP TimeTaker Server");
        } catch (Exception ex) {
            System.out.println("Can't setup tcp timetaker server on this port number. ");
        }
        try {
            for (int i = 0; i >= 0; i++) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection : " + socket);
                receiver = new Receiver(socket);
                receiver.start();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
*/