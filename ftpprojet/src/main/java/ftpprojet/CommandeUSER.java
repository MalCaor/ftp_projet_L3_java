package ftpprojet;
import java.io.File;
import java.io.PrintStream;


public class CommandeUSER extends Commande {
	
	public CommandeUSER(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		// Ce serveur accepte uniquement le user personne
		File f = new File(System.getProperty("user.dir") + "/home/" + commandeArgs[0].toLowerCase());
		if(f.isDirectory()) {
			
			c.userOk = true;
			c.pseudoTMP = commandeArgs[0].toLowerCase();
			ps.println("0 Commande user OK");
			return;
		}
		
		ps.println("2 Le user " + commandeArgs[0] + " n'existe pas");
		
		
	}

}
