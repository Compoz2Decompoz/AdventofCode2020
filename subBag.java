/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode7;

/**
 *
 * @author hopki
 */
public class subBag {
    
    public String bagColour = "";
    public int bagNumber = 0;
    
    public subBag(String col, int num){
        bagColour = col;
        bagNumber = num;
    }
    
    public int getBagNum(){
        return bagNumber;
    }
    
    public String getBagCol(){
        return bagColour;
    }       
    
}
