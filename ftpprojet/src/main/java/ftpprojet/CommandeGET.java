package ftpprojet;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class CommandeGET extends Commande {
	
	public CommandeGET(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		ps.println("La commande get n'est pas encoré implémentée");
		File f = new File(serveur.currentPath);
		if(f.isFile()){
			File newFile = new File(serveur.clientPath+"/"+commandeArgs[0]);
			try {
				if(newFile.createNewFile()){
					
				}else{
					ps.println("2 get : le fichier existe deja");
				}
				ps.println("0 get : "+commandeArgs[0]+" téléchargé");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			ps.println("2 get : "+commandeArgs[0]+" n'est pas un fichier");
		} 
	}

}
