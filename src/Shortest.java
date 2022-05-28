import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shortest {

    public int ferie;
    public Station depart, noeud_courant, arrivee;
    public ArrayList<Station> reste_a_visiter;

    public Shortest (String unDepart, String uneArrivee, int ferie, Graph unGraph) {
        reste_a_visiter = new ArrayList<Station>();
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
        Map<String, Integer> dictionnaire = new HashMap<>();
        for (int t = 0; t < reste_a_visiter.size(); t++) {
            if (reste_a_visiter.get(t) == depart) {
                dictionnaire.put(reste_a_visiter.get(t).station_name, 0);
            }
            else {dictionnaire.put(reste_a_visiter.get(t).station_name, Integer.MAX_VALUE);}
        }   
        /*System.out.println(dictionnaire);
        System.out.println(noeud_courant);

        for (int l = 0; l < noeud_courant.voisins.size(); l++) {
            String nom_voisin = noeud_courant.getVoisins().get(l).station_name;
            dictionnaire.replace(nom_voisin, 1);
        }
        System.out.println(dictionnaire);
        System.out.println(testFin(dictionnaire));
        dictionnaire.replace("Arret_2", 458);
        System.out.println(testFin(dictionnaire));*/

        while (!testFin(dictionnaire, reste_a_visiter)) {
            for (int l = 0; l < noeud_courant.voisins.size(); l++) {
                String nom_voisin = noeud_courant.getVoisins().get(l).station_name;
                Integer candidat = dictionnaire.get(noeud_courant.station_name) + 1;
                if (dictionnaire.get(nom_voisin) > candidat) {dictionnaire.replace(nom_voisin, candidat);}
            }
            for (int u = 0; u < reste_a_visiter.size(); u++) {
                if (reste_a_visiter.get(u).station_name.equals(noeud_courant.station_name)) {
                    reste_a_visiter.remove(u);
                }
            }
            noeud_courant = newNoeudCourant(dictionnaire, reste_a_visiter);
        }
        System.out.println(dictionnaire + "\n");


    }  

    public boolean testFin (Map<String, Integer> dictionnaire, ArrayList<Station> reste ) {
        if (reste.size() == 0 ) {return true;}
        return false;
        /*for (int i = 0; i < reseau.liste_stations.size(); i++) {
            if (dictionnaire.get(reseau.liste_stations.get(i).station_name) == Integer.MAX_VALUE) {
                return false;
            }
        }
        return true;*/
    }

    public Station newNoeudCourant(Map<String, Integer> dictionnaire, ArrayList<Station> reste) {
        Integer num_min = Integer.MAX_VALUE;
        Station candidat = null;
        for (int i = 0; i < reste.size(); i++) {
            String nom = reste.get(i).station_name;
            if (dictionnaire.get(nom) < num_min) {
                candidat = reste.get(i);
                num_min = dictionnaire.get(nom);
            }
        }
        //System.out.println(candidat);
        return candidat;

    }

}
