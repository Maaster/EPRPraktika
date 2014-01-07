/**
 * Diese Klasse führt Zinsrechnung aus
 * 
 * @author maaster
 */

public class Prozentrechnungen 
{
    /**
    * Diese Klasse führt Zinsrechnung aus
    *
    * @param args nicht verwendet
    */
    
    public static void main(String[] args)
    {
        
        /*
        * Auflösen des Bruches um Abschneiden durch int 
        * und damit ein null-werden des Summanden zu vermeiden
        */ 
        System.out.println((240 * (100 + 3) / 100));
        System.out.println((80 * (100 + 2) / 100));
        
        System.out.println(240 * (100 + 7) * (100 + 7) / 100 * 100);
    }
}
