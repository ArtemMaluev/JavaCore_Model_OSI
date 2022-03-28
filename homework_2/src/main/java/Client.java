import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 9999;
        try (Socket clientSocket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String word = in.readLine();
            System.out.print(word + "\n>> ");
            String consoleInput = reader.readLine();
            out.println(consoleInput);
            word = in.readLine();
            System.out.println(word);
            word = in.readLine();
            System.out.print(word + "\n>> ");
            consoleInput = reader.readLine();
            out.println(consoleInput);
            word = in.readLine();
            System.out.println(word);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}