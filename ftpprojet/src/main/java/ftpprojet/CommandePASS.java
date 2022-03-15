package ftpprojet;
import java.io.PrintStream;

public class CommandePASS extends Commande {
	
	public CommandePASS(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		// Le mot de passe est : abcd
		if(commandeArgs[0].toLowerCase().equals(serveur.listClient.get(serveur.pseudoTMP))) {
			CommandExecutor.pwOk = true;
			serveur.pathUser.put(serveur.pseudoTMP, System.getProperty("user.dir") + "/home" + serveur.pseudoTMP);
			ps.println("1 Commande pass OK");
			ps.println("0 Vous êtes bien connecté sur notre serveur");

		}
		else {
			ps.println("2 Le mode de passe est faux");
		}
		
	}

}
