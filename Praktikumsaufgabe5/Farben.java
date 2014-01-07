/**
 *Dieses Programm enthält Methoden um mit RGB-Farben zu rechnen.
 * @author maaster
 */

public class Farben {
    
    /**
     * Testet die Methoden invertiere und gibNaechsteFarbe
     * @param args Nicht verwendet
     */
    
    public static void main(String[] args){
        System.out.println(invertiere(0));
        System.out.println(invertiere(10128255));
        System.out.println(gibNaechsteFarbe(10011012));
        System.out.println(gibNaechsteFarbe(10128255));
        System.out.println(gibNaechsteFarbe(255255));
        System.out.println(gibNaechsteFarbe(255255255));
    }
    
    /**
     * Invertiert eine Eingangsfarbe
     * @param farbe Eingangsfarbe, die zu invertieren ist
     * @return Invertierte Farben
     */
    
    public static int invertiere(int farbe){
        return 255255255 - farbe;
    }
    
    /**
     * Gibt die nächste Farbe für die Eingangsfarbe. Falls der Blau-Wert
     * oder der Grün-Wert 255 überschreitet, wird er auf 0 gesetzt und der
     * nächsthöhere wird erhöht.
     * @param farbe Eingangsfarbe, für die die nächste Farbe berechnet wird.
     * @return Nächste Farbe der Eingangsfarbe.
     */
    
    public static int gibNaechsteFarbe(int farbe){
        int rot;
        int gruen;
        int blau;
        int naechsteFarbe;
        
        /*
        Einzelne Werte rausziehen 
        */
        
        //Einzelne Werte rausziehen
        
        rot = (farbe / 1_000_000);
        gruen = ((farbe / 1000) % 1000);
        blau = (farbe % 1000);
        
        /*
        Lösung berechnen, den nächsten Wert um 1 erhöhen, falls vorheriger
        Wert bei 255 liegt
        */
        
        
        naechsteFarbe = (blau < 255) 
                        ? rot * 1000000 + gruen * 1000 + blau + 1
                        : (gruen < 255)
                            ? rot * 1000000 + (gruen +1) * 1000
                            : (rot < 255)
                                ? (rot + 1) * 1000000
                                : 0;
        
        return naechsteFarbe;
        
    }
}
