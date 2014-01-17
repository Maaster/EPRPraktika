/**
* Der Spieleklassiker Snake
* @author Maaster
*/
public class Schlange {

    /*
    * 0°ist oben, 90°nach rechts, 180° nach unten, 270° nach links
    */
    private int bewegungsRichtung;

    private Punkt[] schlangenPos;

    /**
    * Konstruktor der Schlange
    * @param horizontal x-Pos des Kopfes
    * @param vertikal y-Pos des Kopfes
    */
    public Schlange(int horizontal, int vertikal) {
        bewegungsRichtung = 90;
        schlangenPos = new Punkt[1];
        schlangenPos[0] = new Punkt(horizontal, vertikal);
    }

    /**
    * Ändert die Bewegungsrichtung um 90°im Uhrzeigersinn
    */
    public void geheNachRechts() {
        bewegungsRichtung = (bewegungsRichtung + 90) % 360;
    }

    /**
    * Ändert die Bewegungsrichtung um 90°gegen den Uhrzeigersinn
    */
    public void geheNachLinks() {
        bewegungsRichtung = (bewegungsRichtung + 270) % 360;
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

        switch(bewegungsRichtung)
        {
            case 0:
                if(futterPos.istGleich(new Punkt(schlangenPos[0].gibX(),
                            schlangenPos[0].gibY() - 1))) {
                    schlangeVerlaengern(new Punkt(0, -1));
                }
                else {
                    for (int i = 0; i < schlangenPos.length - 1; i = i + 1) {
                    if(schlangenPos[i].istGleich(
                            new Punkt(schlangenPos[0].gibX(),
                            schlangenPos[0].gibY() - 1))) {
                        kannZiehen = false;
                    }
                }
                    schlangeBewegen(new Punkt(0, -1));
                }
                break;

            case 90:
                if(futterPos.istGleich(new Punkt(schlangenPos[0].gibX() + 1,
                        schlangenPos[0].gibY()))) {
                    schlangeVerlaengern(new Punkt(1,0));
                }
                else {
                    for (int i = 0; i < schlangenPos.length - 1; i = i + 1) {
                    if(schlangenPos[i].istGleich(
                            new Punkt(schlangenPos[0].gibX() + 1,
                            schlangenPos[0].gibY()))) {
                        kannZiehen = false;
                    }
                }
                    schlangeBewegen(new Punkt(1, 0));
                }
                break;

            case 180:
                if(futterPos.istGleich(new Punkt(schlangenPos[0].gibX(),
                        schlangenPos[0].gibY() + 1))) {
                    schlangeVerlaengern(new Punkt(0, 1));
                }
                else {
                    for (int i = 0; i < schlangenPos.length - 1; i = i + 1) {
                    if(schlangenPos[i].istGleich(
                            new Punkt(schlangenPos[0].gibX(),
                            schlangenPos[0].gibY() + 1))) {
                        kannZiehen = false;
                    }
                }
                    schlangeBewegen(new Punkt(0, 1));
                }
                break;

            case 270:
                if(futterPos.istGleich(
                        new Punkt(schlangenPos[0].gibX() - 1,
                        schlangenPos[0].gibY()))) {
                    schlangeVerlaengern(new Punkt(-1,0));
                }
                else {
                    for (int i = 0; i < schlangenPos.length - 1; i = i + 1) {
                    if(schlangenPos[i].istGleich(
                            new Punkt(schlangenPos[0].gibX() - 1,
                            schlangenPos[0].gibY()))) {
                        kannZiehen = false;
                    }
                }
                    schlangeBewegen(new Punkt(-1,0));
                }
                break;
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

        for(int i = 0; i < schlangenPos.length && !enthaeltSchlange; i++)
        {
            if(position.istGleich(schlangenPos[i])) {
                enthaeltSchlange = true;
            }
        }
        return enthaeltSchlange;
    }
}
