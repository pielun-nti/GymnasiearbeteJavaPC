import java.io.*;
import java.net.Socket;
import java.util.Date;

public class TcpFileReceiver extends Thread {
    Socket socket;
    public TcpFileReceiver(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = socket.getInputStream();
            } catch (IOException ex) {
                System.out.println("Can't get socket input stream. ");
            }

            try {
                out = new FileOutputStream("tcpfile.wav");
            } catch (FileNotFoundException ex) {
                System.out.println("File not found. ");
            }

            byte[] bytes = new byte[Env.filesize];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }

            out.close();
            in.close();
            System.out.println("TCP Done received!" + new Date().toString());
            //receiver from android, now send back file
            TcpSenderServer tcpSenderServer = new TcpSenderServer();
            tcpSenderServer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
