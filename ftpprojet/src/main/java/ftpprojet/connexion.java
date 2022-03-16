package ftpprojet;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

public class connexion implements Runnable {
    ServerSocket serveurFTP;
    Socket socket;
    connexion(ServerSocket serveur){
        serveurFTP = serveur;
    }

    @Override
	public void run() {
		try {
			socket = serveurFTP.accept();
		
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			ps.println("1 Bienvenue ! ");
			ps.println("1 Serveur FTP Personnel.");
			ps.println("0 Authentification : ");
			
			String commande = "";
			
			// Attente de reception de commandes et leur execution
			while(!(commande=br.readLine()).equals("bye")) {
				System.out.println(">> "+commande);
				CommandExecutor.executeCommande(ps, commande);
			}
			
			serveurFTP.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
