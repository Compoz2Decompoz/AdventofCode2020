/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */



public class AdventCode7 {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) throws IOException {
            
            
            BufferedReader input = 
                    new BufferedReader(
                        new FileReader("test/input.txt"));



            List<myBag> allBags = new LinkedList();
            String bagColour = "";
            int shinyGold = 0;
            
            String temp;
            while((temp=input.readLine())!=null){
                bagColour = temp.substring(0,temp.indexOf("bags")-1);
                myBag tempBag = new myBag(bagColour);
                String containedBags = temp.substring(temp.indexOf("contain")+8, temp.indexOf('.'));
                //System.out.println(containedBags);
                if (containedBags.contains("no other bags"))
                {
                    //do nothing
                }
                else
                {
                    String[] bags = containedBags.split(", ");
                    for (String bag : bags){
                        int numbags = Integer.parseInt(bag.substring(0, bag.indexOf(' ')));
                        String bagColourlcl = bag.substring(2,bag.indexOf(" bag"));
                        for(int i = 0; i < 1; i++)
                            tempBag.insertBag(bagColourlcl,numbags);
                        //System.out.println(numbags + " " + bagColourlcl);
                    }
                        
                }
                allBags.add(tempBag);
            }
            
            System.out.println(allBags.get(0).bagColour);
            System.out.println(allBags.get(1).bagColour);
            System.out.println(allBags.get(allBags.size()-2).bagColour);
            System.out.println(allBags.get(allBags.size()-1).bagColour);
            myBag tempBag2 = new myBag("awful green");
//            for(myBag tempBag : allBags){
//                //if (tempBag.bagColour.contentEquals("clear gold"))
//                    tempBag2 = tempBag;
//            
//            
//            
//                //System.out.println("Scanning " + tempBag2.bagColour);
//                if (tempBag2.findshinygold(allBags, tempBag2.bagColour)){
//                    System.out.println("found " + tempBag2.bagColour);
//                
//                    shinyGold++;
//                }
//            }
//            
//            System.out.println(shinyGold);
            
            for(myBag tempBag : allBags){
                if (tempBag.bagColour.contentEquals("shiny gold")){
                    tempBag2 = tempBag;
                    break;
                }
            }

//            for(myBag tempBag : allBags){
//                if (tempBag.bagColour.contentEquals("vibrant olive"))
//                    tempBag2 = tempBag;
//            }
            
            System.out.println("Bags in " + tempBag2.bagColour + " = " + tempBag2.findBagsIn(allBags));
    }
    
}
