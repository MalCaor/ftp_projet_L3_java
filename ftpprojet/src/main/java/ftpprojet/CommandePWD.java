package ftpprojet;
import java.io.File;
import java.io.PrintStream;

public class CommandePWD extends Commande {
	
	public CommandePWD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		String s = (serveur.currentPath);
		ps.println("0 " + s);
	}

}
