package test2;

/**
 *
 * @author Maaster
 */
public class Rasterbild {
    
    private java.awt.Color[][] rechteck;
    private int breite;
    private int hoehe;
    
    public Rasterbild(java.awt.Color[][] rechteck) {
        this.rechteck = rechteck;
        breite = rechteck.length;
        hoehe = rechteck[0].length;
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
        if(rechteck[startpunkt.gibX()][startpunkt.gibY()].equals
                (java.awt.Color.WHITE) && (startpunkt.gibX() < breite  &&
                                            startpunkt.gibY() < hoehe)
                && !rechteck[startpunkt.gibX()][startpunkt.gibY()].equals
                (neueFarbe)) {
            
            rechteck[startpunkt.gibX()][startpunkt.gibY()] = neueFarbe;
            fuelleFlaeche(new Punkt(startpunkt.gibX() + 1, startpunkt.gibY()),
                    neueFarbe);
            fuelleFlaeche(new Punkt(startpunkt.gibX() - 1, startpunkt.gibY()),
                    neueFarbe);
            fuelleFlaeche(new Punkt(startpunkt.gibX(), startpunkt.gibY() + 1),
                    neueFarbe);
            fuelleFlaeche(new Punkt(startpunkt.gibX(), startpunkt.gibY() - 1),
                    neueFarbe);
        }
    }
    
}
