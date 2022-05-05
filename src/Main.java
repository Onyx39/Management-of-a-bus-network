class Main {

    public static void main(String[] args) {
        System.out.println("\nCoucou, voici le début du programme");
        

        DataFile myData = new DataFile();
        
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_rouge.txt");                                 
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_bleue.txt");
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_verte.txt");
        

        ReadFile myFile = new ReadFile(myData.paths_list.get(2));
        
        System.out.println(myFile);

        Horaire h1 = new Horaire(23, 56);
        System.out.println(h1);

        Horaire h2 = new Horaire(0, 57);

        Horaire h3 = h1.soustraction(h2);

        System.out.println(h3);
       
        Station gare = new Station("Ma première station");
        Line bleu = new Line("Ligne Bleue");

        gare.addHoraireNormal(h1);

        bleu.addStation(gare);

        System.out.println(bleu);



        System.out.println("\nFin du programme");

        
    }

}