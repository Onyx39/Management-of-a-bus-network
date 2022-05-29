import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Foremost {
    
    public int ferie;
    public Horaire heure_depart;
    public Station depart, noeud_courant, arrivee;
    public ArrayList<Station> reste_a_visiter;

    public Foremost (String unDepart, String uneArrivee, Horaire uneHeure, int testFerie, Graph unGraph) {
        heure_depart = uneHeure;
        ferie = testFerie;
        ArrayList<Station> reste_a_visiter = new ArrayList<Station>();
        for (int t = 0; t < unGraph.liste_stations.size(); t++) {
            reste_a_visiter.add(unGraph.liste_stations.get(t));
        }
        for (int v = 0; v < reste_a_visiter.size(); v++) {
            //System.out.println(reseau.liste_stations.get(v).station_name);
            if (reste_a_visiter.get(v).station_name.equals(unDepart)) {
                depart = reste_a_visiter.get(v);
                noeud_courant = depart;
            }
            if (reste_a_visiter.get(v).station_name.equals(uneArrivee)) {
                arrivee = reste_a_visiter.get(v);
            }
        }
        if (depart == null || arrivee == null) {
            throw new java.lang.Error("Les noms de stations ne sont pas valides");
        }
        if (depart == arrivee) {
            throw new java.lang.Error("Vous avez rentré deux fois le même station");
        }
        Map<String, Horaire> dictionnaire = new HashMap<>();
        for (int t = 0; t < reste_a_visiter.size(); t++) {
            if (reste_a_visiter.get(t) == depart) {
                dictionnaire.put(reste_a_visiter.get(t).station_name, new Horaire(0, 0, null));
            }
            else {dictionnaire.put(reste_a_visiter.get(t).station_name, new Horaire(23, 59, null));}
        }   
        System.out.println("PARCOURS FOREMOST");
        System.out.println("[Initilisation pour l'algorithme de Dijkstra]");
        System.out.println(dictionnaire + "\n");

    }
}