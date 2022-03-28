import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("Сервер запущен!");

            try (Socket clientSocket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                out.println("Здравствуйте, Новый посетитель, напишите Ваше имя");
                String name = in.readLine();
                out.println("Сервер приветствует " + name);
                out.println("Вы зарегистрированный пользователь? (да/нет)");
                String word = in.readLine();
                if ("да".equalsIgnoreCase(word)) {
                    out.println("Пожалуйста войдите под своей учетной записью " + name);
                } else out.println("Вы будете находиться на сервере в статусе гостя");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
