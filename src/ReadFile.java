import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.ArrayList;
 
class ReadFile {

    public String nom, path;
    public ArrayList<Station> station_list;

    public ReadFile (String unNom, String unChemin) {
        this.nom = unNom;
        this.path = unChemin;
        this.station_list = new ArrayList<Station>();
    }
   
    public ArrayList<String> fileToArrayList() {
        Charset charset = StandardCharsets.UTF_8;
        Path myPath = Paths.get(this.path);
        ArrayList<String> res = new ArrayList<String>();
        try {
			Files.lines(myPath, charset).forEach(y-> res.add(y));
		} 
        catch (IOException ex) {
			System.out.format("I/O Exception:", ex);
		}
        return res;
    }

    public Line createLine() {
        Line nom = new Line(this.nom);
        System.out.println(nom);
        String station_line = fileToArrayList().get(0);
        String split[] = station_line.split(" N ");
        for (int k = 0; k < split.length; k++) {
            System.out.println(split[k]);
            String nom_station = split[0];
            Station testStation = new Station(nom_station); 
            System.out.println(testStation);
            nom.addStation(testStation);
        }
        return nom;
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