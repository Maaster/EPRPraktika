/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//
package test2;

///**
// *
// * @author Christopher Nielsen
// */
//
//public class RationaleZahl {
//    
//    private long zaehler;
//    private double nenner;
//    
//    public RationaleZahl(long ganzeZahl) {
//        zaehler = ganzeZahl;
//        nenner = 1;
//    }
//    
//    public RationaleZahl(long zaehler, long nenner) {
//        this.zaehler = zaehler;
//        this.nenner = nenner;
//    }
//    
//    public RationaleZahl addiere(RationaleZahl zahl) {
//        //ToDo: "zahl" wird hier und in Zeile 19 verwendet. Gleicher Variablennahme
//        //für unterschiedliche Datentypen (long, RationaleZahl) - ändern z.B. in rationaleZahl und/oder in Zeile 19 in ganzeZahl
//        this.gleicheNennerAn(zahl);
//        this.zaehler = this.zaehler + zahl.zaehler;
//        
//        return this;
//    }
//    
//    public static void main(String [] args)
//    {
//        RationaleZahl rationaleZahl = new RationaleZahl(3,3037000510l);
//        RationaleZahl rationaleZahl2 = new RationaleZahl(7,3037000500l);
//        rationaleZahl.addiere(rationaleZahl2);
//        
//        String ausgabe = rationaleZahl.gibAlsText();
//        System.out.println(ausgabe);
//    }
//    public void gleicheNennerAn(RationaleZahl zahl) {
//        double gemeinsamerTeiler = zahl.nenner * this.nenner;
//        
//        //Zähler erweitern um Nenner
//        this.zaehler = (long) (this.zaehler * zahl.nenner);
//        zahl.zaehler = (long) (zahl.zaehler * this.nenner);
//        
//        //Nenner angleichen
//        zahl.nenner = gemeinsamerTeiler;
//        this.nenner = gemeinsamerTeiler;
//    }
//    
//    public void kuerzen() {
//        double ggt = ggt(zaehler,nenner);
//        
//        //überschreibe Ergebnis, da "2" für die letzte Aufgabe falsch ist
//        //ToDo: ggt korrigieren
//        ggt = 1;
//        
//        zaehler = (long) (zaehler / ggt);
//        nenner = nenner / ggt;
//    }
//    
//    //Größter Gemeinsamer Teiler
//    public double ggt(double a, double b) {
//        return (b==0)
//                ? a
//                :ggt(b, a%b);
//    }
//    
//    public String gibAlsText() {
//        //Kürzen vor der Ausgabe
//        this.kuerzen();
//        
//        //ToDo: nenner formatieren - ohne "." und "E18"
//        
//        //Ausgabe vom fertigen Bruch bzw. der Zahl, falls die Zahl ganz ist
//        return (nenner == 1)
//                ? zaehler + ""
//                : zaehler + " / " + nenner;
//    }
//}


	

    /**
     * Diese Methode kann rationale Zahlen in Bruchform darstellen,
     * addieren und gekürzt ausgeben
     * @author Christopher Nielsen
     */
     
    public class RationaleZahl {
       
        private long zaehler;
        private long nenner;
       
        /**
         * Konstruktor für eine ganze Zahl
         * @param ganzeZahl Ganze Zahl, die als rationale dargestellt werden soll.
         */
        public RationaleZahl(long ganzeZahl) {
            zaehler = ganzeZahl;
            nenner = 1;
        }
       
        /**
         * Konstruktor für einen Bruch
         * @param zaehler Zähler des Bruches
         * @param nenner Nenner des Bruches
         */
        public RationaleZahl(long zaehler, long nenner) {
            
            // Größter Gemeinsamer Teiler zum kürzen der Brüche
            long ggT = ggt(zaehler, nenner);
            
            this.zaehler = zaehler / ggT;
            this.nenner = nenner / ggT;
        }
       
        /**
         * Addiert einen übergebenen Bruch mit der Rationalen Zahl
         * @param zahl Zu addierende Zahl
         * @return Neue RationaleZahl, die den Wert der Summe des alten und
         *          übergeben Bruches enthält.
         */
        public RationaleZahl addiere(RationaleZahl zahl) {
           
//            this.gleicheNennerAn(zahl);
//            this.zaehler = this.zaehler + zahl.zaehler;
//           
//            return this;
            
            
            long ggt = ggt(this.nenner, zahl.nenner);
            
            return new RationaleZahl(zahl.nenner / ggt * this.zaehler 
                                    + this.nenner / ggt * zahl.zaehler 
                                    , this.nenner / ggt * zahl.nenner);
        }
       
       
        /**
         * Ermittelt den größten gemeinsamen Teiler für 2 Zahlen
         * @param a Erste Zahl
         * @param b Zweite Zahl
         * @return Größter Gemeinsamer Teiler für a und b
         */
        private static long ggt(long a, long b) {
            return (b==0)
                    ? a
                    :ggt(b, a%b);
        }
       
       /**
        * Gibt den aktuellen Bruch in Text-Form aus
        * @return Bruch als String
        */
        public String gibAlsText() {
           
//            //Kürzen vor der Ausgabe
//            this.kuerzen();
           
            //Ausgabe vom fertigen Bruch bzw. der Zahl, falls die Zahl ganz ist
            return (nenner == 1)
                    ? zaehler + ""
                    : zaehler + " / " + nenner;
        }
    }


               
        
        
        
        
        
        
        
//        public void gleicheNennerAn(RationaleZahl zahl) {
//           
//            long gemeinsamerTeiler = zahl.nenner * this.nenner;
//           
//            //Zähler erweitern um Nenner
//            this.zaehler = this.zaehler * zahl.nenner;
//            zahl.zaehler = zahl.zaehler * this.nenner;
//           
//            //Nenner angleichen
//            zahl.nenner = gemeinsamerTeiler;
//            this.nenner = gemeinsamerTeiler;
//           
//        }
       
//        public void kuerzen() {
//           
//            long ggt = ggt(zaehler, nenner);
//           
//            zaehler = zaehler / ggt;
//            nenner = nenner / ggt;
//        }
//    }


