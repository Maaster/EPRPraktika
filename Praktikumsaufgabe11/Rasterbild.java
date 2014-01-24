package test2;

/**
 *
 * @author Maaster
 */
public class Rasterbild {
    
    private java.awt.Color[][] rechteck;
    private int breite;
    private int hoehe;
    private Liste pixelListe;
    private int i;
    
    public Rasterbild(java.awt.Color[][] rechteck) {
        this.rechteck = rechteck;
        breite = rechteck.length;
        hoehe = rechteck[0].length;
        i = 0;
    }
    
    public int gibBreite() {
        return breite;
    }
    
    public int gibHoehe() {
        return hoehe;
    }
    
    public java.awt.Color gibFarbe(int x, int y) {
        return rechteck[x][y];
    }
    
    public void fuelleFlaeche(Punkt startpunkt, java.awt.Color neueFarbe) {
//        if(rechteck[startpunkt.gibX()][startpunkt.gibY()].equals
//                (java.awt.Color.WHITE) && (startpunkt.gibX() < breite  &&
//                                            startpunkt.gibY() < hoehe)
//                && !rechteck[startpunkt.gibX()][startpunkt.gibY()].equals
//                (neueFarbe)) {
//            
//            rechteck[startpunkt.gibX()][startpunkt.gibY()] = neueFarbe;
//            fuelleFlaeche(new Punkt(startpunkt.gibX() + 1, startpunkt.gibY()),
//                    neueFarbe);
//            fuelleFlaeche(new Punkt(startpunkt.gibX() - 1, startpunkt.gibY()),
//                    neueFarbe);
//            fuelleFlaeche(new Punkt(startpunkt.gibX(), startpunkt.gibY() + 1),
//                    neueFarbe);
//            fuelleFlaeche(new Punkt(startpunkt.gibX(), startpunkt.gibY() - 1),
//                    neueFarbe);
//        }
        
        pixelListe = new Liste();
        java.awt.Color anfangsFarbe = rechteck[startpunkt.gibX()][startpunkt.gibY()];
        
        if(!rechteck[startpunkt.gibX()][startpunkt.gibY()].equals(neueFarbe)) {
            rechteck[startpunkt.gibX()][startpunkt.gibY()] = neueFarbe;
            setzeNachbarn(startpunkt, pixelListe);
            
            //Ersten Punkt merken
            Listenknoten aktuellerPixel = pixelListe.gibKopf();
            
            while(aktuellerPixel != null) {
                
                java.awt.Color farbe1 = rechteck[aktuellerPixel.gibInhalt().gibX()][aktuellerPixel.gibInhalt().gibY()];
                        //gibFarbe(aktuellerPixel.gibInhalt().gibX(), aktuellerPixel.gibInhalt().gibY());
                
                
                boolean bla = farbe1.equals(anfangsFarbe);
                
                if(bla) {
                    rechteck[aktuellerPixel.gibInhalt().gibX()][aktuellerPixel.gibInhalt().gibY()] = neueFarbe;
                    setzeNachbarn(aktuellerPixel.gibInhalt(), pixelListe);
                }
                
                //Liste durchlaufen
                aktuellerPixel = aktuellerPixel.gibNachfolger();
            }
        }
            
        
    }
    
    public void setzeNachbarn(Punkt startpunkt, Liste pixelListe) {
        
        int xKoordinate = startpunkt.gibX();
        int yKoordinate = startpunkt.gibY();
        
        if(startpunkt.gibX() != 0){
            pixelListe.fuegeHintenHinzu(new Punkt(xKoordinate - 1, yKoordinate));
        }
        if(startpunkt.gibY() != 0){
            pixelListe.fuegeHintenHinzu(new Punkt(xKoordinate, yKoordinate - 1));
        }
        if(startpunkt.gibX() != breite - 1){
            pixelListe.fuegeHintenHinzu(new Punkt(xKoordinate + 1, yKoordinate));
        }
        if(startpunkt.gibY() != hoehe - 1){
            pixelListe.fuegeHintenHinzu(new Punkt(xKoordinate, yKoordinate + 1));
        }
    }
}
