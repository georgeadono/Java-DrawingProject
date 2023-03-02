/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */


import java.awt.Graphics;


public class Trigono extends Sxima{
    int []xsimia;
    int []ysimia;
    Trigono(int x1,int y1,int x2,int y2,int x3,int y3,int xromagemismatos ){
        super(xromagemismatos);
        xsimia = new int[3];
        ysimia = new int[3];
        xsimia[0]=x1;
        ysimia[0]=y1;
        xsimia[1]=x2;
        ysimia[1]=y2;
        xsimia[2]=x3;
        ysimia[2]=y3;
        
    }
    @Override
    public void sxediasmos(Graphics g) {
        g.setColor(Frame.xromata[xromagemismatos]);
        g.fillPolygon(xsimia, ysimia, 3);
       
    }
    @Override
    public Trigono clone() throws CloneNotSupportedException
    {
        Trigono t =  (Trigono)super.clone();
        t.xsimia = xsimia.clone();
        t.ysimia = ysimia.clone();
        return t;
    }
    // gia emfanisi sthn lista sximaton
    @Override
    public String toString() {
        return "Τρίγωνο(" + xsimia[0]+","+ysimia[0]+") - (" + xsimia[1]+","+ysimia[1]+") - (" + xsimia[2]+","+ysimia[2]+")";
    }
}
