import java.io.*;
import java.net.Socket;

public class TCPFileSender extends Thread {

    private Socket socket;
    private long filesize;
    private String path;

    public TCPFileSender(Socket socket, long filesize, String path) {
        this.socket = socket;
        this.filesize = filesize;
        this.path = path;
    }


    @Override
    public void run() {
        try {
            File myFile = new File(path);
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            OutputStream os = socket.getOutputStream();

            while (true) {
                // send file
                byte[] mybytearray = new byte[(int) myFile.length()];
                bis.read(mybytearray, 0, mybytearray.length);
                System.out.println("Sending " + path + "(" + mybytearray.length + " bytes)");
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                System.out.println("Done.");
                os.close();
                os = null;
                bis.close();
                bis = null;
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Processor completed ");
        this.stop();
    }
}
