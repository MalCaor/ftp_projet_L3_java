package client_ftp;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static Socket socket;
    static boolean communication = true;
    public static void main(String[] args) throws Exception {
        // vars
        String message;
        Scanner scanner = new Scanner(System.in);
        OutputStream os;

        // set sock
        System.out.println("client_ftp");
        // print we here
        try {
            // le socket
            socket = new Socket("localhost", 2121);
            System.out.println("connexion etablie");
        } catch (Exception e) {
            // no serveur
            System.out.println("aucun serveur dispo");
            System.out.println("arret du programe");
            scanner.close();
            return;
        }
        
        // boucle de communication
        while (communication) {
            // le outputstream
            os = socket.getOutputStream();
            message = scanner.nextLine();
            if (message.equals("bye")){
                communication = false;
            }
            for (int i = 0; i < message.length(); i++) {
                os.write(message.charAt(i));
            }
            // close os
            os.close();
        }

        // close scanner
        scanner.close();
        // close sock
        socket.close();
    }
}
