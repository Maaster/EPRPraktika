/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;


/**
 * Ein Objekt dieser Klasse repräsentiert eine einfach
 * verkettete Liste von Zeichenketten.
 */
public class Liste {

    /**
     * Erster Knoten in der Liste der verketteten Knoten.
     */
    private Listenknoten listenkopf;

    /**
     * Letzter Knoten in der Liste der verketteten Knoten.
     */
    private Listenknoten listenende;

    /**
     * Länge dieser Liste.
     */
    private int listenlaenge;

    /**
     * Erzeugt eine leere Liste.
     */
    public Liste() {

        this.listenkopf = null;
        this.listenende = null;
        this.listenlaenge = 0;
    }

    /**
     * Fügt eine Zeichenkette vorne in dieser Liste hinzu.
     *
     * @param inhalt  Zeichenkette, die vorne hinzugefügt wird
     */
    public void fuegeVorneHinzu(Punkt inhalt) {

        this.listenkopf = new Listenknoten(inhalt, this.listenkopf);

        if (this.listenende == null) {

            /* Die Liste war leer. Neuer Knoten wird auch Listenende.
             */
            this.listenende = this.listenkopf;
        }

        this.listenlaenge = this.listenlaenge + 1;
    }
    
    public Listenknoten gibKopf() {
        return this.listenkopf;
    }

    /**
     * Fügt eine Zeichenkette hinten in dieser Liste hinzu.
     *
     * @param inhalt  Zeichenkette, die hinten hinzugefügt wird
     */
    public void fuegeHintenHinzu(Punkt inhalt) {

        if (this.listenkopf == null) {

            /* Die Liste ist leer. Neuer Knoten wird Listenkopf und Listenende.
             */
            this.listenkopf = new Listenknoten(inhalt);
            this.listenende = this.listenkopf;

        } else {

            /* Die Liste ist nicht leer. Neuer Knoten wird Listenende.
             * Listenkopf bleibt unverändert.
             */
            Listenknoten knoten = new Listenknoten(inhalt);
            this.listenende.setzeNachfolger(knoten);
            this.listenende = knoten;
        }

        this.listenlaenge = this.listenlaenge + 1;
    }

    /**
     * Fügt eine Zeichenkette an der angegebenen Position
     * in diese Liste ein.
     *
     * @param position  Position, an der die Zeichenkette eingefügt
     *        wird. Wenn position == 0, wird vorne eingefügt.
     *        Wenn position == 1, wird an zweiter Stelle eingefügt usw.
     * @param inhalt  Zeichenkette, die hinzugefügt wird
     */
    public void fuegeHinzu(int position, Punkt inhalt) {

        if (position == 0) {
            fuegeVorneHinzu(inhalt);
        } else if (position == this.listenlaenge) {
            fuegeHintenHinzu(inhalt);
        } else if ((position > 0) && (position < this.listenlaenge)) {

            Listenknoten knoten = new Listenknoten(inhalt);

            /* Der neue Knoten muss hinter dem Knoten an Position position - 1
             * eingefügt werden. Deshalb die Liste durchlaufen, bis Variable
             * k den Knoten an dieser Position enthält.
             */
            Listenknoten vorgaenger = this.listenkopf;
            for (int i = 1; i < position; i = i + 1) {
                vorgaenger = vorgaenger.gibNachfolger();
            }

            /* Neuen Knoten als Nachfolger des Knotens an Position
             * position - 1 (Wert der Variablen vorgaenger) einfügen.
             */
            knoten.setzeNachfolger(vorgaenger.gibNachfolger());
            vorgaenger.setzeNachfolger(knoten);

            this.listenlaenge = this.listenlaenge + 1;
        }
    }

    /**
     * Fügt eine Zeichenkette an der angegebenen Position
     * in diese Liste ein.
     *
     * Der Name dieser Methode ist schlecht gewählt. Es interessiert
     * einen Aufrufer nicht, ob beim Hinzufügen die Listenlänge
     * ausgewertet wird oder nicht. Hier wird dieser Name gewählt,
     * um diese Methode von der Methode fuegeHinzu unterscheidbar
     * zu machen. In der Praxis entscheidet man sich für eine
     * Realisierungsart.
     *
     * @param position  Position, an der die Zeichenkette eingefügt
     *        wird. Wenn position == 0, wird vorne eingefügt.
     *        Wenn position == 1, wird an zweiter Stelle eingefügt usw.
     *        Es wird davon ausgegangen, dass die position nicht
     *        negativ ist.
     * @param inhalt  Zeichenkette, die hinzugefügt wird
     */
    public void fuegeHinzuOhneListenlaenge(int position, Punkt inhalt) {

        if (position == 0) {

            /* Knoten wird vorne hinzugefügt.
             */
            this.listenkopf = new Listenknoten(inhalt, this.listenkopf);

            if (this.listenende == null) {

                /* Die Liste war leer. Neuer Knoten wird auch Listenende.
                 */
                this.listenende = this.listenkopf;
            }

            this.listenlaenge = this.listenlaenge + 1;

        } else {

            /* Knoten soll nicht vorne hinzugefügt werden.
             */

            /* Zähler zur Ermittlung der Einfügeposition.
             */
            int positionszaehler = 1;

            /* Knoten, hinter dem der neue Knoten eingefügt werden soll.
             */
            Listenknoten vorgaenger = this.listenkopf;

            /* Denjenigen Knoten k suchen, hinter dem der neue Knoten
             * eingefügt werden muss.
             */
            while ((positionszaehler < position) && (vorgaenger != null)) {
                positionszaehler = positionszaehler + 1;
                vorgaenger = vorgaenger.gibNachfolger();
            }

            /* Falls vorgaenger == null, so ist die Einfügeposition
             * für diese Liste ungültig.
             */

            if (vorgaenger != null) {

                /* vorgaenger enthält den Knoten, hinter dem der neue Knoten
                 * eingefügt werden muss.
                 */
                Listenknoten knoten =
                        new Listenknoten(inhalt, vorgaenger.gibNachfolger());
                vorgaenger.setzeNachfolger(knoten);
                this.listenlaenge = this.listenlaenge + 1;

                /* Ist der neue Knoten der letzte der Liste, muss das
                 * Listenende gesetzt werden.
                 */
                if (knoten.gibNachfolger() == null) {
                    this.listenende = knoten;
                }
            }
        }
    }

