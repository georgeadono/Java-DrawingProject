/*
icsd16007 , Αντωνόπουλος Γεώργιος
icsd16125 , Μπούτος Χαράλαμπος
 */


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

// parathyriko perivallon
public class Frame extends JFrame{
    
    // ola ta xromata pou yposthrizontai se string kai color
    static String xr[] = {"Κόκκινο","Μπλε","Μαύρο","Πορτοκαλί","Γαλάζιο","Ροζ","Γκρι","Μοβ"};
    static Color xromata[] = {Color.red,Color.blue,Color.black,
                            Color.orange,Color.cyan,Color.pink,
                            Color.green,Color.magenta};
    // karteles me ola ta menou
    private JTabbedPane menu;
    // gia zografiki
    private JPanel zografiki;
    // menou gia dimiourgia sximatos
    private JPanel dimiourgiamenu;
    // menou gia emfanisi sximaton
    private JPanel sximatamenu;
    // prosthafairesh sximaton sthn lista me ta sximata
    DefaultListModel<Sxima> modeloslistassximaton;
    
    Frame(){
        JPanel vasiko = new JPanel();
        vasiko.setLayout(new GridLayout(1,2));
        menu();
        zografiki();
        vasiko.add(menu);
        vasiko.add(zografiki);
        this.getContentPane().add(vasiko);
        // megethos
        this.setSize(new Dimension(800,500));
        // orato
        this.setVisible(true);
        // den allazei to megethos
        //this.setResizable(false);
        // kleinei h efarmogi
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void zografiki(){
        
        zografiki = new JPanel(){
        // tropos zografikis sto panel
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(int i = 0; i< modeloslistassximaton.getSize();i++){
                    modeloslistassximaton.getElementAt(i).sxediasmos(g);
                }
            }
        };
        zografiki.setBackground(Color.white);
    }
    private void menu(){
        dimiourgiaMenu();
        sximataMenu();
        menu =new JTabbedPane(); 
        menu.add(dimiourgiamenu,"Δημιουργία");
        menu.add(sximatamenu,"Σχήματα");
    }
    // dimiourgia menou dimiourgias
    private void dimiourgiaMenu(){
        dimiourgiamenu = new JPanel();
        GridLayout gl = new GridLayout(0,2);
        dimiourgiamenu.setLayout(gl);
        dimiourgiamenu.add(new JLabel("x:"));
        SpinnerModel xsynt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x = new JSpinner(xsynt);
        dimiourgiamenu.add(x);
        dimiourgiamenu.add(new JLabel("y:"));
        SpinnerModel ysynt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y = new JSpinner(ysynt);
        dimiourgiamenu.add(y);
        dimiourgiamenu.add(new JLabel("Χρώμα περιγράμματος:"));
        JComboBox perigramma=new JComboBox(xr); 
        dimiourgiamenu.add(perigramma);
        dimiourgiamenu.add(new JLabel("Χρώμα γεμίσματος:"));
        JComboBox gemisma=new JComboBox(xr); 
        dimiourgiamenu.add(gemisma);
        
        dimiourgiamenu.add(new JLabel("Ορθογώνιο:"));
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(new JLabel("Πλάτος:"));
        SpinnerModel orthplatossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner orthplatos = new JSpinner(orthplatossynt);
        dimiourgiamenu.add(orthplatos);
        dimiourgiamenu.add(new JLabel("Ύψος:"));
        SpinnerModel orthupsossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner orthupsos = new JSpinner(orthupsossynt);
        dimiourgiamenu.add(orthupsos);
        
        dimiourgiamenu.add(new JLabel());
        JButton orthneo = new JButton("Νέο");
        orthneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Orthogonio o = new Orthogonio((Integer)xsynt.getValue(),
                                                (Integer)ysynt.getValue(),
                                                (Integer)orthplatossynt.getValue(),
                                                (Integer)orthupsossynt.getValue(),
                                                perigramma.getSelectedIndex(),
                                                gemisma.getSelectedIndex());
                modeloslistassximaton.add(0,o);
                zografiki.repaint();
            }
        
        
        });
        dimiourgiamenu.add(orthneo);
        
        dimiourgiamenu.add(new JLabel("Τετράγωνο:"));
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(new JLabel("Πλάτος:"));
        SpinnerModel tetrplatossynt = new SpinnerNumberModel(20, 10, 100, 1);     
        JSpinner tetrplatos = new JSpinner(tetrplatossynt);
        dimiourgiamenu.add(tetrplatos);
        dimiourgiamenu.add(new JLabel());
        JButton tetrneo = new JButton("Νέο");
        tetrneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Tetragono t = new Tetragono((Integer)xsynt.getValue(),
                                                (Integer)ysynt.getValue(),
                                                (Integer)tetrplatossynt.getValue(),
                                                perigramma.getSelectedIndex(),
                                                gemisma.getSelectedIndex());
                modeloslistassximaton.add(0,t);
                zografiki.repaint();
            }
        
        
        });
        dimiourgiamenu.add(tetrneo);
        
        dimiourgiamenu.add(new JLabel("Τρίγωνο:"));
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(new JLabel("x2:"));
        SpinnerModel x2synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x2 = new JSpinner(x2synt);
        dimiourgiamenu.add(x2);
        dimiourgiamenu.add(new JLabel("y2:"));
        SpinnerModel y2synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y2 = new JSpinner(y2synt);
        dimiourgiamenu.add(y2);
        dimiourgiamenu.add(new JLabel("x3:"));
        SpinnerModel x3synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x3 = new JSpinner(x3synt);
        dimiourgiamenu.add(x3);
        dimiourgiamenu.add(new JLabel("y3:"));
        SpinnerModel y3synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y3 = new JSpinner(y3synt);
        dimiourgiamenu.add(y3);
        JButton trigneo = new JButton("Νέο");
        trigneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Trigono t = new Trigono((Integer)xsynt.getValue(),
                                                (Integer)ysynt.getValue(),
                                                (Integer)x2synt.getValue(),
                                                (Integer)y2synt.getValue(),
                                                (Integer)x3synt.getValue(),
                                                (Integer)y3synt.getValue(),
                                                gemisma.getSelectedIndex());
                modeloslistassximaton.add(0,t);
                zografiki.repaint();
            }
        
        
        });
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(trigneo);
        
        dimiourgiamenu.add(new JLabel("Έλλειψη:"));
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(new JLabel("Πλάτος:"));
        SpinnerModel elplatossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner elplatos = new JSpinner(elplatossynt);
        dimiourgiamenu.add(elplatos);
        dimiourgiamenu.add(new JLabel("Ύψος:"));
        SpinnerModel elupsossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner elupsos = new JSpinner(elupsossynt);
        dimiourgiamenu.add(elupsos);
        
        dimiourgiamenu.add(new JLabel());
        JButton elneo = new JButton("Νέο");
        elneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Elleipsi el = new Elleipsi((Integer)xsynt.getValue(),
                                                (Integer)ysynt.getValue(),
                                                (Integer)elplatossynt.getValue(),
                                                (Integer)elupsossynt.getValue(),
                                                gemisma.getSelectedIndex());
                modeloslistassximaton.add(0,el);
                zografiki.repaint();
            }
        
        
        });
        dimiourgiamenu.add(elneo);
        
        dimiourgiamenu.add(new JLabel("Κύκλος:"));
        dimiourgiamenu.add(new JLabel());
        dimiourgiamenu.add(new JLabel("Πλάτος:"));
        SpinnerModel kyklplatossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner kyklplatos = new JSpinner(kyklplatossynt);
        dimiourgiamenu.add(kyklplatos);
        dimiourgiamenu.add(new JLabel());
        JButton kyklneo = new JButton("Νέο");
        kyklneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Kiklos k = new Kiklos((Integer)xsynt.getValue(),
                                                (Integer)ysynt.getValue(),
                                                (Integer)kyklplatos.getValue(),
                                                gemisma.getSelectedIndex());
                modeloslistassximaton.add(0,k);
                zografiki.repaint();
            }
        
        
        });
        dimiourgiamenu.add(kyklneo);
    }
    // dimiourgia menou sximaton
    private void sximataMenu(){
        
        sximatamenu = new JPanel();
        sximatamenu.setLayout(new GridLayout(2,1));
        modeloslistassximaton = new DefaultListModel<>();
        JList<Sxima> listasximaton = new JList<>(modeloslistassximaton); 
        
        sximatamenu.add(new JScrollPane(listasximaton));
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(0,2));
        sximatamenu.add(menu);
        
        menu.add(new JLabel("x:"));
        SpinnerModel xsynt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x = new JSpinner(xsynt);
        menu.add(x);
        menu.add(new JLabel("y:"));
        SpinnerModel ysynt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y = new JSpinner(ysynt);
        menu.add(y);
        menu.add(new JLabel("Χρώμα περιγράμματος:"));
        JComboBox perigramma=new JComboBox(xr); 
        menu.add(perigramma);
        menu.add(new JLabel("Χρώμα γεμίσματος:"));
        JComboBox gemisma=new JComboBox(xr); 
        menu.add(gemisma);
        menu.add(new JLabel("Πλάτος:"));
        SpinnerModel platossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner elplatos = new JSpinner(platossynt);
        menu.add(elplatos);
        menu.add(new JLabel("Ύψος:"));
        SpinnerModel ypsossynt = new SpinnerNumberModel(20, 10, 200, 1);     
        JSpinner ypsos = new JSpinner(ypsossynt);
        menu.add(ypsos);
        
        menu.add(new JLabel("x2:"));
        SpinnerModel x2synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x2 = new JSpinner(x2synt);
        menu.add(x2);
        menu.add(new JLabel("y2:"));
        SpinnerModel y2synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y2 = new JSpinner(y2synt);
        menu.add(y2);
        menu.add(new JLabel("x3:"));
        SpinnerModel x3synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner x3 = new JSpinner(x3synt);
        menu.add(x3);
        menu.add(new JLabel("y3:"));
        SpinnerModel y3synt = new SpinnerNumberModel(20, 0, 390, 1);     
        JSpinner y3 = new JSpinner(y3synt);
        menu.add(y3);
        
        JButton antigrafi = new JButton("Αντιγραφή");
        menu.add(antigrafi);
        JButton tropopiisi = new JButton("Τροποποίηση");
        menu.add(tropopiisi);
        JButton diagrafi = new JButton("Διαγραφή");
        menu.add(diagrafi);
        menu.add(new JLabel());
        JButton apothikeusi = new JButton("Αποθήκευση");
        menu.add(apothikeusi);
        JButton anoigma = new JButton("Άνοιγμα");
        menu.add(anoigma);
        listasximaton.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                xsynt.setValue(0);
                ysynt.setValue(0);
                platossynt.setValue(0);
                ypsossynt.setValue(0);
                perigramma.setSelectedIndex(0);
                gemisma.setSelectedIndex(0);
                x2synt.setValue(0);
                y2synt.setValue(0);
                x3synt.setValue(0);
                y3synt.setValue(0);
                //if (!listasximaton.getValueIsAdjusting()){
                int i =    listasximaton.getSelectedIndex();
                if (i!=-1){
                    Sxima s = listasximaton.getSelectedValue();
                    if (s instanceof Tetragono){
                        Tetragono t = (Tetragono) s;
                        xsynt.setValue(t.xsimia[0]);
                        ysynt.setValue(t.ysimia[0]);
                        platossynt.setValue(t.platos);
                        perigramma.setSelectedIndex(t.xromaperigrammatos);
                        gemisma.setSelectedIndex(t.xromagemismatos);

                    }
                    else if (s instanceof Orthogonio){
                        Orthogonio o = (Orthogonio) s;
                        xsynt.setValue(o.xsimia[0]);
                        ysynt.setValue(o.ysimia[0]);
                        platossynt.setValue(o.platos);
                        ypsossynt.setValue(o.ypsos);
                        perigramma.setSelectedIndex(o.xromaperigrammatos);
                        gemisma.setSelectedIndex(o.xromagemismatos);
                    }
                    else if (s instanceof Kiklos){
                        Kiklos k = (Kiklos) s;
                        xsynt.setValue(k.x);
                        ysynt.setValue(k.y);
                        platossynt.setValue(k.platos);
                        gemisma.setSelectedIndex(k.xromagemismatos);
                    }
                    else if (s instanceof Elleipsi){
                        Elleipsi el= (Elleipsi) s;
                        xsynt.setValue(el.x);
                        ysynt.setValue(el.y);
                        platossynt.setValue(el.platos);
                        platossynt.setValue(el.ypsos);
                        gemisma.setSelectedIndex(el.xromagemismatos);
                    }
                    else if (s instanceof Trigono){
                        Trigono t= (Trigono) s;
                        xsynt.setValue(t.xsimia[0]);
                        ysynt.setValue(t.ysimia[0]);
                        x2synt.setValue(t.xsimia[1]);
                        y2synt.setValue(t.ysimia[1]);
                        x3synt.setValue(t.xsimia[2]);
                        y3synt.setValue(t.ysimia[2]);

                    }
                }
            }
            
        });
        antigrafi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listasximaton.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(Frame.this,"Δεν έχει επιλεγεί σχήμα για αντιγραφή στην λίστα");
                }
                else{
                    Sxima s = listasximaton.getSelectedValue();
                    Sxima ns;
                    try {
                        ns = (Sxima)s.clone();
                        modeloslistassximaton.add(0,ns);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                    
                    zografiki.repaint();
                }
            }
        
        });
        tropopiisi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listasximaton.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(Frame.this,"Δεν έχει επιλεγεί σχήμα για τροποποίηση");
                }
                else{
                    Sxima s = modeloslistassximaton.get(listasximaton.getSelectedIndex());
                    if (s instanceof Tetragono){
                        Tetragono t = (Tetragono) s;
                        t.xsimia[0] = (Integer)xsynt.getValue();
                        t.ysimia[0] = (Integer)ysynt.getValue();
                        t.platos = (Integer) platossynt.getValue();
                        t.xsimia[1] =  t.xsimia[0]+t.platos;
                        t.ysimia[1] = t.ysimia[0];
                        t.xsimia[2] =  t.xsimia[0]+t.platos;
                        t.ysimia[2] = t.ysimia[0]+t.platos;
                        t.xsimia[3] =  t.xsimia[0];
                        t.ysimia[3] = t.ysimia[0]+t.platos;
                        t.xromaperigrammatos = perigramma.getSelectedIndex();
                        t.xromagemismatos = gemisma.getSelectedIndex();

                    }
                    else if (s instanceof Orthogonio){
                        Orthogonio o = (Orthogonio) s;
                        o.xsimia[0] = (Integer)xsynt.getValue();
                        o.ysimia[0] = (Integer)ysynt.getValue();
                        o.platos = (Integer) platossynt.getValue();
                        o.ypsos = (Integer) ypsossynt.getValue();
                        o.xsimia[1] =  o.xsimia[0]+o.platos;
                        o.ysimia[1] = o.ysimia[0];
                        o.xsimia[2] =  o.xsimia[0]+o.platos;
                        o.ysimia[2] = o.ysimia[0]+o.ypsos;
                        o.xsimia[3] =  o.xsimia[0];
                        o.ysimia[3] = o.ysimia[0]+o.ypsos;
                        o.xromaperigrammatos = perigramma.getSelectedIndex();
                        o.xromagemismatos = gemisma.getSelectedIndex();
                    }
                    else if (s instanceof Kiklos){
                        Kiklos k = (Kiklos) s;
                        k.x = (Integer)xsynt.getValue();
                        k.y = (Integer)ysynt.getValue();
                        
                        k.platos = (Integer)platossynt.getValue();
                        k.ypsos = (Integer)platossynt.getValue();
                        k.xromagemismatos = gemisma.getSelectedIndex();
                        
                    }
                    else if (s instanceof Elleipsi){
                        Elleipsi el= (Elleipsi) s;
                        el.x = (Integer)xsynt.getValue();
                        el.y = (Integer)ysynt.getValue();
                        el.ypsos = (Integer)ypsossynt.getValue();
                        el.platos = (Integer)platossynt.getValue();
                        el.xromagemismatos = gemisma.getSelectedIndex();
                    }
                    else if (s instanceof Trigono){
                        Trigono t= (Trigono) s;
                        t.xsimia[0] = (Integer) xsynt.getValue();
                        t.ysimia[0] = (Integer) ysynt.getValue();
                        t.xsimia[1] = (Integer) x2synt.getValue();
                        t.ysimia[1] = (Integer) y2synt.getValue();
                        t.xsimia[2] = (Integer) x3synt.getValue();
                        t.ysimia[2] = (Integer) y3synt.getValue();
                        t.xromagemismatos = gemisma.getSelectedIndex();

                    }
                }
                    zografiki.repaint();
            }
        
        });
        diagrafi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listasximaton.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(Frame.this,"Δεν έχει επιλεγεί σχήμα για διαγραφή στην λίστα");
                }
                else{
                    int i = listasximaton.getSelectedIndex();
                    listasximaton.clearSelection();
                    modeloslistassximaton.remove(i);
                }
                zografiki.repaint();
            }
            
        });
        apothikeusi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser epilogi = new JFileChooser();
                int ep = epilogi.showSaveDialog(null);
                if (ep== JFileChooser.APPROVE_OPTION){
                    FileOutputStream fout;
                    ObjectOutputStream oot;
                    try {
                        fout = new FileOutputStream(epilogi.getSelectedFile());
                        oot = new ObjectOutputStream(fout);
                        for(int i = 0; i< modeloslistassximaton.getSize();i++){
                            oot.writeObject(modeloslistassximaton.getElementAt(i));
                        }
                    } catch (FileNotFoundException ex) {
                        
                    } catch (IOException ex) {
                        
                    }
                     
        
                }
                
            }
        }
        );
        anoigma.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser epilogi = new JFileChooser();
                int ep = epilogi.showOpenDialog(null);
                if (ep== JFileChooser.APPROVE_OPTION){
                    modeloslistassximaton.clear();
                    FileInputStream fin;
                    ObjectInputStream oin;
                    try {
                        fin = new FileInputStream(epilogi.getSelectedFile());
                        oin = new ObjectInputStream(fin);
                        while(true){
                            try{
                                modeloslistassximaton.add(0, (Sxima) oin.readObject());
                            }
                            catch(EOFException eof){
                                break;
                            } catch (ClassNotFoundException ex) {
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        
                    } catch (IOException ex) {
                        
                    }
                    zografiki.repaint();
                }
            }
        }
        );
    }
}
