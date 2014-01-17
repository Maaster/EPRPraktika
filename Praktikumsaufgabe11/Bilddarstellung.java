package test2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Ein Objekt dieser Klasse repräsentiert die Darstellung
 * eines Bilds bestehend aus einzelnen Bildpunkten. Ein
 * Objekt dieser Klasse verarbeitet ein Mausereignis, durch
 * das Teile des Bilds in eine neue Farbe umgefärbt werden
 * können.
 */
public class Bilddarstellung extends JPanel {

    /**
     * Meldung, wenn keine Farbe ausgewählt ist.
     */
    private static final String MELDUNG_FARBAUSWAHL =
            "Es ist keine Farbe zum Umfärben einer Fläche ausgewählt.";

    /**
     * Größe, in der ein Bildpunkt dargestellt wird.
     */
    private static int punktgroesse = 4;

    /**
     * Abstand zwischen der Darstellung benachbarter Bildpunkte. Ist der
     * Abstand größer als 0, sind die einzelnen Bildpunkte klarer voneinander
     * unterscheidbarer.
     */
    private static int punktabstand = 1;

    /**
     * Rastermass für die Darstellung der Bildpunkte.
     */
    private static int rastermass = punktgroesse + punktabstand;

    /**
     * Rasterbild, das dargestellt wird.
     */
    private Rasterbild bild;

    /**
     * Farbe, in die Teile des dargestellten Bilds umgefärbt werden
     * können.
     */
    private Color farbe;

    /**
     * Erzeugt ein Objekt dieser Klasse. Dem Objekt ist anfangs
     * kein Rasterbild zugeordnet.
     */
    public Bilddarstellung() {

        /* Anfangs kein Rasterbild und keine Farbe zum Umfärben
         */
        this.bild = null;
        this.farbe = null;

        /* Listener registrieren, mit dessen Hilfe eine Fläche des Bilds
         * ausgehend vom angeklickten Bildpunkt umgefärbt werden kann.
         */
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (bild != null) {
                    if (farbe == null) {
                        JOptionPane.showMessageDialog(Bilddarstellung.this,
                                MELDUNG_FARBAUSWAHL);
                    } else {
                        /* Bildpunkt bestimmen.
                         */
                        int x = e.getX() / rastermass;
                        int y = e.getY() / rastermass;
                        bild.fuelleFlaeche(new Punkt(x, y), farbe);
                        repaint();
                    }
                }
            }
        });
    }

    /**
     * Setze Rasterbild, das dargestellt wird.
     *
     * @param bild  Rasterbild, das dargestellt wird
     */
    public void setzeBild(Rasterbild bild) {

        this.bild = bild;
    }

    /**
     * Setze Farbe, in die Teile des Bilds umgefärbt werden.
     *
     * @param farbe  neue Farbe
     */
    public void setzeFarbe(Color farbe) {

        this.farbe = farbe;
    }

    /**
     * Liefert bevorzugte Größe dieser Bilddarstellung.
     * @return bevorzugte Größe basierend auf Rastermass und
     *         Anzahl horizontaler und vertikaler Bildpunkte
     */
    @Override
    public Dimension getPreferredSize() {

        return (bild == null)
                ? new Dimension(0, 0)
                : new Dimension(rastermass * bild.gibBreite(),
                                rastermass * bild.gibHoehe());
    }

    /**
     * Zeichnet die Bilddarstellung in die angegebene Grafikumgebung.
     *
     * @param graphics  Grafikumgebung, in die gezeichnet wird
     */
    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        if (bild != null) {
            for (int x = 0; x < bild.gibBreite(); x++) {
                for (int y = 0; y < bild.gibHoehe(); y++) {
                    graphics.setColor(bild.gibFarbe(x, y));
                    graphics.fillRect(x * rastermass, y * rastermass,
                                      punktgroesse, punktgroesse);
                }
            }
        }
    }
}
