package test2;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Ein Objekt dieser Klasse repräsentiert die Oberfläche für
 * das Schlange-Spiel.
 */
public class UISchlangeSpiel extends JFrame
        implements PropertyChangeListener {

    /**
     * Horizontale Größe des Anwendungsfensters.
     */
    private static final int FENSTERGROESSE_X = 294;

    /**
     * Vertikale Größe des Anwendungsfensters.
     */
    private static final int FENSTERGROESSE_Y = 326;

    /**
     * Modell des Schlange-Spiels.
     */
    private SchlangeSpiel spiel;

    /**
     * Darstellung des Spielfelds.
     */
    private Spielfeld spielfeld;

    /**
     * Erzeugt die Oberfläche für das Schlange-Spiel für das
     * übergebene Modell des Spiels.
     *
     * @param spiel  Modell des Spiels
     */
    public UISchlangeSpiel(SchlangeSpiel spiel) {

        super("Schlange");

        this.spiel = spiel;

        /* Erzeugt die Komponenten dieses Frame.
         */
        erzeugeKomponenten();

        /* Anwendung beenden beim Schließen dieses Frame.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Erzeugt die Komponenten dieses Frame.
     */
    private void erzeugeKomponenten() {

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 1));

        this.setFocusable(true);

        /* Behandlung der Tastaturereignisse zur Steuerung der
         * Bewegungsrichtung.
         */
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    spiel.nachRechts();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    spiel.nachLinks();
                }
            }
        });

        /*
         * Objekt zur Darstellung des Spielfelds erzeugen und dem
         * Container diesen Frame hinzufügen.
         * Das Spielfeld erhält keinen Fokus, da die Tastaturereignisse
         * von diesem Frame selbst behandelt werden.
         */
        spielfeld = new Spielfeld(spiel);
        spielfeld.setFocusable(false);
        container.add(spielfeld);
    }

    /**
     * Aktualisiert die Darstellung.
     *
     * @param propertyChangeEvent  Ereignis, von dem abhängig die
     *        Darstellung aktualisiert wird
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        if (Spieltaktung.KOLLISION.equals(
                propertyChangeEvent.getPropertyName())) {

            JOptionPane.showMessageDialog(this,
                                          "Kollision: Das Spiel ist aus.");
            System.exit(0);

        } else if (Spieltaktung.VORWAERTS.equals(
                propertyChangeEvent.getPropertyName())) {

            spielfeld.repaint();
        }
    }

    /**
     * Start der Anwendung.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        SchlangeSpiel spiel = new SchlangeSpiel(10, 10);
        Spieltaktung taktung = new Spieltaktung(spiel);
        UISchlangeSpiel fenster = new UISchlangeSpiel(spiel);

        taktung.addPropertyChangeListener(fenster);

        fenster.setSize(FENSTERGROESSE_X, FENSTERGROESSE_Y);
        fenster.setResizable(false);
        fenster.setVisible(true);

        new Thread(taktung).start();
    }
}
