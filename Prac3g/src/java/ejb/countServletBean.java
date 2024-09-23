/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Singleton;

/**
 *
 * @author Admin
 */
@Singleton
public class countServletBean {
     private int hitcount;
        public synchronized int incrementAndGetHitCount(){
            return hitcount++;
        }
}
