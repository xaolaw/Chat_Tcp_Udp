import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaTcpServer {

    public static void main(String[] args) throws IOException {

        System.out.println("JAVA TCP SERVER");
        int portNumber = 12345;
        ServerSocket serverSocket = null;

        //create list of clients 10 clients
        //TODO make inf client list
        int clientLimit=10;
        Socket[] clientList= new Socket[clientLimit];
        //index to addClient
        int clientIndex = 0;

        try {
            // create socket
            serverSocket = new ServerSocket(portNumber);

            while(true){

                // accept client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected, client id: ");
                clientList[clientIndex] = clientSocket;
                clientIndex+=1%clientLimit;

                // in & out streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // read msg, send response
                String msg = in.readLine();
                System.out.println("Received msg: " + msg);
                out.println("Pong Java Tcp");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if (serverSocket != null){
                serverSocket.close();
            }
        }
    }

}
