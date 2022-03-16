/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Storyteller
 */
public class SearchEmployee implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;
    
    public SearchEmployee() {
        f=new JFrame("Search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search.png"));
        l5.setIcon(img);


        l=new JLabel("Employee Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
            f.setVisible(false);
            new UpdateEmployee(t.getText());
        }else if(e.getSource()==b2){
            f.setVisible(false);
            Details d = new Details();
        }
    }
    
    public static void main(String[] arg){
        new SearchEmployee();
    }
    
}
