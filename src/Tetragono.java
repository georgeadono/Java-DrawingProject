/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */

import java.awt.Color;


// tetragono einai orthogonio me pleyres ises
public class Tetragono extends Orthogonio{

    public Tetragono(int x, int y, int platos,int xromaperigrammatos,int xromagemismatos) {
        super(x, y, platos, platos,xromaperigrammatos,xromagemismatos);
    }
    @Override
    public String toString() {
        return "Τετράγωνο(" + xsimia[0]+","+ysimia[0]+") Μέγεθος:"+this.platos;
    }
}
