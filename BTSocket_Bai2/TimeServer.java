package BTSocket_Bai2;

import java.io.*;
import java.net.*;

public class TimeServer {
    public static void main(String[] args) {
        final int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();
                if (request.equals("time")) {
                    String currentTime = java.time.LocalTime.now().toString();
                    out.println(currentTime);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

