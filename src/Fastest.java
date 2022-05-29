import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fastest {
    
    public int ferie;
    public Horaire heure_depart;
    public Station depart, noeud_courant, arrivee;
    public ArrayList<Station> reste_a_visiter;

    public Fastest (String unDepart, String uneArrivee, Horaire uneHeure, int testFerie, Graph unGraph) {
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
        System.out.println("PARCOURS FASTEST");
        System.out.println("[Initilisation pour l'algorithme de Dijkstra]");
        System.out.println(dictionnaire + "\n");
    }


    public boolean testFin (Map<String, Horaire> dictionnaire, ArrayList<Station> reste) {
        if (reste.size() == 0) {return true;}
        return false;
    }

    public Station newNoeudCourant(Map<String, Horaire> dictionnaire, ArrayList<Station> reste, Line laLigne) {
        Horaire hor_min = new Horaire(23, 59, null);
        ArrayList<Horaire> bonsHoraires = null;
        String sensLigne = String.valueOf(laLigne.line_name.charAt(laLigne.line_name.length() - 1));
        Station candidat = null;
        for (int i = 0; i < reste.size(); i++) {
            String nom = reste.get(i).station_name;
            if (ferie == 0 && sensLigne.equals("B")) {
                bonsHoraires = reste.get(i).horaires_normaux_sens_2;
            }
            else { if (ferie == 0 && sensLigne.equals("A")) {
                bonsHoraires = reste.get(i).horaires_normaux_sens_1;
    
            }
            else { if (ferie == 1 && sensLigne.equals("B")) {
                bonsHoraires = reste.get(i).horaires_feries_sens_2;
    
            }
            else {if (ferie == 1 && sensLigne.equals("A")) {
                bonsHoraires = reste.get(i).horaires_feries_sens_1;
    
            }}}}
            for (int j = 0; j < bonsHoraires.size(); j++) {
                //Horaire nextHoraire = null;
                for (int k = 0; k < bonsHoraires.size(); k++) {
                    if (dictionnaire.get(nom).inferieurA(hor_min) && bonsHoraires.get(k).ligne == laLigne) {
                        candidat = reste.get(i);
                        hor_min = heure_depart.soustraction(bonsHoraires.get(k));
                    }
                }
            }
        }
        return candidat;

    }

    public ArrayList<Station> resetResteAVisiter (Graph unGraph) {
        ArrayList<Station> reste_a_visiter = new ArrayList<Station>();
        for (int t = 0; t < unGraph.liste_stations.size(); t++) {
            reste_a_visiter.add(unGraph.liste_stations.get(t));
        }
        return reste_a_visiter;
    }
}
