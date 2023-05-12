package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8100;
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to the server. You can start sending commands.");

            String command;
            while ((command = consoleReader.readLine()) != null) {
                out.println(command);

                if (command.equals("exit")) {
                    break;
                }

                String response = in.readLine();
                System.out.println("Server response: " + response);
            }

            socket.close();
            System.out.println("Client stopped");
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }
}
