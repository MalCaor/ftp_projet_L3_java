package ftpprojet;
import java.io.PrintStream;

public class CommandExecutor {
	
	public static boolean userOk = false ;
	public static boolean pwOk = false ;
	
	public static void executeCommande(PrintStream ps, String commande) {
		if(userOk && pwOk) {
			// Changer de repertoire. Un (..) permet de revenir au repertoire superieur
			if(commande.split(" ")[0].equals("cd")) 
			{
				(new CommandeCD(ps, commande)).execute();
				return;
			}
			// Telecharger un fichier
			if(commande.split(" ")[0].equals("get")) 
			{
				(new CommandeGET(ps, commande)).execute();
				return;
			}
			// Afficher la liste des fichiers et des dossiers du repertoire courant
			if(commande.split(" ")[0].equals("ls")) 
			{
				(new CommandeLS(ps, commande)).execute();
				return;
			}
			// Afficher le repertoire courant
			if(commande.split(" ")[0].equals("pwd")) 
			{
				(new CommandePWD(ps, commande)).execute();
				return;
			}
			// Envoyer (uploader) un fichier
			if(commande.split(" ")[0].equals("stor")) 
			{
				(new CommandeSTOR(ps, commande)).execute();
				return;
			}

			// no such command
			ps.println("2 La commande n'existe pas");
			return;
		} else {
			if(commande.split(" ")[0].equals("pass") || commande.split(" ")[0].equals("user")) {
				// Le mot de passe pour l'authentification
				if(commande.split(" ")[0].equals("pass")) (new CommandePASS(ps, commande)).execute();
	
				// Le login pour l'authentification
				if(commande.split(" ")[0].equals("user")) (new CommandeUSER(ps, commande)).execute();
			}
			else
				ps.println("2 Vous n'êtes pas connecté !");
		}
	}

}
