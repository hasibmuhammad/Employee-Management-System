/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Storyteller
 */
public class Details implements ActionListener {
    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5;
    
    public Details() {
        f = new JFrame("Manage Employee");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,700,550);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/details.gif"));
        l1.setIcon(i1);
        f.add(l1);
        
        l2 = new JLabel("Manage Employee");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.black);
        l1.add(l2);
        
        b1 = new JButton("Add");
        b1.setBounds(420, 80, 100, 40);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        l1.add(b1);
        
        b2 = new JButton("View");
        b2.setBounds(530, 80, 100, 40);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        l1.add(b2);
        
        b3 = new JButton("Remove");
        b3.setBounds(420, 140, 100, 40);
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.addActionListener(this);
        l1.add(b3);
        
        b4 = new JButton("Update");
        b4.setBounds(530, 140, 100, 40);
        b4.setFont(new Font("serif", Font.BOLD, 15));
        b4.addActionListener(this);
        l1.add(b4);
        
        b5 = new JButton("Employees");
        b5.setBounds(470, 200, 120, 40);
        b5.setFont(new Font("serif", Font.BOLD, 15));
        b5.addActionListener(this);
        l1.add(b5);
        
        f.setVisible(true);
        f.setSize(700, 500);
        f.setLocation(450,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            f.setVisible(false);
            new AddEmployee();
        }
        if(e.getSource() == b2){
            f.setVisible(false);
            new ViewEmployee();
        }
        if(e.getSource() == b3){
            f.setVisible(false);
            new RemoveEmployee();
        }
        if(e.getSource() == b4){
            f.setVisible(false);
            new SearchEmployee();
        }
        if(e.getSource() == b5){
            f.setVisible(false);
            new EmployeeList();
        }
    }
    
    public static void main(String[] arg){
        Details d = new Details();
    }
    
}
