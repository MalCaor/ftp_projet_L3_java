package ftpprojet;

import java.net.ServerSocket;
import java.util.HashMap;

public class serveur{
	static String clientPath = System.getProperty("user.dir") + "/client";
	static String userPath = "/personne";
	static String currentPath = System.getProperty("user.dir") + "/home" + userPath;
	static String pseudoTMP;
	static ServerSocket serveurFTP;
	// dictionaire
	static HashMap<String, String> listClient = new HashMap<String, String>();
	// users connected
	static HashMap<String, String> pathUser= new HashMap<String, String>();
    public static void main(String[] args) throws Exception  {
		System.out.println("Le Serveur FTP");

		// init client
		listClient.put("personne1", "abcd");
		listClient.put("personne2", "1234");
		
		serveurFTP = new ServerSocket(2121);
		while(true){
			connexion con = new connexion(serveurFTP);
			Thread th = new Thread(con);
			th.start();
		}
	}

	
	
}
