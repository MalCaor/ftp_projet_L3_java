package ftpprojet;
import java.io.PrintStream;

public class CommandExecutor {
	
	
	public static void executeCommande(connexion c, PrintStream ps, String commande) {
		if(c.userOk && c.pwOk) {
			// Changer de repertoire. Un (..) permet de revenir au repertoire superieur
			if(commande.split(" ")[0].equals("cd")) 
			{
				(new CommandeCD(c, ps, commande)).execute();
				return;
			}
			// Telecharger un fichier
			if(commande.split(" ")[0].equals("get")) 
			{
				(new CommandeGET(c, ps, commande)).execute();
				return;
			}
			// Afficher la liste des fichiers et des dossiers du repertoire courant
			if(commande.split(" ")[0].equals("ls")) 
			{
				(new CommandeLS(c, ps, commande)).execute();
				return;
			}
			// Afficher le repertoire courant
			if(commande.split(" ")[0].equals("pwd")) 
			{
				(new CommandePWD(c, ps, commande)).execute();
				return;
			}
			// Envoyer (uploader) un fichier
			if(commande.split(" ")[0].equals("stor")) 
			{
				(new CommandeSTOR(c, ps, commande)).execute();
				return;
			}

			// no such command
			ps.println("2 La commande n'existe pas");
			return;
		} else {
			if(commande.split(" ")[0].equals("pass") || commande.split(" ")[0].equals("user")) {
				// Le mot de passe pour l'authentification
				if(commande.split(" ")[0].equals("pass")) (new CommandePASS(c, ps, commande)).execute();
	
				// Le login pour l'authentification
				if(commande.split(" ")[0].equals("user")) (new CommandeUSER(c, ps, commande)).execute();
			}
			else
				ps.println("2 Vous n'êtes pas connecté !");
		}
	}

}
