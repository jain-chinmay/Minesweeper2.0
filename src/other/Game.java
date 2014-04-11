package other;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import my.Difficulty;
/**
 *
 * @author Madmancj
 */
public class Game extends JFrame implements ActionListener {
    private JButton start;
    private JButton exit;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private static Difficulty test;
    private static Game game;
    public Game(){
        jPanel1 = new JPanel();
        start = new JButton();
        exit = new JButton();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        
        jPanel1.setBackground(Color.BLACK);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        start.setText("Start");
        start.setForeground(Color.WHITE);
        start.setBackground(Color.red);
        exit.setText("Exit");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLUE);
        start.addActionListener(this);
        
        exit.addActionListener(this);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/minesweeper_logo5.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel3.setText("\u00A9 Copyright by CJ. All Rights Reserved.");
        jLabel3.setToolTipText("");

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/ZSkLgF1v3lC5EDrJ5sFFOhigj6IAf_kE3EdAh7CLpEi0FXpheWTfL5WCFi3qvKv1_tQ=w300.jpg"))); // NOI18N
        jLabel4.setText("");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(start, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(exit, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(start, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }
    public static void main(String[] args){
        game= new Game();
        game.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source==start){
            test= new Difficulty();
            game.setVisible(false);
        }
        else{
            System.exit(1);
        }
    }    
}
