/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Maaster
 */
public class RationaleZahlTest {
    
    public static void main(String[] args) {
         
        
        RationaleZahl zahl1 = new RationaleZahl(2, 8);
        
        System.out.println(zahl1.gibAlsText());
        
        RationaleZahl zahl2 = new RationaleZahl(5, 6);
        
        System.out.println(zahl1.addiere(zahl2).gibAlsText());
        
        System.out.println(zahl2.addiere(zahl1).gibAlsText());
        
        System.out.println(new RationaleZahl(17 , 4)
                            .addiere(new RationaleZahl(7,4)).gibAlsText());
        
        System.out.println(new RationaleZahl(100002, 4)
                            .addiere(new RationaleZahl(5))
                            .gibAlsText());
        
        System.out.println((new RationaleZahl(11, 2108303)
                            .addiere(new RationaleZahl(31, 2117009)))
                            .addiere(new RationaleZahl(47, 2134421))
                            .gibAlsText());
//       
        System.out.println(new RationaleZahl(3,3037000510L)
                            .addiere(new RationaleZahl(7, 3037000500L))
                            .gibAlsText());
        
        System.out.println(new RationaleZahlMaike(3,3037000510L)
                            .addiere(new RationaleZahlMaike(7, 3037000500L))
                            .gibAlsText());
       
    }
    
}


