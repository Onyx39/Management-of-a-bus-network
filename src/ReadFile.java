import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.ArrayList;
 
class ReadFile {

    public String path;

    public ReadFile (String unChemin) {
        this.path = unChemin;
    }
   
    public ArrayList<String> fileToArrayList() {
        Charset charset = StandardCharsets.UTF_8;
        Path myPath = Paths.get(this.path);
        ArrayList<String> res = new ArrayList<String>();
        try {

			Files.lines(myPath, charset).forEach(y-> res.add(y));

		} catch (IOException ex) {
			System.out.format("I/O Exception:", ex);
		}
        
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.fileToArrayList().size(); i++) {
            res = res + this.fileToArrayList().get(i) + '\n';
        }
        return res;
    }

}