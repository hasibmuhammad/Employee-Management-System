/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Storyteller
 */
class PrintData implements ActionListener {

    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7, aid8,id9,id10,aid10,id11,id12,id13,id14,id15,id16,id17,lab;
    String fname, lname, age, dob, address, phone,email,education,post,nid, currentTime, fullName;
    JButton b1,b2;
    JTextArea textarea;
    ImageIcon icon;
    int i = 0;
    
    PrintData(String e_id) {
         try{
            Conn con = new Conn();
            String str = "select * from employee where emp_id = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
                i = 1;
                fname = rs.getString("emp_fname");
                lname = rs.getString("emp_lname");
                fullName = fname + " "+ lname;
                dob = rs.getString("emp_dob");
                age = rs.getString("emp_age");
                address = rs.getString("emp_address");
                phone = rs.getString("emp_phone");
                email = rs.getString("emp_email");
                education = rs.getString("emp_education");
                post = rs.getString("emp_post");
                nid = rs.getString("emp_nid_no");
            }
            
            if(i == 0){
                JOptionPane.showMessageDialog(null,"Id not found");
                new ViewEmployee();
                return;
            } else{
                f=new JFrame("Print Data");
                f.setVisible(true);
                f.setSize(850,670);
                //        f.setLocation(450,200);
                f.setLocationRelativeTo(null);

                f.setBackground(Color.white);
                f.setLayout(null);


                id9=new JLabel();
                id9.setBounds(0,0,850,642);
                id9.setLayout(null);
                ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee/icons/add_employee.jpg"));
                id9.setIcon(img);

                id8 = new JLabel("Employee Details");
                id8.setBounds(50,10,250,30);
                f.add(id8);
                id8.setFont(new Font("serif",Font.BOLD,25));
                id9.add(id8);
                f.add(id9);

                id = new JLabel("Employee Id:");
                id.setBounds(50,70,120,30);
                id.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id);

                aid = new JLabel(e_id);
                aid.setBounds(200,70,200,30);
                aid.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid);

                id1 = new JLabel("Name:");
                id1.setBounds(50,120,100,30);
                id1.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id1);

                aid1 = new JLabel(fname + " "+ lname);
                aid1.setBounds(200,120,300,30);
                aid1.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid1);


                id2 = new JLabel("Date of Birth:"); 
                id2.setBounds(50,170,200,30);
                id2.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id2);

                aid2 = new JLabel(dob);
                aid2.setBounds(200,170,300,30);
                aid2.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid2);

                id3= new JLabel("Age:");
                id3.setBounds(50,220,100,30);
                id3.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id3);

                aid3= new JLabel(age);
                aid3.setBounds(200,220,300,30);
                aid3.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid3);


                id8= new JLabel("Address:");  
                id8.setBounds(50,270,100,30);
                id8.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id8);

                aid8= new JLabel(address);
                aid8.setBounds(200,270,300,30); 
                aid8.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid8);

                id4= new JLabel("Mobile No:");  
                id4.setBounds(50,320,100,30);
                id4.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id4);

                aid4= new JLabel(phone);
                aid4.setBounds(200,320,300,30); 
                aid4.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid4);


                id5= new JLabel("Email Id:");
                id5.setBounds(50,370,100,30);
                id5.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id5);

                aid5= new JLabel(email);
                aid5.setBounds(200,370,300,30);
                aid5.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid5);


                id6= new JLabel("Education:");
                id6.setBounds(50,420,100,30);
                id6.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id6);

                aid6= new JLabel(education);
                aid6.setBounds(200,420,300,30); 
                aid6.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid6);


                id7= new JLabel("Job Post:");
                id7.setBounds(50,470,100,30);
                id7.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id7);

                aid7= new JLabel(post);
                aid7.setBounds(200,470,300,30);
                aid7.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid7);

                id10= new JLabel("NID No:");
                id10.setBounds(50,520,100,30);
                id10.setFont(new Font("serif",Font.BOLD,20));
                id9.add(id10);

                aid10= new JLabel(nid);
                aid10.setBounds(200,520,300,30);
                aid10.setFont(new Font("serif",Font.BOLD,20));
                id9.add(aid10);


                b1=new JButton("Print");
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
                b1.setBounds(100,580,100,30);
                b1.addActionListener(this);
                id9.add(b1);

                b2=new JButton("Cancel");
                b2.setBackground(Color.BLACK);
                b2.setForeground(Color.WHITE);
                b2.setBounds(250,580,100,30);
                b2.addActionListener(this);
                id9.add(b2);

                textarea = new JTextArea();
                textarea.setBounds(400, 200, 400, 400);
                textarea.setFont(new Font("serif",Font.BOLD,20));

                textarea.setText("                   ========================        \n");
                textarea.setText(textarea.getText()+"                           Employee Information                \n");
                textarea.setText(textarea.getText()+"                   ========================        \n\n\n");
                textarea.setText(textarea.getText()+"             Employee ID:                 "+e_id+"\n\n");
                textarea.setText(textarea.getText()+"             Name:                             "+fullName+"\n\n");
                textarea.setText(textarea.getText()+"             Date of Birth:                "+dob+"\n\n");
                textarea.setText(textarea.getText()+"             Age:                                "+age+"\n\n");
                textarea.setText(textarea.getText()+"             Address:                         "+address+"\n\n");
                textarea.setText(textarea.getText()+"             Phone:                            "+phone+"\n\n");
                textarea.setText(textarea.getText()+"             Email:                             "+email+"\n\n");
                textarea.setText(textarea.getText()+"             Education:                      "+education+"\n\n");
                textarea.setText(textarea.getText()+"             Job Post:                         "+post+"\n\n");
                textarea.setText(textarea.getText()+"             NID no:                           "+nid);       
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                if(textarea.print()){
                    JOptionPane.showMessageDialog(null,"Printed Successfully");
                    f.setVisible(false);
                    Details d=new Details();
                }else {
                    JOptionPane.showMessageDialog(null,"Printing Stopped!");
                }
            } catch (PrinterException ex) {
                Logger.getLogger(PrintData.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            new ViewEmployee();
        }
    }
    
    public static void main(String[] arg){
        PrintData p = new PrintData("Print Data");
    }
    
}
