/**
 * Dieses Programm berechnet die Stromrechnung für einen Privathaushalt.
 * @author maaster
 */
public class Stromrechnung {

    /**
    * Dieses Programm berechnet die Stromrechnung für einen Privathaushalt.
    * 
    * @param args nicht verwendet
    */
    
    public static void main(String[] args) {
        
        int anzahlMonate = 12;
        
        double grundpreisA = 5.75;
        double grundpreisB = 9.85;
        double verbrauchspreisA = 23.49;
        double verbrauchspreisB = 22.10;
        double kWhVerbrauch = 3536;
        
        double endpreisA, endpreisB, billigererPreis;
        
        
        endpreisA = ((kWhVerbrauch * (verbrauchspreisA / 100)) + anzahlMonate 
                    * grundpreisA);
        
        endpreisB = ((kWhVerbrauch * (verbrauchspreisB / 100)) + anzahlMonate 
                    * grundpreisB);
        
        /*
        Billigeren Preis berechnen
        */
        
        billigererPreis = (endpreisA <= endpreisB) ? endpreisA : endpreisB;
        
        /*
        Gerundeten Centbetrag berechnen um im nächsten Schritt auf 2 
        Nachkommastellen abzuschneiden 
        */
        
        billigererPreis = 0.01 * (100 * endpreisA + 0.5) * 100;
        
        billigererPreis = (int) billigererPreis;
        
        billigererPreis = (double) billigererPreis / 100;
        
        System.out.println(billigererPreis);
    }
}
