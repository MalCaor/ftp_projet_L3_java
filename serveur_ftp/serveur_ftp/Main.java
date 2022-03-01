package serveur_ftp;
/*
 * TP JAVA RIP
 * Min Serveur FTP
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.naming.CompoundName;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Le Serveur FTP");
		
		ServerSocket serveurFTP = new ServerSocket(2121);
		Socket socket = serveurFTP.accept();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		ps.println("1 Bienvenue ! ");
		ps.println("1 Serveur FTP Personnel.");
		ps.println("0 Authentification : ");
		
		String commande = "";
		
		// Attente de reception de commandes et leur execution
		/*while(!(commande=br.readLine()).equals("bye")) {
			System.out.println(">> "+commande);
			CommandExecutor.executeCommande(ps, commande);
		}*/
		int i;
		while((i=br.read())!=-1){
			commande = commande+(char)i;
		}
		while(!commande.equals("bye")) {
			System.out.println(">> "+commande);
			CommandExecutor.executeCommande(ps, commande);
		}
		
		serveurFTP.close();
		socket.close();
	}

}
