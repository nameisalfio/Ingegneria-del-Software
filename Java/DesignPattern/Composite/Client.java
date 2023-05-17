public class Client{
    public static void main(String[] args) {

        // Creazione dei file
        File file_reti = new File("Reti_di_calcolatori.txt");
        File file_lab_reti = new File("Lab_reti.txt");
        File file_sistemi = new File("Sistemi_operativi.txt");
        File file_lab_sistemi = new File("Lab_sistemi.txt");
        File file_ingegneria = new File("Ingegneria_del_software.txt");

        // Creazione delle cartelle
        Folder materie = new Folder("Materie");  //root
        Folder reti = new Folder("Reti_di_calcolatori");  //sub1
        Folder sistemi = new Folder("Sistemi_operativi");    //sub1
        Folder ingegneria = new Folder("Ingegneria_del_software");  //sub1
        Folder lab_reti = new Folder("Laboratorio_reti");   //sub 2
        Folder lab_sistemi = new Folder("Laboratorio_sistemi");   //sub 3


        // Aggiunta dei file alle cartelle
        materie.add(reti);
        materie.add(sistemi);
        materie.add(ingegneria);

        // Aggiunta delle sottocartelle 
        reti.add(lab_reti);
        sistemi.add(lab_sistemi);

        //Aggiunta file
        reti.add(file_reti);
        sistemi.add(file_sistemi);
        ingegneria.add(file_ingegneria);
        lab_reti.add(file_lab_reti);
        lab_sistemi.add(file_lab_sistemi);
        
        // Esegui la ricerca
        materie.search("Lab_reti.txt");
    }
}
