/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Maaster
 */
public class RationaleZahlMaike {
   
       
        /**
         * Zaehler und Nenner eines Bruchs.
         */  
         
        private long zaehler;
        private long nenner;
       
       
        /**
         * Erzeugt eine ganze Zahl.
         * @param zahl die ganze Zahl
         */
       
        public RationaleZahlMaike(long zahl) {
           
            zaehler = zahl;
            nenner = 1;
        }
       
       
        /**
         * Erzeugt ein Objekt, das den Quotienten aus Zähler und Nenner
         * repräsentiert und kürzt dieses.
         * @param z1 der Zähler des Bruchs
         * @param n1 der Nenner des Bruchs
         */
       
        public RationaleZahlMaike(long z1, long n1) {
               
            long teiler = gibGroesstenTeiler(z1, n1);
           
            this.zaehler = z1 / teiler;
            this.nenner = n1 / teiler;
        }
       
        /**
         * Addiert eine Zahl auf eine rationale Zahl.
         * Inklusiviert gleichnamig machen der Brüche und Kürzen.
         * @param zahl die aufzuaddierende Zahl.
         * @return das Ergebnis der Addition
         */
       
        public RationaleZahlMaike addiere(RationaleZahlMaike zahl) {
           
            long ggt = gibGroesstenTeiler(this.nenner, zahl.nenner);
           
            return new RationaleZahlMaike(zahl.nenner / ggt * this.zaehler
                                     + this.nenner / ggt * zahl.zaehler
                                     , this.nenner / ggt * zahl.nenner);
        }
             
       
       
        /**
         * Berechnet den groeßten gemeinsamen Teiler zweier Zahlen.
         * @param zahl1 ertse Zahl
         * @param zahl2 zweite Zahl
         * @return der groeßte gemeinsame Teiler
         */
       
        private long gibGroesstenTeiler(long a, long b) {
                         
            return (b==0)
                    ? a
                    :gibGroesstenTeiler(b, a%b);
        }  
         
     
        /**
         * Gibt das Ergebnis der Addition zweier rationalen Zahlen auf dem
         * Bildschirm aus.
         * @return das Ergebnis der Addition
         */
       
        public String gibAlsText() {
                 
            return (nenner == 1)
                    ? zaehler + ""
                    : zaehler + "/" + nenner;
        }
               
    }

	

    



