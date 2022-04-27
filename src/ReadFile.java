import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
 
class ReadFile {

    public String path;

    public ReadFile (String unChemin) {
        this.path = unChemin;
    }
   
    public String fileToString() {
        Charset charset = StandardCharsets.UTF_8;
        Path myPath = Paths.get(this.path);
        try {
			Files.lines(myPath, charset).forEach(System.out::println);

		} catch (IOException ex) {
			System.out.format("I/O Exception:", ex);
		}
        
        return "coucou";
    }

}