package ftpprojet;
import java.io.PrintStream;

public class CommandePWD extends Commande {
	
	public CommandePWD(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		String s = (c.currentPath);
		ps.println("0 " + s);
	}

}
