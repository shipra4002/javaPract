<%-- 
    Document   : Login
    Created on : 12 Jul, 2024, 12:43:03 PM
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
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement pat=con.prepareStatement("SELECT * FROM register_28  WHERE username=?");
            pat.setString(1, s1);
            ResultSet rs=pat.executeQuery();
            if(rs.next()){
                if(rs.getString(2).equals(s2)){
                    out.print("Login successful.....");
                }else{
                    out.print("Wrong password!!! Login failed.....");
                    %>
                    <jsp:include page="Login.html"></jsp:include>
                    <%
                }
            }else{
                out.print("Username does not exists....Please register!!!");
                %>
                    <jsp:include page="Register.html"></jsp:include>
                <%
            }
            
        }catch(Exception e){
            out.write("Exception: " +e);
        }
        %>
    </body>
</html>
