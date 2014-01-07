/**
 * Führt Zins- und Zinseszinsberechnungen durch
 * 
 * @author maaster
 */

public class Zinsberechnung {
    
    /**
     * Führt Zins- und Zinseszinsberechnungen durch
     * 
     * @param args nicht verwendet 
     */
   
    
     public static void main(String[] args) {
        int kapital = 800;
        int zinssatz = 2;
        
        int euroBetrag;
        int centBetrag;
        
        /*
        *  Auflösen des Bruches um Abschneiden durch int 
        *  und damit ein null-werden des Summanden zu vermeiden
        */
        
        euroBetrag = ((kapital * (100 + zinssatz) / 100));
        
        /*
        *  Eurobetrag mal 100 vom Euro-Cent-Betrag ohne Komma abgezogen
        *  um Cent-Betrag zu erhalten
        */
        
        centBetrag = (kapital * (100 + zinssatz)) - (euroBetrag * 100);
        
        System.out.print(euroBetrag);
        System.out.print(',');
        System.out.println(centBetrag);
        
        euroBetrag = (euroBetrag * (100 + zinssatz) / 100);
        
        centBetrag = ((kapital * (100 + zinssatz) * (100 + zinssatz)) / 100)
                        - (euroBetrag * 100);
        
        System.out.print(euroBetrag);
        System.out.print(',');
        System.out.println(centBetrag);
        
        euroBetrag = ((euroBetrag * (100 + zinssatz) / 100));
        
        centBetrag = ((kapital * (100 + zinssatz) * (100 + zinssatz)
                        * (100 + zinssatz)) / 10000) - (euroBetrag * 100);
        
        System.out.print(euroBetrag);
        System.out.print(',');
        System.out.println(centBetrag);
        
        centBetrag = ((kapital * (100 + zinssatz) * (100 + zinssatz) * (100 + zinssatz)) / 1000) - (euroBetrag * 1000);
        
        /*
        * Addierung von 5 und Division durch 10 um Aufzurunden
        */
        
        centBetrag = (centBetrag + 5) / 10;
        
        System.out.print(euroBetrag);
        System.out.print(',');
        System.out.println(centBetrag);
        
        
    }
}
