package ftpprojet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandeGET extends Commande {
	
	public CommandeGET(connexion c, PrintStream ps, String commandeStr) {
		super(c, ps, commandeStr);
	}

	public void execute() {
		//ps.println("La commande get n'est pas encoré implémentée");
		File srcFile = new File(c.currentPath+"/"+commandeArgs[0]);
		if(srcFile.isFile()){
			File destFile = new File(c.clientPath+"/"+commandeArgs[0]);
			try {
				if(!destFile.createNewFile()){
					if(destFile.delete()){
						destFile.createNewFile();
					}else{
						ps.println("2 get : le fichier existe deja");
					}
				}
				
				Scanner scanSrcFile = new Scanner(srcFile);
				FileWriter destFileWriter = new FileWriter(destFile);
				while(scanSrcFile.hasNextLine()){
					destFileWriter.write(scanSrcFile.nextLine());
					destFileWriter.write("\n");
				}
				scanSrcFile.close();
				destFileWriter.close();
				
				ps.println("0 get : "+commandeArgs[0]+" téléchargé dans "+ c.clientPath);
			} catch (IOException e) {
				e.printStackTrace();
				ps.println("2 get : erreur lors du téléchargement du fichier "+commandeArgs[0]);
			}
		}else{
			ps.println("2 get : "+commandeArgs[0]+" n'est pas un fichier");
		} 
	}

}
