package ftpprojet;
import java.io.File;
import java.io.PrintStream;

public class CommandeMKDIR extends Commande {
	
	public CommandeMKDIR(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		//ps.println("La commande mkdir n'est pas encoré implémentéee");
        File f = new File(c.currentPath+"/"+commandeArgs[0]);

        if(f.mkdir()){
            ps.println("0 mkdir : le dossier a été créé");
        }else{
            ps.println("2 mkdir : le dossier existe deja");
        }
		
	}

}
