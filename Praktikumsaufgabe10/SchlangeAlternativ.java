package test2;

/**
 * Der Spieleklassiker Snake
 * @author Maaster
 */
public class Schlange {
    
    private Punkt[] bewegungsRichtung;
    
    /*
     * 0°ist oben, 1 nach rechts, 2 nach unten, 3 nach links
     */
    private int richtung;
    
    private Punkt[] schlangenPos;
    
    /**
     * Konstruktor der Schlange
     * @param horizontal x-Pos des Kopfes
     * @param vertikal y-Pos des Kopfes
     */
    public Schlange(int horizontal, int vertikal) {
        bewegungsRichtung = new Punkt[4];
        richtung = 1;
        
        bewegungsRichtung[0] = new Punkt(0,-1);
        bewegungsRichtung[1] = new Punkt(1,0);
        bewegungsRichtung[2] = new Punkt(0,1);
        bewegungsRichtung[3] = new Punkt(-1,0);
        
        schlangenPos = new Punkt[1];
        schlangenPos[0] = new Punkt(horizontal, vertikal);
    }
    
    /**
     * Ändert die Bewegungsrichtung um 90°im Uhrzeigersinn
     */
    public void geheNachRechts() {
        richtung = (richtung + 1) % 4;
    }
    
    /**
     * Ändert die Bewegungsrichtung um 90°gegen den Uhrzeigersinn
     */
    public void geheNachLinks() {
        richtung = (richtung + 3) % 4;
    }
    
    /**
     * Überprüft, ob die Bewegung gültig ist und reagiert bei
     * Futter-Berührung entsprechend durch verlängern der Schlange
     * @param futterPos Position des Futters
     * @return true genau dann, wenn die Schlange nicht auf ihre eigenen 
     *          Segmente trifft bei bzw. nach der Bewegung
     */
    public boolean geheVoran(Punkt futterPos) {
        
        
        boolean kannZiehen = true;
        Punkt neuerKopf = schlangenPos[0].addiere(bewegungsRichtung[richtung]);
        
        if(futterPos.istGleich(neuerKopf)) {
            schlangeVerlaengern(bewegungsRichtung[richtung]);
        }
        else {
            for (int i = 0; i < schlangenPos.length - 1; i = i + 1) {
            if(schlangenPos[i].istGleich(neuerKopf)) {
                kannZiehen = false;
            }
        }
            schlangeBewegen(bewegungsRichtung[richtung]);
        }
        
        return kannZiehen;
    }
    
    /**
     * Bewegt die Schlange
     * @param richtung Richtung der Bewegung
     */
    public void schlangeBewegen(Punkt richtung) {
        Punkt[] neueSchlange = new Punkt[schlangenPos.length];
        for (int i = 0; i < schlangenPos.length - 1; i++) {
            neueSchlange[i + 1] = schlangenPos[i];
        }
        neueSchlange[0] = schlangenPos[0].addiere(richtung);
        this.schlangenPos = neueSchlange;
    }
    
    /**
     * Bewegt und verlängert die Schlange
     * @param richtung Richtung der Bewegung
     */
    public void schlangeVerlaengern(Punkt richtung) {
        
        Punkt[] neueSchlange = new Punkt[schlangenPos.length + 1];
        for (int i = 0; i < schlangenPos.length; i++) {
            neueSchlange[i + 1] = schlangenPos[i];
        }
        neueSchlange[0] = schlangenPos[0].addiere(richtung);
        this.schlangenPos = neueSchlange;
    }
    
    /**
     * Gibt die Länge der Schlange wieder
     * @return Länge der Schlange
     */
    public int gibLaenge() {
        return schlangenPos.length;
    }
    
    /**
     * Gibt das geforderte Segment zurück
     * @param segmentIndex Index des geforderten Segments
     * @return Das geforderte Segment
     */
    public Punkt gibSegment(int segmentIndex) {
        return schlangenPos[segmentIndex];
    }
    
    /**
     * Prüft,  ob auf der angegebenen Position ein Segment der Schlange
     * liegt
     * @param position Position, die zu prüfen ist
     * @return genau dann true, wenn auf der Position ein Schlangesegment ist
     */
    public boolean enthaeltPunkt(Punkt position) {
        boolean enthaeltSchlange = false;
        
        for(Punkt segment : schlangenPos) {
            if(position.istGleich(segment)) {
                enthaeltSchlange = true;
            }
        }
        
        return enthaeltSchlange;
    }
}
