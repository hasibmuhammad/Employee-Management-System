/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Storyteller
 */
public class UpdateEmployee extends AddEmployee implements ActionListener{
    
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String id_emp;

    public UpdateEmployee(String idFromSearch) {
        super(0);
        f=new JFrame("Update Employee Details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idFromSearch;    
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee/icons/add_employee.jpg"));
        id15.setIcon(img);
        
        id8 = new JLabel("Update Employee Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("First Name:");  
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Last Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("Age:");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("Date of Birth:");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Address:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("Phone:");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Email ID:");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);

        id8= new JLabel("Education:");
        id8.setBounds(400,250,100,30);  
        id8.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id8);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);

        id9= new JLabel("Job Post:");
        id9.setBounds(50,300,150,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);
        
        t9=new JTextField();
        t9.setBounds(200,300,150,30);
        id15.add(t9);
        
        id10= new JLabel("NID No:");
        id10.setBounds(400,300,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        
        t10=new JTextField();
        t10.setBounds(600,300,150,30);
        id15.add(t10);
        
        f.setVisible(false);

        b=new JButton("Update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(idFromSearch);
    }
    
    int i=0;
    String age,dat;

    void showData(String s){
        try{
            Conn con = new Conn();
            String str = "select * from employee where emp_id = '"+s+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(2));
                t2.setText(rs.getString(3));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(6));
                t6.setText(rs.getString(7));
                t7.setText(rs.getString(8));
                t8.setText(rs.getString(9));
                t9.setText(rs.getString(10));
                t10.setText(rs.getString(11));

                age=rs.getString(5);
                dat=rs.getString(4);
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"Id not found");
                new SearchEmployee();
                return;
            } else {
                f.setVisible(true);
                f.setSize(900,500);
                f.setLocation(400,100);
            }
            
        }catch(Exception ex){}
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                Conn con = new Conn();
                String str = "update employee set emp_fname='"+t1.getText()+"',emp_lname='"+t2.getText()+"',emp_dob='"+t4.getText()+"', emp_age='"+t3.getText()+"',emp_address='"+t5.getText()+"',emp_phone='"+t6.getText()+"',emp_email='"+t7.getText()+"',emp_education='"+t8.getText()+"',emp_post='"+t9.getText()+"',emp_nid_no='"+t10.getText()+"' where emp_id='"+id_emp+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new SearchEmployee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            Details d=new Details();
        }
    }

    public static void main(String[] arg){
        new UpdateEmployee("Update Employee");
    }
}
