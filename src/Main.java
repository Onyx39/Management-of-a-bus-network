import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        System.out.println("\n[DEBUT DU PROGRAMME]\n");
        
        Data myData = new Data();
        Graph G = new Graph("G1");
        ArrayList<String> nom_des_lignes = new ArrayList<String>(Arrays.asList("1", "17"));
        
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/data/1_Poisy-ParcDesGlaisins.txt");
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/data/2_Piscine-Patinoire_Campus.txt");

        for (int i = 0; i < myData.paths_list.size(); i++) {
            String nom_ligne = nom_des_lignes.get(i);
            new ReadFile(nom_ligne, myData.paths_list.get(i)).createLines(G);
        }

        new Shortest("Chorus", "GARE", new Horaire (10, 10, null), 0, G);
        new Shortest("Chorus", "Pommaries", new Horaire (10, 10, null), 1, G);

        new Fastest("Chorus", "GARE", new Horaire (10, 10, null), 0, G);

        new Foremost("Pommaries", "GARE", new Horaire (10, 10, null), 0, G);        

        System.out.println("[FIN DU PROGRAMME]\n");

        
    }

}