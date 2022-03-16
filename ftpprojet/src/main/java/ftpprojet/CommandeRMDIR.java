package ftpprojet;
import java.io.File;
import java.io.PrintStream;

public class CommandeRMDIR extends Commande {
	
	public CommandeRMDIR(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		//ps.println("La commande rmdir n'est pas encoré implémentée");
        File f = new File(c.currentPath+"/"+commandeArgs[0]);

        if(f.isDirectory()){
            if(f.delete()){
                ps.println("0 rmdir : le dossier a été supprimé");
            }else{
                ps.println("2 rmdir : erreur lors de la suppression du dossier");
            }
        }else{
            ps.println("2 rmdir : "+commandeArgs[0]+" n'est pas un dossier");
        }
        
		
	}

}
