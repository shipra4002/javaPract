/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.sql.*;
import javax.ejb.Stateful;

/**
 *
 * @author Admin
 */
@Stateful
public class RRBean {
    public RRBean(){
        
    }
    public String roombooking(String cn, String cm, String rt){
        String message="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root"); 
            String query="select * from roombook28 where roomtype=? and statusroom='not booked'";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,rt);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                String rno=rs.getString(1);
                PreparedStatement psmt1=con.prepareStatement("update roombook28 set cust=? where roomid=?");
                psmt1.setString(1,cn);
                psmt1.setString(2, rno);
                psmt1.executeUpdate();
                
                psmt1=con.prepareStatement("update roombook28 set mob=? where roomid=?");
                psmt1.setString(1,cm);
                psmt1.setString(2, rno);
                psmt1.executeUpdate();
                
                psmt1=con.prepareStatement("update roombook28 set statusroom=? where roomid=?");
                psmt1.setString(1,"Booked");
                psmt1.setString(2, rno);
                psmt1.executeUpdate();
                
                message= "Room "+rno+" Booked and Charges = "+rs.getString(3);
            }else{
                message="Room "+rt+" currently not avialable";
            }
        }catch(Exception e){
            message=""+e;
        }
        return message;
    }
}
