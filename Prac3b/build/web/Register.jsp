<%-- 
    Document   : Register
    Created on : 12 Jul, 2024, 12:42:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String s1 = request.getParameter("uname");
            String s2 = request.getParameter("psw");
            String s3 = request.getParameter("repsw");
            String s4 = request.getParameter("email");
            String s5 = request.getParameter("country");
            
            if(s2.equals(s3))
            {
               //database connectivity code
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                    PreparedStatement pat=con.prepareStatement("INSERT INTO register_28  values(?,?,?,?)");
                    pat.setString(1, s1);
                    pat.setString(2, s2);
                    pat.setString(3, s4);
                    pat.setString(4, s5);
                    int rows = pat.executeUpdate();
                    if (rows==1)
                    {
                        out.println("Registration successful....!");
                    }else{
                        out.println("Registration failed..! Try again");
        %>
            <jsp:include page="Register.html"></jsp:include>
        <%
                    }   
                }catch(Exception e){
                    out.write("Exception: " +e);
                }
            }else{
                out.println("Password mismatch....!  ReEnter all information once again");
        %>
            <jsp:include page="Register.html"></jsp:include>
        <%
            }
        %>
    </body>
</html>
