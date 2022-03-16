package ftpprojet;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class connexion implements Runnable {
	// var 
	String clientPath = System.getProperty("user.dir") + "/client";
	String userPath = "/personne";
	String currentPath = System.getProperty("user.dir") + "/home" + userPath;
	String pseudoTMP;

	boolean userOk = false ;
	boolean pwOk = false ;

    Socket socket;
    connexion(Socket serveur){
        socket = serveur;
    }

    @Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			ps.println("1 Bienvenue ! ");
			ps.println("1 Serveur FTP Personnel.");
			ps.println("0 Authentification : ");
			
			String commande = "";
			
			// Attente de reception de commandes et leur execution
			while(!(commande=br.readLine()).equals("bye")) {
				System.out.println(">> "+commande);
				CommandExecutor.executeCommande(this, ps, commande);
			}
			
			socket.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
