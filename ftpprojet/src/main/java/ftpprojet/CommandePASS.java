package ftpprojet;
import java.io.PrintStream;

public class CommandePASS extends Commande {
	
	public CommandePASS(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		// Le mot de passe est : abcd
		if(commandeArgs[0].toLowerCase().equals(serveur.listClient.get(c.pseudoTMP))) {
			c.pwOk = true;
			serveur.pathUser.put(c.pseudoTMP, System.getProperty("user.dir") + "/home" + c.pseudoTMP);

			c.clientPath = System.getProperty("user.dir") + "/client";
			c.userPath = "/" + c.pseudoTMP;
			c.currentPath = System.getProperty("user.dir") + "/home" + c.userPath;

			ps.println("1 Commande pass OK");
			ps.println("0 Vous êtes bien connecté sur notre serveur");

		}
		else {
			ps.println("2 Le mode de passe est faux");
		}
		
	}

}
