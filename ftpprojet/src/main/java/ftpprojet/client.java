package ftpprojet;

import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        for (int i = 0; i < 3; i++) {
            System.out.println(br.readLine());
        }
        String messageRecu;
        int intDevant;
        // boucle de communication
        while (communication) {
            message = scanner.nextLine();
            if (message.equals("bye")){
                communication = false;
            }
            os.write(message);
            os.newLine();
            os.flush();
            messageRecu = br.readLine();
            if (messageRecu != null)
            {
                System.out.println(messageRecu);
                while (messageRecu.charAt(0) == '1') {
                    messageRecu = br.readLine();
                    System.out.println(messageRecu);
                }
             }
            
        }

        // close os
        os.close();
        // close scanner
        scanner.close();
        // close sock
        socket.close();
    }
}
