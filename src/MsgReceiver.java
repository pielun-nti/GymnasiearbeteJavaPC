/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DecimalFormat;

public class Receiver extends Thread {
    Socket socket;
    public static long timeStarted;
    public static double timeEnded;
    public Receiver(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            while(true) {
                String message = br.readLine();
                if (message != null) {
                    System.out.println("Tcp timetaker message received: " + message);
                    if (message.startsWith("timestarted|")) {
                        String[] data = message.split("\\|");
                        timeStarted = Long.parseLong(data[1]);
                        //System.exit(2):
                    }
                   /* if (message.startsWith("timeended")){
                        //long elapsedTimeMillis = System.nanoTime()-timeStarted;
                        final long sectime = ((timeStarted - System.nanoTime()) / 1000000000) * (-1);
                        //final double seconds = ((double)elapsedTimeMillis / 1000000000) * (-1);
                       // float timeTakenSec = elapsedTimeMillis/1000F * (-1);
                        System.out.println("Time taken: " + new DecimalFormat("#.##########").format(sectime) + " seconds");
                    }*/
                  /*  System.out.println("Received something: " + message);
                    if (message.startsWith("timeended|")){
                        String[] data = message.split("\\|");
                        timeEnded = Double.parseDouble(data[1]);
                        System.out.println("Time taken: " + timeEnded + " milliseconds");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}*/
