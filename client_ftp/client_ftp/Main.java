package client_ftp;

import java.net.Socket;

public class Main {
    static Socket socket;
    public static void main(String[] args) throws Exception {
        // set sock
        System.out.println("client_ftp");
        // print we here
        try {
            socket = new Socket("localhost", 2121);
        } catch (Exception e) {
            // no serveur
            System.out.println("aucun serveur dispo");
            System.out.println("arret du programe");
            return;
        }

        // close sock
        socket.close();
    }
}
