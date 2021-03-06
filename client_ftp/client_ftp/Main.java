package client_ftp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static Socket socket;
    static boolean communication = true;
    public static void main(String[] args) throws Exception {
        // vars
        String message;
        Scanner scanner = new Scanner(System.in);
        

        // set sock
        System.out.println("client_ftp");
        // print we here
        try {
            // le socket
            socket = new Socket("localhost", 2121);
        } catch (Exception e) {
            // no serveur
            System.out.println("aucun serveur dispo");
            System.out.println("arret du programe");
            scanner.close();
            return;
        }

        System.out.println("connexion etablie");
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // boucle de communication
        while (communication) {
            message = scanner.nextLine();
            if (message.equals("bye")){
                communication = false;
            }
            os.write(message);
            os.newLine();
            os.flush();
        }

        // close os
        os.close();
        // close scanner
        scanner.close();
        // close sock
        socket.close();
    }
}
