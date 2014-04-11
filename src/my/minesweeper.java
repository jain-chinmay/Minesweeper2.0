package my;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import other.Game;
/**
 *
 * @author Madmancj
 */
public class minesweeper implements ActionListener{
    JFrame dock;
    JPanel base;
    JPanel Header;
    JPanel Footer;
    int num_mines;
    int matrix;
    int remaining;
    int[][] value;
    JButton[] b;
    Font f= new Font("Comic Sans MS",Font.BOLD,25);
    JButton start;
    JButton exit;
    JLabel temp1;
    JLabel temp2;
    ArrayList<Integer> mines;
    Color[] colors= {Color.red,Color.BLUE,Color.BLACK,Color.MAGENTA,Color.GREEN};
    Border border1;
    Border border2;
    public minesweeper(int percent, int val){
        dock = new JFrame();
        base= new JPanel();
        Header= new JPanel();
        Footer= new JPanel();
        matrix= val;
        num_mines= percent*matrix;
        remaining= (matrix*matrix);
        value = new int[matrix][matrix];
        b = new JButton[matrix*matrix];
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        base.setLayout(new GridLayout(matrix,matrix));
        Header.setBackground(Color.BLACK);
        base.setBackground(Color.BLACK);
        Footer.setBackground(Color.BLACK);
        for(int i=0;i<(matrix*matrix);i++){
            b[i]=new JButton();
            b[i].addActionListener(this);
            b[i].setBackground(Color.BLUE);
            b[i].setBorder(border1);
            b[i].setFont(f);
            b[i].setForeground(colors[((int)(4*(Math.random())))]);
            base.add(b[i]);
        }
        temp1= new JLabel();
        temp1.setIcon(new ImageIcon(getClass().getResource("/minesweeper_logo5.jpg")));
        /*temp1 = new JLabel("Minesweeper v2.0");
        temp1.setForeground(Color.red);
        temp1.setFont(f);*/
        GroupLayout HeaderLayout = new GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temp1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temp1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );        
        Footer.setLayout(new FlowLayout());
        temp2 = new JLabel("\u00A9 by CJ.");
        temp2.setForeground(Color.red);
        temp2.setFont(f);
        Footer.add(temp2);
        dock.getContentPane().add(BorderLayout.CENTER, base);
        dock.getContentPane().add(BorderLayout.NORTH, Header);
        dock.getContentPane().add(BorderLayout.SOUTH, Footer);
        dock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dock.setSize(600,500);
        dock.setVisible(true);
        start_game();
    }
    public void start_game(){
        mines = new ArrayList<>();
        for(int i=0;i<num_mines;i++){
            sel: do{
                int ran_d= (int) (((matrix*matrix)-1)*(Math.random()));
                if(mines.contains(ran_d)){
                    continue sel;
                }
                else{
                    mines.add(ran_d);
                    value[(ran_d)/matrix][(ran_d)%matrix]= -1;
                    break;
                }
            }while(true);    
        }
        
        for(int i=0;i<matrix;i++){
            for(int j=0;j<matrix;j++){
                if(value[i][j]==-1){//System.out.println("here");                    
                   }
                else{
                    int count=0;
                    for(int k=-1;k<2;k++){
                        if((i+k)>=0 && (i+k)<matrix){
                            if((j-1)>=0){
                                if(value[i+k][j-1]==-1){
                                    count++;
                                }
                            }
                            if(value[i+k][j]==-1){
                                count++;
                            }
                            if((j+1)<matrix){
                                if(value[i+k][j+1]==-1){
                                    count++;
                                }   
                            }
                        }
                    }
                    value[i][j]= count;
                //System.out.println(l[i].getText());
                }
            }
        }
        for(int i=0;i<matrix;i++){
            System.out.println(mines.get(i));
        }
    }
    public void gameOver() throws InterruptedException{
        for(int i=0;i<(matrix*matrix);i++){
            if(b[i].getBorder()!=border2){
                    b[i].setBackground(Color.cyan);
                    b[i].setBorder(border2);
                    if(value[i/matrix][i%matrix]==0){
                         b[i].setText("");
                    }
                    else if(value[i/matrix][i%matrix]==-1){
                        b[i].setIcon(new ImageIcon(getClass().getResource("/ultimate-minesweeper-08-icon.jpg")));
                        b[i].setBackground(Color.BLACK);
                    }
                    else{
                        b[i].setText(Integer.toString(value[i/matrix][i%matrix]));
                    }
            }
        }                
        final JFrame dock2 = new JFrame();
        dock2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel sub_base2 = new JPanel();
        sub_base2.setBackground(Color.BLACK);
        dock2.setBackground(Color.BLACK);
        JLabel l2= new JLabel("                     You Loose!!");
        l2.setForeground(Color.blue);
        l2.setFont(f);
        JLabel l3= new JLabel();
        l3.setIcon(new ImageIcon(getClass().getResource("/mzl.gawpunjn.jpg")));
        GroupLayout sub_base2Layout = new GroupLayout(sub_base2);
        sub_base2.setLayout(sub_base2Layout);
        sub_base2Layout.setHorizontalGroup(
            sub_base2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, sub_base2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l3, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
                .addComponent(l2, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        );
        sub_base2Layout.setVerticalGroup(
            sub_base2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, sub_base2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
                .addComponent(l2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        ); 
        sub_base2.add(l3);
        sub_base2.add(l2);
        dock2.setContentPane(sub_base2);
        dock2.setSize(600,500);
        Timer timer = new Timer(10000, new ActionListener(){@Override
        public void actionPerformed(ActionEvent e){dock2.setVisible(true);dock.setVisible(false);}});
        timer.setDelay(10000);
        timer.start();
        timer.setRepeats(false);
        timer.setCoalesce(true);
        }
    public void win(){
        JFrame dock2 = new JFrame();
        dock2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel sub_base2 = new JPanel();
        sub_base2.setBackground(Color.BLACK);
        dock2.setBackground(Color.BLACK);
        JLabel l2= new JLabel("                  Congrats you Win!!");
        l2.setForeground(Color.WHITE);
        l2.setFont(f);
        JLabel l3= new JLabel();
        l3.setIcon(new ImageIcon(getClass().getResource("/minesweeper_by_liggliluff-d64fyid.jpg")));
        GroupLayout sub_base2Layout = new GroupLayout(sub_base2);
        sub_base2.setLayout(sub_base2Layout);
        sub_base2Layout.setHorizontalGroup(
            sub_base2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, sub_base2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l3, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
                .addComponent(l2, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        );
        sub_base2Layout.setVerticalGroup(
            sub_base2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, sub_base2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l3, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
                .addComponent(l2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        ); 
        sub_base2.add(l3);
        sub_base2.add(l2);
        dock2.setContentPane(sub_base2);
        dock.setVisible(false);
        dock2.setVisible(true);
        dock2.setSize(600,500);
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        for(int i=0;i<(matrix*matrix);i++){
            if (source==b[i]){
                if(value[i/matrix][i%matrix]==-1){
                    try {
                        gameOver();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(minesweeper.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    b[i].setBackground(Color.cyan);
                    b[i].setBorder(border2);
                    if(value[i/matrix][i%matrix]==0){
                         b[i].setText("");
                    }
                    else{
                        b[i].setText(Integer.toString(value[i/matrix][i%matrix]));
                    }
                    remaining--;
                    if(remaining-(mines.size())==0){
                        win();
                    }
                }
            }
        }
    }
}
