package tavel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotels extends JFrame implements ActionListener{
    JButton back;
    ViewBookedHotels(String username){
        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel ("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(60,0,400,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(Color.RED);
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblhotelname=new JLabel("Hotel Name");
        lblhotelname.setBounds(30,90,150,25);
        add(lblhotelname);
        
        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        JLabel lblpersons=new JLabel("Total Persons");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);
        
        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        JLabel lblac=new JLabel("AC / NON-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);
        
        JLabel lblfood=new JLabel("Food Included ? ");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);
        
        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);
        
        JLabel lblID=new JLabel("ID");
        lblID.setBounds(30,290,150,25);
        add(lblID);
        
        JLabel labelID=new JLabel();
        labelID.setBounds(220,290,150,25);
        add(labelID);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,330,150,25);
        add(lblnumber);
        
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone No");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);
        
        JLabel lblprice=new JLabel("TotalCost");
        lblprice.setBounds(30,410,150,25);
        add(lblprice);
        
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,16));
        back.setBounds(130,460,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(430,60,500,400); 
        add(image);
        
        try{
            conn c=new conn();
            String query="select * from bookhotel where username='"+username+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("name"));
                labelID.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
     
    
    public void actionPerformed(ActionEvent ae){
            setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewBookedHotels("souvik");
    }
}
