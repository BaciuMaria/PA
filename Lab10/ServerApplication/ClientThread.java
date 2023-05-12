package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket= null;

    public ClientThread (Socket socket) { this.socket = socket ; }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String command;
            while ((command = in.readLine()) != null) {
                System.out.println("Server received the request: " + command);

                if (command.equals("stop")) {
                    out.println("Server stopped");
                    break;
                }

                out.println("Server received the request: " + command);
            }
            socket.close();
            System.out.println("Client disconnected");
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        }
    }
}
