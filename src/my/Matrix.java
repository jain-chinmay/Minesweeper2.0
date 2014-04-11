/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import my.minesweeper;
/**
 *
 * @author Madmancj
 */
public class Matrix extends JFrame implements ActionListener{
    private JButton five;
    private JButton ten;
    private JButton fifteen;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    static int diff;
    minesweeper test;
    public Matrix(int a) {
        initComponents();
        setVisible(true);
        diff = a;
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        five = new JButton();
        ten = new JButton();
        fifteen = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/minesweeper_logo5.jpg"))); // NOI18N

        five.setBackground(new java.awt.Color(204, 0, 0));
        five.setForeground(new java.awt.Color(255, 255, 255));
        five.setText("5 * 5");
        five.addActionListener(this);

        ten.setBackground(new java.awt.Color(0, 153, 0));
        ten.setForeground(new java.awt.Color(255, 255, 255));
        ten.setText("10 * 10");
        ten.addActionListener(this);

        fifteen.setBackground(new java.awt.Color(0, 51, 153));
        fifteen.setForeground(new java.awt.Color(255, 255, 255));
        fifteen.setText("15 * 15");
        fifteen.addActionListener(this);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Size");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(ten, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(five, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fifteen, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(five, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ten, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fifteen, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, 500, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public void actionPerformed(ActionEvent e) {                                         
        // TODO add your handling code here:
        Object source = e.getSource();
        if (source==ten){
            test= new minesweeper(diff,10);
            setVisible(false);
        }
        else if (source==five){
            test= new minesweeper(diff,5);
            setVisible(false);                                        
        }
        else if (source==fifteen){
            test= new minesweeper(diff,15);
            setVisible(false);
        }
    }    
}
