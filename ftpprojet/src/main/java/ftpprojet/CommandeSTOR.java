package ftpprojet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandeSTOR extends Commande {
	
	public CommandeSTOR(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		File srcFile = new File(serveur.clientPath+"/"+commandeArgs[0]);
		if(srcFile.isFile()){
			File destFile = new File(serveur.currentPath+"/"+commandeArgs[0]);
			try {
				if(destFile.createNewFile()){
					Scanner scanSrcFile = new Scanner(srcFile);
					FileWriter destFileWriter = new FileWriter(destFile);
					while(scanSrcFile.hasNextLine()){
						destFileWriter.write(scanSrcFile.nextLine());
						destFileWriter.write("\n");
					}
					scanSrcFile.close();
					destFileWriter.close();
				}else{
					ps.println("2 get : le fichier existe deja");
				}
				ps.println("0 get : "+commandeArgs[0]+" téléchargé");
			} catch (IOException e) {
				e.printStackTrace();
				ps.println("2 get : erreur lors du téléchargement du fichier "+commandeArgs[0]);
			}
		}else{
			ps.println("2 get : "+commandeArgs[0]+" n'est pas un fichier");
		}
	}

}
