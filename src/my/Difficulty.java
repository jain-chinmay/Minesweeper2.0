/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import my.Matrix;
/**
 *
 * @author Madmancj
 */
public class Difficulty extends JFrame implements ActionListener{
    private JButton easy;
    private JButton medium;
    private JButton expert;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private static Matrix test;
    public Difficulty() {
        initComponents();
        setVisible(true);
    }
        private void initComponents() {

        jPanel1 = new JPanel();
        easy = new JButton();
        medium = new JButton();
        expert = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel("Select Difficulty");
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        easy.addActionListener(this);
        medium.addActionListener(this);
        expert.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        easy.setBackground(new java.awt.Color(51, 102, 255));
        easy.setForeground(new java.awt.Color(255, 255, 255));
        easy.setText("Easy");

        medium.setBackground(new java.awt.Color(255, 0, 0));
        medium.setForeground(new java.awt.Color(255, 255, 255));
        medium.setText("Medium");

        expert.setBackground(new java.awt.Color(51, 153, 0));
        expert.setForeground(new java.awt.Color(255, 255, 255));
        expert.setText("Expert");

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/minesweeper_logo5.jpg"))); // NOI18N

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(medium, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addComponent(easy, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addComponent(expert, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(68, 68, 68)
                .addComponent(easy, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(medium, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expert, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public void actionPerformed(ActionEvent e) {                                         
        // TODO add your handling code here:
        Object source = e.getSource();
        if (source==easy){
            test= new Matrix(1);
            setVisible(false);
        }
        else if (source==medium){
            test= new Matrix(2);
            setVisible(false);                                        
        }
        else if (source==expert){
            test= new Matrix(3);
            setVisible(false);
        }
    }
}