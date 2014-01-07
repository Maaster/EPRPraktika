
/**
 * Startet die Anwendung der Klasse UIFarben.
 */
public class Start {

    /**
     * Startet die Anwendung der Klasse UIFarben.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {

        Farbwert farbwert = new Farbwert(255255255);
        UIFarben anwendung = new UIFarben(farbwert);
        farbwert.addPropertyChangeListener(anwendung);

        anwendung.setSize(400, 300);
        anwendung.setVisible(true);
    }
}
