/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class CCBean {
    //default constructor
    public double rupees_dollar(double a){
        return a/83.96;
    }
    public double rupees_euro(double b){
        return b/91.70;
    }
    public double rupees_dinar(double c){
        return c/274.78;
    }
}
