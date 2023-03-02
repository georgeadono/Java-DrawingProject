/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */


import java.awt.Color;
import java.awt.Graphics;


// eleipsi einai sxima.
public class Elleipsi extends Sxima{
    protected int platos;
    protected int ypsos;
    protected int x;
    protected int y;
    Elleipsi(int x,int y,int platos, int ypsos,int xromagemismatos){
        super(xromagemismatos);
        this.platos = platos;
        this.ypsos = ypsos;
        this.x = x;
        this.y = y;
    }
        
    @Override
    public void sxediasmos(Graphics g) {
        g.setColor(Frame.xromata[xromagemismatos]);
        g.fillOval(x, y, platos, ypsos);
    }
    @Override
    public String toString() {
        return "Έλλειψη(" + x+","+y+") Μέγεθος:"+this.platos+"Χ"+this.ypsos;
    }
}
