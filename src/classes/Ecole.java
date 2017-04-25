/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.util.*;
import java.sql.*;

/**
 *
 * @author Mickaël
 */
public class Ecole {
    
    List<Eleves>  listeEleves = new ArrayList<Eleves>();

    
    
        public  void AjouterEleve(Eleves e){
            
          this.listeEleves.add(e);
            
            
        }
            
    
}
