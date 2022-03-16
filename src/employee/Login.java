/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Storyteller
 */
public class Login implements ActionListener {
    
    JFrame f;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    Login(){
        f = new JFrame("Login");
        
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel("Username");
        l1.setBounds(40,20, 100, 30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70, 100, 30);
        f.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t2 = new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 150, 150);
        f.add(l3);
        
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
                Conn c = new Conn();
                String username = t1.getText();
                String password = t2.getText();

                String q = "select * from users where username='"+username+"' and password='"+password+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    new Details().f.setVisible(true);
                    f.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource() == b2){
            f.setVisible(false);
            new FrontPage();
        }
    }
    
    public static void main(String[] arg){
        Login l = new Login();
    }
    
}