//import java.io.File;

class Main {

    public static void main(String[] args) {
        System.out.println("\nCoucou, voici le début du programme\n");
        

        DataFiles myData = new DataFiles();
        
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_rouge.txt");                                 
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_bleue.txt");
        myData.addPath("C:/Users/val_p/Desktop/PROJ631/2_Java_Reseau_bus/Fichier_exemple/ligne_verte.txt");
        
        //System.out.println(myData + "\n");

        ReadFile myFile = new ReadFile(myData.paths_list.get(0));
        
        System.out.println(myFile);
      


        System.out.println("\nFin du programme \n");

        
    }

}