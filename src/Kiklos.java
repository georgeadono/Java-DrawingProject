/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */


public class Kiklos extends Elleipsi{

    public Kiklos(int x, int y, int platos,int xromagemismatos) {
        super(x, y, platos, platos, xromagemismatos);
    }
    @Override
    public String toString() {
        return "Κύκλος(" + x+","+y+") Μέγεθος:"+this.platos;
    }
    
}
