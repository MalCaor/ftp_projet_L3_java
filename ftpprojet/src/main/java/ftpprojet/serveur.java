package ftpprojet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class serveur {
	static String clientPath = System.getProperty("user.dir") + "/client";
	static String userPath = "/personne";
	static String currentPath = System.getProperty("user.dir") + "/home" + userPath;
	static String pseudoTMP;
	// dictionaire
	static HashMap<String, String> listClient = new HashMap<String, String>();
    public static void main(String[] args) throws Exception {
		System.out.println("Le Serveur FTP");

		// init client
		listClient.put("personne", "abcd");
		
		ServerSocket serveurFTP = new ServerSocket(2121);
		Socket socket = serveurFTP.accept();
		

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
	}
}
