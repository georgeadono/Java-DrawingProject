/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */


import java.awt.Graphics;

// Orthogonio einai sxima
public class Orthogonio extends Sxima{
    int platos;
    int ypsos;
    int xromaperigrammatos;
    int []xsimia;
    int []ysimia;
    Orthogonio(int x,int y,int platos, int ypsos,int xromaperigrammatos,int xromagemismatos ){
        super(xromagemismatos);
        xsimia = new int[4];
        ysimia = new int[4];
        xsimia[0]=x;
        ysimia[0]=y;
        xsimia[1]=x+platos;
        ysimia[1]=y;
        xsimia[2]=x+platos;
        ysimia[2]=y+ypsos;
        xsimia[3]=x;
        ysimia[3]=y+ypsos;
        this.xromaperigrammatos = xromaperigrammatos;
        this.platos = platos;
        this.ypsos = ypsos;
        
    }
    @Override
    public Orthogonio clone() throws CloneNotSupportedException
    {
        Orthogonio o =  (Orthogonio)super.clone();
        o.xsimia = xsimia.clone();
        o.ysimia = ysimia.clone();
        return o;
    }
    @Override
    public void sxediasmos(Graphics g) {
        g.setColor(Frame.xromata[xromagemismatos]);
        g.fillPolygon(xsimia, ysimia, 4);
        g.setColor(Frame.xromata[xromaperigrammatos]);
        g.drawPolygon(xsimia, ysimia, 4);
    }
    // gia emfanisi sthn lista sximaton
    @Override
    public String toString() {
        return "Ορθογώνιο(" + xsimia[0]+","+ysimia[0]+") Μέγεθος:"+this.platos+"Χ"+this.ypsos;
    }
    
}
