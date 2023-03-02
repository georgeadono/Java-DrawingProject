/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */

import java.awt.Graphics;
import java.io.Serializable;

// Κάθε σχήμα έχει κάποια κοινά χαρακτηριστικά τα οποία υλοποιούνται/αναφέρονται εδώ.
// Επιπλέον κάθε σχήμα μπορεί να γραφεί σε αρχείο.
abstract public class Sxima implements Serializable, Cloneable {
    int xromagemismatos;

    public Sxima(int xromagemismatos) {
        this.xromagemismatos = xromagemismatos;
    }
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
        
    }
    
    // Κάθε σχήμα μπορεί να σχεδιάσει τον εαυτό του αφού πάρει σαν όρισμα
    // την Graphics του Panel στο οποίο γίνεται η ζωγραφική.
    abstract public void sxediasmos(Graphics g);
}
