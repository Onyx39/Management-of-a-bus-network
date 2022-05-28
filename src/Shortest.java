import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shortest {

    public int ferie;
    public Horaire heure_depart;
    public Station depart, noeud_courant, arrivee;
    public ArrayList<Station> reste_a_visiter;

    public Shortest (String unDepart, String uneArrivee, Horaire uneHeure, int testFerie, Graph unGraph) {
        heure_depart = uneHeure;
        ferie = testFerie;
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
        if (depart == arrivee) {
            throw new java.lang.Error("Vous avez rentré deux fois le même station");
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
        //System.out.println(dictionnaire + "\n");
        System.out.println(this.toString(dictionnaire));

    }  

    public boolean testFin (Map<String, Integer> dictionnaire, ArrayList<Station> reste ) {
        if (reste.size() == 0) {return true;}
        return false;
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

    public String toString (Map<String, Integer> dictionnaire) {
        String ligne = "";
        //System.out.println(depart);
        //System.out.println(arrivee);
;       String res = "PARCOURS SHORTEST \nPour aller de " + depart.station_name + " à " + arrivee.station_name + ", ";
        for (int i = 0; i < depart.lines.size(); i++) {
            for (int j = 0; j < arrivee.lines.size(); j++) {
                //System.out.println(depart.lines.get(i).station_list.indexOf(depart));
                //System.out.println(depart.lines.get(i).equals(arrivee.lines.get(j)) && depart.lines.get(i).station_list.indexOf(depart) < arrivee.lines.get(j).station_list.indexOf(arrivee));
                //System.out.println(depart.lines.get(i).equals(arrivee.lines.get(j)) + " : " + arrivee.lines.get(j));
                if (depart.lines.get(i).equals(arrivee.lines.get(j)) && depart.lines.get(i).station_list.indexOf(depart) < arrivee.lines.get(j).station_list.indexOf(arrivee)) {
                    ligne = depart.lines.get(i).line_name;
                    //System.out.println(ligne + "****blkj");
                }
            }
        }
        res += "prenez la ligne " + ligne;
        res = res.substring(0, res.length()-2); 
        res += "\n";
        res += "Vous descendrez dans " + dictionnaire.get(arrivee.station_name) + " stations \n";
        res += "Votre prochain horaire est " + getProchainHoraire(ligne).toString();
        res = res.substring(0, res.length()-4);
        res += "\n"; 
        return res;
    }

    public Horaire getProchainHoraire(String nom_ligne) {
        //System.out.println(nom_ligne);
        Line bonneLigne = null;
        for (int u = 0; u < depart.lines.size(); u++) {
            //System.out.println(depart.lines.get(u).line_name);
            //System.out.println(nom_ligne);
            if (depart.lines.get(u).line_name.equals(nom_ligne)) {
                bonneLigne = depart.lines.get(u);
                //System.out.println(bonneLigne);
            }
        }
        String sensLigne = bonneLigne.line_name.valueOf(bonneLigne.line_name.charAt(bonneLigne.line_name.length() - 1));
        //System.out.println(sensLigne);
        ArrayList<Horaire> bonsHoraires = null;
        if (ferie == 0 && sensLigne.equals("B")) {
            bonsHoraires = depart.horaires_normaux_sens_2;
        }
        else { if (ferie == 0 && sensLigne.equals("A")) {
            bonsHoraires = depart.horaires_normaux_sens_1;
        }
        else { if (ferie == 1 && sensLigne.equals("B")) {
            bonsHoraires = depart.horaires_feries_sens_2;
        }
        else {if (ferie == 1 && sensLigne.equals("A")) {
            bonsHoraires = depart.horaires_feries_sens_1;
        }}}}
        //System.out.println(bonsHoraires);
        for (int i = 0; i < bonsHoraires.size(); i++) {
            if (bonsHoraires.get(i).superieurA(heure_depart) && bonsHoraires.get(i).ligne.line_name == nom_ligne) {
                return bonsHoraires.get(i);
        }
        }
        /*if (ferie == 0) {
        Horaire cand = depart.horaires_normaux_sens_1.get(0);
        for (int v = 1; v < depart.horaires_normaux_sens_1.size() - 500; v++) {
            System.out.println(depart.horaires_normaux_sens_1.get(v).ligne + " : " + bonneLigne);
            System.out.println(depart.horaires_normaux_sens_1.get(v).superieurA(heure_depart) && depart.horaires_normaux_sens_1.get(v).ligne == bonneLigne);
            if (depart.horaires_normaux_sens_1.get(v).superieurA(heure_depart) && depart.horaires_normaux_sens_1.get(v).ligne == bonneLigne) {
                return depart.horaires_normaux_sens_1.get(v);
            }
        }
        }
        else {
            Horaire cand = depart.horaires_feries_sens_1.get(0);
            for (int v = 1; v < depart.horaires_feries_sens_1.size(); v++) {
                if (depart.horaires_feries_sens_1.get(v).inferieurA(heure_depart) && depart.horaires_normaux_sens_1.get(v).ligne == bonneLigne) {
                    return depart.horaires_feries_sens_1.get(v);
                } 
            }
        }*/
        return heure_depart;
    }

}
