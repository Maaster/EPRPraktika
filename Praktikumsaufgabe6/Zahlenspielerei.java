/**
 * Diese Klasse enthält rekursive Methoden, um mit Zahlen zu rechnen.
 *
 * @author maaster
 */
public class Zahlenspielerei {
    
    /**
     * Testet die rekursiven Methoden enthaelt, gibAnzahl und filter.
     * @param args nicht verwendet
     */
    public static void main(String[] args)
    {
//        System.out.println(enthaelt(33, 7));
//        System.out.println(enthaelt(4717, 2));
//        System.out.println(enthaelt(789, 9));
//        System.out.println(enthaelt(0, 0));
//        System.out.println(gibAnzahl(4716, 1));
//        System.out.println(gibAnzahl(321, 1));
//        System.out.println(gibAnzahl(321, 4));
//        System.out.println(gibAnzahl(0, 3));
//        System.out.println(gibAnzahl(0,0));
//        System.out.println(filter(4331,3));
//        System.out.println(filter(2365,5));
//        System.out.println(filter(5456,7));
//        System.out.println(filter(777,7));
        
       System.out.println(fib(6));
    }
    
    public static int fib(int grenze) {
        return fib(0, 1, 1, grenze);
    }
    
    public static int fib(int zahl1, int zahl2, int zaehler, int grenze) {
        return (zaehler <= grenze)
                ? fib(zahl2, zahl1 + zahl2, zaehler + 1, grenze)
                : zahl2;
    }
    
    
    /**
     * Prüft, ob eine Ziffer in einer Zahl vorhanden ist.
     * @param zahl Zahl > 0, in der die Ziffer vorhanden sein kann
     * @param ziffer Ziffer zwischen 0 und 9, die zu prüfen ist
     * @return true, wenn Ziffer in Zahl vorhanden ist.
     *         
     */
    public static boolean enthaelt(long zahl, int ziffer)
    {
        return (zahl % 10 == ziffer)
                ? true
                : (zahl < 10)
                    ? false
                    : enthaelt(zahl / 10, ziffer);
    }
    
    /**
     * Gibt wieder, wie oft eine Ziffer in Zahl vorhanden ist.
     * @param zahl Zahl > 0, in der die Ziffer vorhanden sein kann
     * @param ziffer Ziffer zwischen 0 und 9, die zu prüfen ist
     * @return Anzahl, wie oft Ziffer in Zahl ist
     */
    public static int gibAnzahl(long zahl, int ziffer)
    {
        return (zahl < 10)
                ? (ziffer == zahl)
                    ? 1
                    : 0                
                : (zahl % 10 == ziffer)
                    ? gibAnzahl(zahl / 10, ziffer) + 1
                    : gibAnzahl(zahl / 10, ziffer);
}
    
    /**
     * Streicht aus einer Zahl alle vorkommenden Stellen, die gleich der 
     * übergebenen Ziffer ist
     * @param zahl Zahl > 0, die zu filtern ist
     * @param ziffer Ziffer zwischen 0 und 9, mit der zu filtern ist
     * @return zahl ohne jegliche Stellen, die gleich ziffer sind.
     */
    public static long filter(long zahl, int ziffer)
    {   
        return (zahl < 10)
                ? (zahl == ziffer)
                    ? 0
                    : zahl
                : (zahl % 10 == ziffer)
                    ? filter(zahl / 10, ziffer)
                    : filter(zahl / 10, ziffer) * 10 + (zahl % 10);
    }
    
}