    /**
     * Entfernt die Zeichenkette an der angegebenen Position aus
     * dieser Liste.
     *
     * @param index  Index der Zeichenkette, die entfernt werden soll
     */
    public void entferne(int index) {

        if ((index >= 0) && (index < this.listenlaenge)) {

            if (index == 0) {

                /* Die Liste ist nicht leer und es soll der erste Knoten
                 * entfernt werden.
                 */
                this.listenkopf = this.listenkopf.gibNachfolger();

                /* Enthielt die Liste zuvor nur einen Knoten, so ist
                 * anschließend auch das Listenende die null-Referenz.
                 */
                if (this.listenkopf == null) {
                    this.listenende = null;
                }

                this.listenlaenge = this.listenlaenge - 1;

            } else {

                /* Die Liste ist nicht leer und es wird ein mittlerer
                 * oder der letzte Knoten entfernt.
                 */

                /* Durch die Liste laufen, sodass anschließend aktuellerKnoten
                 * den Knoten enthält, der entfernt werden soll, und
                 * vorherigerKnoten seinen Vorgänger.
                 */
                Listenknoten aktuellerKnoten = this.listenkopf;
                Listenknoten vorherigerKnoten = null;
                for (int i = 1; i <= index; i = i + 1) {
                    vorherigerKnoten = aktuellerKnoten;
                    aktuellerKnoten = aktuellerKnoten.gibNachfolger();
                }

                /* Der Knoten wird entfernt, indem sein Nachfolger zum
                 * Nachfolger des Vorgängers wird.
                 */
                vorherigerKnoten.setzeNachfolger(
                        aktuellerKnoten.gibNachfolger());

                /* Wurde der letzte Knoten entfernt, muss das Listenende
                 * aktualisiert werden.
                 */
                if (vorherigerKnoten.gibNachfolger() == null) {
                    this.listenende = vorherigerKnoten;
                }

                this.listenlaenge = this.listenlaenge - 1;
            }
        }
    }

    /**
     * Verkettet die übergebene Liste mit dieser Liste. Es wird keine
     * Kopie der übergebenen Liste erstellt.
     *
     * @param liste  Liste, die mit dieser Liste verkettet werden soll
     */
    public void verkette(Liste liste) {

        if (this.listenkopf == null) {

            /* Diese Liste ist leer. Der Kopf der anzuhängenden Liste wird
             * Kopf der verketteten Liste.
             */
            this.listenkopf = liste.listenkopf;

        } else {

            /* Diese Liste ist nicht leer. Der Kopf der anzuhängenden Liste wird
             * an das Ende dieser Liste angefügt.
             */
            this.listenende.setzeNachfolger(liste.listenkopf);
        }

        /* Listenende der anzuhängenden Liste wird zum Listenende dieser
         * Liste, wenn die anzuhängende Liste nicht leer ist.
         */
        if (liste.listenkopf != null) {
            this.listenende = liste.listenende;
        }

        /* Längen der Listen addieren sich.
         */
        this.listenlaenge = this.listenlaenge + liste.listenlaenge;
    }

    /**
     * Liefert die Zeichenkette an der angegebenen Position in der Liste.
     * Ist der Index ungültig, wird null zurückgegeben.
     *
     * @param index  Index der Zeichenkette
     * @return Zeichenkette an der angegebenen Position
     */
    public Punkt gibInhalt(int index) {

        Punkt inhalt;

        if ((index < 0) || (index >= this.listenlaenge)) {
            // Fehlerfall: muss geeignet behandelt werden
            inhalt = null;
        } else {

            /* Solange die Liste durchlaufen, bis k den angegebenen
             * Listenknoten enthält.
             */
            Listenknoten k = this.listenkopf;
            for (int i = 1; i <= index; i++) {
                k = k.gibNachfolger();
            }
            inhalt = k.gibInhalt();
        }

        return inhalt;
    }

    /**
     * Liefert die Länge dieser Liste.
     *
     * @return Länge der Liste
     */
    public int gibLaenge() {

        return this.listenlaenge;
    }
  
}
