
/**
 * Diese Klasse addiert 2 Zahlen in einem beliebigen Zahlensystem zwischen
 * 1 und 10.
 * @author Christopher Nielsen
 */
public class Zahldarstellung {
    
    /**
     * Diese Klasse testet die Methode addiere
     * @param args nicht verwendet
     */
    
    public static void main(String[] args){
//        
//        System.out.println(addiere(1001, 11, 2));
//        System.out.println(addiere(11011, 1110, 2));
//        System.out.println(addiere(210, 11, 2));
//        System.out.println(addiere(773, 0, 8));
//        System.out.println(addiere(0, 107, 8));
//        System.out.println(addiere(773, 107, 8));
//        System.out.println(addiere(773, 1239, 8));
//        System.out.println(addiere(950, 192, 8));
//        System.out.println(addiere(9145, 882, 10));
//        System.out.println(addiere(11111111111L, 1, 2));
//        System.out.println(addiere(323, 133, 4));
        
    }
    
    /**
     * Diese Klasse addiert zwei Zahlen zu einer gewählten Basis
     * @param zahl1 Erste zu addierende Zahl.
     * @param zahl2 Zweite zu addierende Zahl.
     * @param basis Basis zwischen 1 und 10.
     * @return Addierte Zahl zur gewählten Basis.
     */
    
    public static long addiere(long zahl1, long zahl2, int basis) {
        
        return (hatUngueltigeZahlen(zahl1, basis) 
                || hatUngueltigeZahlen(zahl2, basis))
                ? -1
                : zurBasis(zuDezimal(zahl1, basis) + zuDezimal(zahl2, basis), basis);
    }
    
    /**
     * Wandelt eine Zahl zur gewählten Basis in eine Dezimalzahl um.
     * @param zahl Umzuwandelnde Zahl.
     * @param basis Basis der Eingangzahl.
     * @return Eingangszahl im Dezimalsystem.
     */
    
    public static long zuDezimal(long zahl, int basis) {
        return (zahl < basis)
                ? zahl
                : zuDezimal(zahl / 10, basis) * basis + (zahl % 10);
    }
    
    /**
     * Wandelt eine Dezimalzahl in eine gewählte Basis um.
     * @param zahl Umzurechnende Zahl im Dezimalsystem.
     * @param basis Basis, zu der umgewandelt werden soll.
     * @return Eingangszahl in der gewählten Basis.
     * 
     */
    
    public static long zurBasis(long zahl, int basis) {
        return (zahl < basis)
                ? zahl
                : zurBasis(zahl / basis, basis) * 10 + (zahl % basis);
    }
    
    
    /**
     * Prüft bei einer Zahl, ob sie in der angegebenen Basis darstellbar ist.
     * @param zahl Eingangszahl, die zu prüfen ist.
     * @param basis Basis, in der zu prüfen ist.
     * @return true, wenn sie darstellbar ist, sonst false.
     */
    
    public static boolean hatUngueltigeZahlen(long zahl, int basis) {
        return (zahl < basis)
                ? false
                : (zahl % 10 >= basis)
                    ? true
                    : hatUngueltigeZahlen(zahl / 10, basis);
    }
}
