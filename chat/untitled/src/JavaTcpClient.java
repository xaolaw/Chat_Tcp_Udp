import java.io.Console;
import java.io.*;
import java.net.Socket;

public class JavaTcpClient {

    public static void main(String[] args) throws IOException {

        System.out.println("JAVA TCP CLIENT");
        String hostName = "localhost";
        int portNumber = 12345;
        Socket socket = null;

        try {
            // create socket
            socket = new Socket(hostName, portNumber);

            // in & out streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Console console = System.console();
            String text;

            text = console.readLine("Enter text: ");

            while (!text.equals("end")){
                out.println(text);

                text = console.readLine("Enter text: ");
            }

            /*
            // send msg, read response
            out.println("Ping Java Tcp");
            String response = in.readLine();
            System.out.println("received response: " + response);*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                socket.close();
            }
        }
    }

}
