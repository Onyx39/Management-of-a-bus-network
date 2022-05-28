import java.util.ArrayList;

public class Graph {
    
    public String nom;
    public ArrayList<Station> liste_stations;

    public Graph (String unNom) {
        nom = unNom;
        liste_stations = new ArrayList<Station>();
    }

    public ArrayList<String> getLinesName () {
        ArrayList<String> liste_lignes = new ArrayList<String>();
        for (int i = 0; i < liste_stations.size(); i++) {
            for (int k = 0; k < liste_stations.get(i).lines.size(); k++) {

            }
        }
        return liste_lignes;
    }


    @Override
    public String toString() {
        String res = "Graph : " + nom + '\n';
        for (int h = 0; h < liste_stations.size(); h++) {
            res += "   " + liste_stations.get(h).toString() + '\n';
        }
        return res;
    }
}
