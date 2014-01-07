/**
    * Diese Klasse kann einzelne Wörter aus einem Text ausgeben.
    * @author maaster
    */
public class Texttrenner {

    private String zeichenkette;
    private String trenner;

    /**
        * Konstruktor für den Texttrenner
        * @param zeichenkette Zeichenkette, die zu trennende Wörter enthält
        * @param trennzeichen Trennzeichen, womit die Wörter unterteilt sind
        */
    public Texttrenner(String zeichenkette, String trennzeichen) {
        this.zeichenkette = zeichenkette;
        trenner = trennzeichen;
    }

    /**
        * Prüft, ob in der Zeichenkette noch Wörter zu finden sind
        * @return Liefert genau dann true, wenn mind. ein Buchstabens oder
        *          eine Ziffer in der Zeichenkette vorhanden ist
        */
    public boolean hatNochWoerter() {

        boolean wortGefunden = false;

        //Zeichenkette durchlaufen
        for(int i = 0; i < zeichenkette.length(); i++) {

            //Falls Buchstabe gefunden (bzw. kein Trennzeichen)
            if(trenner.indexOf(zeichenkette.charAt(i)) == -1)
                wortGefunden = true;
        }

        return wortGefunden;

    }

    /**
        * Liefert das nächste Wort in der Zeichenkette, falls eines vorhanden ist
        * @return Das nächste Wort in der Zeichenkette. Falls keines vorhanden ist,
        * liefert es null.
        */
    public String gibNaechstesWort() {

        String auszugebenesWort = null;

        //Zeichenkette durchlaufen
        for(int i = 0; i < zeichenkette.length(); i++) {

            //Falls Buchstabe gefunden (bzw. kein Trennzeichen)
            if(trenner.indexOf(zeichenkette.charAt(i)) == -1) {

                //Rest der Zeichenkette durchlaufen ab gefundenem Buchstaben
                for(int j = i; j < zeichenkette.length(); j++) {

                    //Falls Trenner gefunden
                    if(trenner.indexOf(zeichenkette.charAt(j)) != -1) {

                        //Einzelnes Wort speichern
                        auszugebenesWort = zeichenkette.substring(i, j);

                        //Zeichenkette kürzen und Wort ausgeben
                        zeichenkette = zeichenkette.substring(j,
                                                    zeichenkette.length());
                        //Schleife beenden, da Wort gefunden
                        j = zeichenkette.length();
                        i = zeichenkette.length();
                    }
                }

                if(auszugebenesWort == null) {

                //Zeichenkette kürzen und Wort ausgeben
                auszugebenesWort = zeichenkette.substring(i, zeichenkette.length());
                zeichenkette = zeichenkette.substring(zeichenkette.length(), zeichenkette.length());
                }
            }
        }


        return auszugebenesWort;
}
}


	

 


