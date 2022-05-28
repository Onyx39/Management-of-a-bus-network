class Main {

    public static void main(String[] args) {
        System.out.println("\nCoucou, voici le début du programme\n");
        

        DataFile myData1 = new DataFile();
        DataFile myData2 = new DataFile();
        Graph G1 = new Graph("G1");
        Graph G2 = new Graph("Test Simple");
        
        myData2.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_rouge.txt");                                 
        myData2.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_bleue.txt");
        myData2.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_verte.txt");
        
        ReadFile ligneRouge = new ReadFile("Rouge", myData2.paths_list.get(0));
        ReadFile ligneBleue = new ReadFile("Bleue", myData2.paths_list.get(1));
        ReadFile ligneVerte = new ReadFile("Verte", myData2.paths_list.get(2));
        
        /*ligneRouge.createLines(G2);
        ligneBleue.createLines(G2);
        ligneVerte.createLines(G2);*/
        
        myData1.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/data/1_Poisy-ParcDesGlaisins.txt");
        myData1.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/data/2_Piscine-Patinoire_Campus.txt");

        ReadFile L1 = new ReadFile("1", myData1.paths_list.get(0));
        ReadFile L17 = new ReadFile("17", myData1.paths_list.get(1));

        L1.createLines(G1);
        L17.createLines(G1);

        /*System.out.println(G1.liste_stations.get(6) + "\n");
        System.out.println(G1.liste_stations.get(6).horaires_feries_sens_1 + "\n");
        System.out.println(G1.liste_stations.get(6).horaires_normaux_sens_1 + "\n");
        System.out.println(G1.liste_stations.get(6).horaires_feries_sens_2 +  "\n");
        System.out.println(G1.liste_stations.get(6).horaires_normaux_sens_2 +  "\n");

        System.out.println(G1 + "\n");*/

        new Shortest("GARE", "Place_des_Romains", new Horaire (10, 10, null), 0, G1);
        new Shortest("GARE", "Place_des_Romains", new Horaire (10, 10, null), 1, G1);

        /*System.out.println(G1.liste_stations.get(8).horaires_normaux_sens_1 + "\n");
        System.out.println(G1.liste_stations.get(8).horaires_normaux_sens_2 + "\n");
        System.out.println(G1.liste_stations.get(8).horaires_feries_sens_1 + "\n");
        System.out.println(G1.liste_stations.get(8).horaires_feries_sens_2 + "\n");
        System.out.println(G1.liste_stations.get(20).horaires_normaux_sens_1 + "\n");
        System.out.println(G1.liste_stations.get(20).horaires_normaux_sens_2 + "\n");*/

        

        System.out.println("\nFin du programme\n");

        
    }

}