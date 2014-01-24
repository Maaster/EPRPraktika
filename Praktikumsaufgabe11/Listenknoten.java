/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;


/**
 * Ein Listenknoten repräsentiert einen Knoten einer einfach verketteten
 * Liste. Ein Knoten enthält einen Inhalt und einen Nachfolgeknoten.
 */
public class Listenknoten {

    /**
     * Inhalt dieses Knotens.
     */
    private Punkt inhalt;

    /**
     * Nachfolgender Listenknoten.
     */
    private Listenknoten nachfolger;

    /**
     * Erzeugt einen neuen Listenknoten mit der übergebenen
     * Zeichenkette als Inhalt.
     *
     * @param inhalt  Inhalt dieses Listenknotens
     */
    public Listenknoten(Punkt inhalt) {

        this.inhalt = inhalt;
        this.nachfolger = null;
    }

    /**
     * Erzeugt einen neuen Listenknoten mit der übergebenen
     * Zeichenkette als Inhalt und dem übergebenen Knoten
     * als Nachfolger.
     *
     * @param inhalt  Inhalt dieses Listenknotens
     * @param nachfolger  Nachfolger dieses Listenknotens
     */
    public Listenknoten(Punkt inhalt, Listenknoten nachfolger) {

        this.inhalt = inhalt;
        this.nachfolger = nachfolger;
    }

    /**
     * Liefert den Inhalt dieses Listenknotens.
     *
     * @return Inhalt dieses Listenknotens
     */
    public Punkt gibInhalt() {

        return this.inhalt;
    }

    /**
     * Liefert den nachfolgenden Listenknoten.
     *
     * @return nachfolgender Listenknoten
     */
    public Listenknoten gibNachfolger() {

        return this.nachfolger;
    }

    /**
     * Weist diesem Listenknoten einen neuen Nachfolger zu.
     *
     * @param knoten  Nachfolger dieses Listenknotens
     */
    public void setzeNachfolger(Listenknoten knoten) {

        this.nachfolger = knoten;
    }
}
