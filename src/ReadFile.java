import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.ArrayList;
 
class ReadFile {

    public String nomAller, nomRetour, path;
    public ArrayList<Station> station_list;

    public ReadFile (String unNom, String unChemin) {
        this.nomAller = unNom + " (Direction ";
        this.nomRetour = unNom + " (Direction ";
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

    public Line createLineAller(Graph G) {
        String station_line = fileToArrayList().get(0);
        String split[] = station_line.split(" N ");
        int nbStations = split.length;
        Line nomAller = new Line(this.nomAller + split[nbStations - 1] + ") A");
        Station station_precedente = null;
        for (int k = 0; k < nbStations; k++) {
            String nom_station = split[k];
            String horaires_normaux = fileToArrayList().get(k + 2);
            String split_horaires_normaux[] = horaires_normaux.split(" ");
            String horaires_feries = fileToArrayList().get(2*nbStations + k + 6);
            String split_horaires_feries[] = horaires_feries.split(" ");
            int test = 0;
            for (int l = 0; l < G.liste_stations.size(); l++) {
                if (G.liste_stations.get(l).getStation_name().equals(nom_station)) {
                    if (k > 0) {G.liste_stations.get(l).addVoisin(station_precedente);}
                    nomAller.addStation(G.liste_stations.get(l));
                    test = 1;
                    for (int t = 1; t < split_horaires_normaux.length; t++) {
                        String split_time[] = split_horaires_normaux[t].split(":");
                        if (!split_time[0].equals("-")) {
                            Horaire truc = new Horaire (Integer.parseInt(split_time[0]), Integer.parseInt(split_time[1]), nomAller);
                            G.liste_stations.get(l).horaires_normaux_sens_1.add(truc);
                        }
                    }
                    for (int u = 1; u < split_horaires_feries.length; u++) {
                        String split_time_ferie[] = split_horaires_feries[u].split(":");
                        if (!split_time_ferie[0].equals("-")) {
                            Horaire truc = new Horaire (Integer.parseInt(split_time_ferie[0]), Integer.parseInt(split_time_ferie[1]), nomAller);
                            G.liste_stations.get(l).horaires_feries_sens_1.add(truc);
                        }
                    }
                    station_precedente = G.liste_stations.get(l);
                }
            }
            if (test == 0) {
                Station newStation = new Station(nom_station);
                G.liste_stations.add(newStation);
                nomAller.addStation(newStation); 
                if (k > 0) {newStation.addVoisin(station_precedente);}
                for (int t = 1; t < split_horaires_normaux.length; t++) {
                    String split_time[] = split_horaires_normaux[t].split(":");
                    if (!split_time[0].equals("-")) {
                        Horaire truc = new Horaire (Integer.parseInt(split_time[0]), Integer.parseInt(split_time[1]), nomAller);
                        newStation.horaires_normaux_sens_1.add(truc);
                    }
                }
                for (int u = 1; u < split_horaires_feries.length; u++) {
                    String split_time_ferie[] = split_horaires_feries[u].split(":");
                    if (!split_time_ferie[0].equals("-")) {
                        Horaire truc = new Horaire (Integer.parseInt(split_time_ferie[0]), Integer.parseInt(split_time_ferie[1]), nomAller);
                        newStation.horaires_feries_sens_1.add(truc);
                    }
                }
                station_precedente = newStation;
            } else {test = 0;}
        }
        return nomAller;
    }

    public Line createLineRetour(Graph G) {
        String station_line = fileToArrayList().get(0);
        String split[] = station_line.split(" N ");
        int nbStations = split.length;
        Line nomRetour = new Line(this.nomRetour + split[0] + ") B");
        for (int k = 0; k < nbStations; k++) {
            String nom_station = split[nbStations - k - 1];
            String horaires_normaux = fileToArrayList().get(nbStations + 3 + k);
            String split_horaires_normaux[] = horaires_normaux.split(" ");
            String horaires_feries = fileToArrayList().get(3*nbStations + 7 + k);
            String split_horaires_feries[] = horaires_feries.split(" ");
            for (int l = 0; l < G.liste_stations.size(); l++) {
                if (G.liste_stations.get(l).getStation_name().equals(nom_station)) {
                    nomRetour.addStation(G.liste_stations.get(l));
                    for (int t = 1; t < split_horaires_normaux.length; t++) {
                        String split_time_normal[] = split_horaires_normaux[t].split(":");
                        if (!split_time_normal[0].equals("-")) {
                            Horaire truc = new Horaire (Integer.parseInt(split_time_normal[0]), Integer.parseInt(split_time_normal[1]), nomRetour);
                            G.liste_stations.get(l).horaires_normaux_sens_2.add(truc);
                        } 
                    }
                    for (int u = 1; u < split_horaires_feries.length; u++) {
                        String split_time_ferie[] = split_horaires_feries[u].split(":");
                        if (!split_time_ferie[0].equals("-")) {
                            Horaire truc = new Horaire (Integer.parseInt(split_time_ferie[0]), Integer.parseInt(split_time_ferie[1]), nomRetour);
                            G.liste_stations.get(l).horaires_feries_sens_2.add(truc);
                        }
                    }
                    }
            }
        }
        return nomRetour;
    }

    public void createLines(Graph G) {
        createLineAller(G);
        createLineRetour(G);
    }

    @Override
    public String toString() {
        String res = "Ligne : " + nomAller + "\n";
        for (int i = 0; i < this.fileToArrayList().size(); i++) {
            res = res + this.fileToArrayList().get(i) + '\n';
        }
        return res;
    }

}