public class TCPMain {
    static TcpReceiverServer tcpReceiverServer;
    public static void main(String[]args){
        tcpReceiverServer = new TcpReceiverServer();
        tcpReceiverServer.start();
    }
}
