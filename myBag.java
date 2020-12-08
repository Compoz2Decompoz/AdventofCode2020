/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode7;


import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author hopki
 */
public class myBag {
    String bagColour = "";
    
    List<subBag> containedBags = new LinkedList();
    
    long bagsInBag = 0;
    
    public myBag(String Colour){
            bagColour = Colour;
    }
    
    public myBag(){
        bagColour = "";
    }
    
    public void outputBag(){
        System.out.println("The Bag Colour is " + bagColour);
    }
    
    public void insertBag(String bag, int numbag){
        subBag tempsub = new subBag(bag,numbag);
        containedBags.add(tempsub);        
    }
    
    public void outputinBags(){
        for(subBag inBag : containedBags)
            System.out.println(inBag.getBagCol() + " " + inBag.getBagNum());
    }
    
    public boolean findshinygold(List<myBag> allBags, String parentCol){
        if(parentCol.contentEquals("shiny gold"))
            return true;
        else{
            for (subBag conBag : containedBags)
                for (myBag objBag : allBags){
                    if (conBag.getBagCol().contentEquals(objBag.bagColour))
                        if(objBag.findshinygold(allBags, objBag.bagColour))
                            return true;
                }
        }
        return false;
    }
    
    public long findBagsIn(List<myBag> allBags){
        bagsInBag = 0;
        myBag tempBag2 = new myBag();
        if(containedBags.isEmpty())
            return 0;
        else 
            for(subBag myBaggy : containedBags){
                bagsInBag+=myBaggy.bagNumber;
                //now find the details for each contained bag
                for(myBag tempBag : allBags)
                    if (tempBag.bagColour.contentEquals(myBaggy.getBagCol())){
                        tempBag2 = tempBag;
                        break;
                    }
                bagsInBag+=(tempBag2.findBagsIn(allBags)*myBaggy.bagNumber);
       
            }
           System.out.println(this.bagColour + " " + bagsInBag);
          return bagsInBag;      
    }
            
    
}
