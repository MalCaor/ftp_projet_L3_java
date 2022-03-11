package ftpprojet;
import java.io.File;
import java.io.PrintStream;

public class CommandeCD extends Commande {
	
	public CommandeCD(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		

		File f = new File(serveur.currentPath);
		
		if(f.isDirectory()) {
			if(commandeArgs[0].equals("..")){
				String[] tab = commandeArgs[0].split("/");
				if(tab[tab.length - 1].equals("personne")){
					ps.println("2 Erreur, dossier racine atteint");
				}else{
					String tempPath=tab[0];
					for(int i=1; i<tab.length-1; i++){
						tempPath+="/"+tab[i];
					}
					serveur.currentPath=tempPath;
				}
			}else{
				String[] listOfFile = f.list();
				boolean found = false;

				for (String file : listOfFile) {
					if(commandeArgs[0].toLowerCase().equals(file)) found = true;
				}
				
				if(found){
					serveur.currentPath += "/"+commandeArgs[0];
					ps.println("0 "+serveur.currentPath);
				}
			}
			
		}else{
			ps.println("2 cd : Impossible de trouver le chemin d'accès «"+commandeArgs[0]+"», car il n'existe pas.");
		}
	}

}
