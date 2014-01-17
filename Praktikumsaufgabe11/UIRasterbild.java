package test2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Ein Objekt dieser Klasse repräsentiert die Oberfläche des Programms
 * zur Darstellung und Bearbeitung von Pixelgrafiken.
 */
public class UIRasterbild extends JFrame implements ActionListener {

    /** Datei-Menü. */
    private static final String MENUE_DATEI = "Datei";

    /** Menüpunkt zum Öffnen einer Datei. */
    private static final String MENUE_DATEI_OEFFNEN = "Datei öffnen ...";

    /** Menüpunkt zum Schließen der Anwendung. */
    private static final String MENUE_BEENDEN = "Beenden";

    /** Farb-Menü. */
    private static final String MENUE_FARBE = "Farbe";

    /** Menüpunkt zum Auswählen einer Farbe. */
    private static final String MENUE_FARBE_WAEHLEN = "Farbe wählen ...";

    /**
     * Horizontale Größe des Anwendungsfensters.
     */
    private static final int FENSTERGROESSE_X = 600;

    /**
     * Vertikale Größe des Anwendungsfensters.
     */
    private static final int FENSTERGROESSE_Y = 400;

    /**
     * Dargestelltes Rasterbild.
     */
    private Rasterbild bild;

    /**
     * Komponente zur Darstellung des Bilds.
     */
    private Bilddarstellung darstellung;

    /**
     * Verzeichnis, aus dem zuletzt eine Bilddatei ausgewählt wurde.
     */
    private File letztesVerzeichnis;

    /**
     * Erzeugt die Oberfläche zur Bilddarstellung. Es ist anfangs
     * noch kein Rasterbild zur Darstellung ausgewählt.
     */
    public UIRasterbild() {

        super("Bilddarstellung und -bearbeitung");

        this.bild = null;
        this.letztesVerzeichnis = null;

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

        /*
         * Objekt zur Darstellung des Bilds erzeugen und dem
         * Container diesen Frame hinzufügen.
         */
        darstellung = new Bilddarstellung();

        JScrollPane scrollPane = new JScrollPane(darstellung);
        container.add(scrollPane);

        /* Menü aufbauen.
         */

        JMenuBar menue = new JMenuBar();
        JMenu dateiMenue = new JMenu(MENUE_DATEI);
        menue.add(dateiMenue);

        JMenuItem menuepunkt = new JMenuItem(MENUE_DATEI_OEFFNEN, 'D');
        menuepunkt.addActionListener(this);
        dateiMenue.add(menuepunkt);

        menuepunkt = new JMenuItem(MENUE_BEENDEN, 'B');
        menuepunkt.addActionListener(this);
        dateiMenue.add(menuepunkt);

        JMenu farbMenue = new JMenu(MENUE_FARBE);
        menue.add(farbMenue);

        menuepunkt = new JMenuItem(MENUE_FARBE_WAEHLEN, 'F');
        menuepunkt.addActionListener(this);
        farbMenue.add(menuepunkt);

        this.setJMenuBar(menue);
    }

    /**
     * Lädt die übergebene Datei und liefert das zweidimensionale Feld
     * der farbigen Bildpunkte.
     *
     * @param datei  Datei, die geladen wird
     * @return Feld der farbigen Bildpunkte
     */
    private static Color[][] ladeGrafikdatei(File datei) {

        BufferedImage image;
        Color[][] bildpunkte = null;
        try {
            image = ImageIO.read(datei);
            bildpunkte = new Color[image.getWidth()][image.getHeight()];
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    bildpunkte[x][y] = new Color(image.getRGB(x, y));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bildpunkte;
    }

    /**
     * Verarbeitet das übergebene Ereignis.
     *
     * @param event  Ereignis, das verarbeitet wird
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals(MENUE_DATEI_OEFFNEN)) {

            JFileChooser dateiauswahl = new JFileChooser(letztesVerzeichnis);
            FileFilter filter = new FileNameExtensionFilter(
                    "Bilddateien", "gif", "jpg", "jpeg");
            dateiauswahl.setFileFilter(filter);

            if (dateiauswahl.showOpenDialog(this)
                    == JFileChooser.APPROVE_OPTION) {

                Color[][] bildpunkte =
                        ladeGrafikdatei(dateiauswahl.getSelectedFile());
                letztesVerzeichnis = dateiauswahl.getCurrentDirectory();
                bild = new Rasterbild(bildpunkte);
                darstellung.setzeBild(bild);
                darstellung.repaint();
            }

        } else if ("Beenden".equals(event.getActionCommand())) {

            System.exit(0);

        } else if (event.getActionCommand().equals(MENUE_FARBE_WAEHLEN)) {

            Color farbe = JColorChooser.showDialog(
                    this, MENUE_FARBE_WAEHLEN, Color.BLACK);
            darstellung.setzeFarbe(farbe);

        }
    }

    /**
     * Erzeugt ein "Testbild".
     * @return Testbild
     */
    private static Rasterbild erzeugeTestbild() {

        Color[][] bildpunkte = new Color[15][12];
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 12; y++) {
                bildpunkte[x][y] = Color.WHITE;
            }
        }

        bildpunkte[ 4][ 3] = Color.BLACK;
        bildpunkte[ 5][ 3] = Color.BLACK;
        bildpunkte[ 6][ 3] = Color.GREEN;
        bildpunkte[ 6][ 4] = Color.GRAY;
        bildpunkte[ 7][ 5] = Color.RED;
        bildpunkte[ 8][ 6] = Color.ORANGE;
        bildpunkte[ 9][ 6] = Color.MAGENTA;
        bildpunkte[10][ 5] = Color.GRAY;
        bildpunkte[ 9][ 4] = Color.PINK;
        bildpunkte[ 9][ 3] = Color.BLUE;
        bildpunkte[10][ 3] = Color.PINK;
        bildpunkte[11][ 3] = Color.DARK_GRAY;
        bildpunkte[12][ 3] = Color.LIGHT_GRAY;
        bildpunkte[13][ 3] = Color.ORANGE;
        bildpunkte[13][ 4] = Color.YELLOW;
        bildpunkte[13][ 5] = Color.BLACK;
        bildpunkte[12][ 6] = Color.RED;
        bildpunkte[11][ 7] = Color.YELLOW;
        bildpunkte[10][ 8] = Color.BLUE;
        bildpunkte[ 9][ 8] = Color.GREEN;
        bildpunkte[ 8][ 9] = Color.GREEN;
        bildpunkte[ 7][ 8] = Color.GRAY;
        bildpunkte[ 6][ 8] = Color.YELLOW;
        bildpunkte[ 5][ 7] = Color.RED;
        bildpunkte[ 4][ 6] = Color.BLACK;
        bildpunkte[ 3][ 5] = Color.RED;
        bildpunkte[ 3][ 4] = Color.GREEN;

        return new Rasterbild(bildpunkte);
    }

    /**
     * Start der Anwendung.
     *
     * @param args  wird nicht verwendet
     */
    public static void main(String[] args) {

        UIRasterbild fenster = new UIRasterbild();
        fenster.darstellung.setzeBild(erzeugeTestbild());

        fenster.setSize(FENSTERGROESSE_X, FENSTERGROESSE_Y);
        fenster.setResizable(true);
        fenster.setVisible(true);
    }
}
