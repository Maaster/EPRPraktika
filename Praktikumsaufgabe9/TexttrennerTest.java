/**
 *
 * @author Maaster
 */
public class TexttrennerTest {
    
    public static void main(String[] args)
    {
        Texttrenner trenner = new Texttrenner("--xx+-yy-+abc--", "+-");
        
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.gibNaechstesWort());
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.gibNaechstesWort());
        System.out.println(trenner.gibNaechstesWort());
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.hatNochWoerter());
        System.out.println(trenner.gibNaechstesWort());
    }
    
}
