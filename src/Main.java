//import java.io.File;

class Main {

    public static void main(String[] args) {
        System.out.println("\nCoucou, voici le début du programme\n");
        

        DataFile myData = new DataFile();
        
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_rouge.txt");                                 
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_bleue.txt");
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_verte.txt");
        

        ReadFile myFile = new ReadFile(myData.paths_list.get(2));
        
        System.out.println(myFile);
       
        Station gare = new Station("Ma première station");
        Line bleu = new Line("Ligne Bleue");

        bleu.addStation(gare);

        System.out.println(bleu);

        System.out.println("\nFin du programme \n");

        
    }

}