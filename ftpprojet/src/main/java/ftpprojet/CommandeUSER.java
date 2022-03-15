package ftpprojet;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandeUSER extends Commande {
	
	public CommandeUSER(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		// Ce serveur accepte uniquement le user personne

		for(String key : serveur.listClient.keySet())
		{
			if(commandeArgs[0].toLowerCase().equals(key)) {
				CommandExecutor.userOk = true;
				serveur.pseudoTMP = commandeArgs[0].toLowerCase();
				ps.println("0 Commande user OK");
				return;
			}
		}
		
		ps.println("2 Le user " + commandeArgs[0] + " n'existe pas");
		
		
	}

}
