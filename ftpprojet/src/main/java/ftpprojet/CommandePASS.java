package ftpprojet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandePASS extends Commande {
	
	public CommandePASS(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		// Le mot de passe est : abcd
		File passwordFile = new File(System.getProperty("user.dir") + "/home/" + c.pseudoTMP + "/password.txt");
		Scanner scanSrcFile;
		
		try {
			scanSrcFile = new Scanner(passwordFile);
			if(commandeArgs[0].toLowerCase().equals(scanSrcFile.nextLine())) {
				c.pwOk = true;
				serveur.pathUser.put(c.pseudoTMP, System.getProperty("user.dir") + "/home/" + c.pseudoTMP);
	
				c.userPath = "/" + c.pseudoTMP;
				c.clientPath = System.getProperty("user.dir") + "/client" + c.userPath;
				c.currentPath = System.getProperty("user.dir") + "/home" + c.userPath;
	
				ps.println("1 Commande pass OK");
				ps.println("0 Vous êtes bien connecté sur notre serveur");
	
			}
			else {
				ps.println("2 Le mode de passe est faux");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
