/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPack;

/**
 *
 * @author Admin
 */
public class CheckerBean {
    String name,age,hobby,mail,gender,error;
    public void CheckerBean(){
        error="";
    }
    public void setName(String n){
        name=n;
    }
    public void setAge(String a){
        age=a;
    }
    public void setHobby(String hob){
       hobby=hob;
    }
    public void setMail(String m){
        mail=m;
    }
    public void setGender(String g){
        gender=g;
    }
    public void setError(String e){
        error=e;
    }
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getHobby(){
        return hobby;
    }
    public String getMail(){
        return mail;
    }
    public String getGender(){
        return gender;
    }
    public String getError(){
        return error;
    }
    public boolean validate(){
        boolean res=true;
        if(name.trim().equals("") || (name==null))
        {
            error+="<br>Enter first name";
        }
        if(age.length()>2 || (age==null)){
            error+="<br>Invalid age! ";
            res=false;
        }
        return res;
    }
}
