/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Storyteller
 */
public class EmployeeList implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JButton b1;
    String id,fname, lname, fullName, dob, age, address, phone, email, education, post, nid;

    public EmployeeList() {
        f = new JFrame("Employee List");
        f.setVisible(true);
        f.setSize(850,670);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,850,642);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee/icons/add_employee.jpg"));
        l1.setIcon(img);
        f.add(l1);
        
        l2 = new JLabel("Employee Details");
        l2.setBounds(50,10,250,30);
        f.add(l2);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l1.add(l2);
        f.add(l1);
        
        l3 = new JLabel("Employee Id:");
        l3.setBounds(50,70,120,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l3);
        
        l5 = new JLabel("Name:");
        l5.setBounds(200,70,120,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l5);
        
        l7 = new JLabel("Phone:");
        l7.setBounds(400,70,120,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l7);
        
        l9 = new JLabel("Job Post:");
        l9.setBounds(550,70,120,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l9);
        
        b1=new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,580,100,30);
        b1.addActionListener(this);
        l1.add(b1);
        
        
        try{
            Conn con = new Conn();
            String str = "select * from employee";
            ResultSet rs = con.s.executeQuery(str);
            int i = 40;
            while(rs.next()){
                id = String.valueOf(rs.getInt("emp_id"));
                fname = rs.getString("emp_fname");
                lname = rs.getString("emp_lname");
                fullName = fname + " " + lname;
                dob = rs.getString("emp_dob");
                age = rs.getString("emp_age");
                address = rs.getString("emp_address");
                phone = rs.getString("emp_phone");
                email = rs.getString("emp_email");
                education = rs.getString("emp_education");
                post = rs.getString("emp_post");
                nid = rs.getString("emp_nid_no");
                
                l4 = new JLabel(id);
                l4.setBounds(100,70+i,200+i,30);
                l4.setFont(new Font("serif",Font.BOLD,20));
                l1.add(l4);
                
                l6 = new JLabel(fullName);
                l6.setBounds(200,70+i,200+i,30);
                l6.setFont(new Font("serif",Font.BOLD,20));
                l1.add(l6);
                
                l8 = new JLabel(phone);
                l8.setBounds(400,70+i,200+i,30);
                l8.setFont(new Font("serif",Font.BOLD,20));
                l1.add(l8);
                
                l10 = new JLabel(post);
                l10.setBounds(550,70+i,200+i,30);
                l10.setFont(new Font("serif",Font.BOLD,20));
                l1.add(l10);
                
                i = i + 40;
            }
        
            
        }catch(Exception ex){}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            f.setVisible(false);
            Details d=new Details();
        }
    }
    
    public static void main(String[] arg){
        new EmployeeList();
    }
    
}
