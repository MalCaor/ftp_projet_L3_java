package ftpprojet;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandeLS extends Commande {
	
	public CommandeLS(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	public void execute() {
		//ps.println("La commande ls n'est pas encoré implémentée");
		Path dir = Paths.get(serveur.currentPath);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) {
				ps.println("1 " + file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}
		ps.println("0 ..");
	}

}
