/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author HopkD1
 */
public class AdventofCode15 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws IOException {
    
    Integer[] initValues={18,11,9,0,5,1};
    //Integer[] initValues={0,3,6};
    //Integer[] initValues={2,1,3};
    
    int myTurn = 0;
    List<Integer> numspoken = new ArrayList();
    
    List<Integer> usedNums = new ArrayList();
    List<Integer> usedtwice = new ArrayList();
    int currval = 0;
    
    

        
        for (int i = 0; i < initValues.length; i++){
            myTurn++;
            numspoken.add(initValues[i]);
            usedNums.add(initValues[i]);
            System.out.println("turn: " + i + " value: " +  numspoken.get(i));

        }
        System.out.println("------------------------------------");
       
        
        for(int i = myTurn; i<30000000; i++){
            currval = numspoken.get(numspoken.size()-1);
            
            
            if(Collections.binarySearch(usedtwice, currval) >= 0){
                //then find the previous 2 usages and subtract one from the other
                //currval = numspoken.get(numspoken.size()-1);
                int last = numspoken.size()-1;
                int prev = numspoken.subList(0, numspoken.size()-1).lastIndexOf(currval);

                
                numspoken.add(last-prev);
                currval = numspoken.get(numspoken.size()-1);
                if(Collections.binarySearch(usedNums, currval)>=0){
                    if(Collections.binarySearch(usedtwice, currval)<0){
                        usedtwice.add(currval);
                        Collections.sort(usedtwice);
                    }
                }
                else{
                    usedNums.add(currval);
                    Collections.sort(usedNums);
                }
                        
                        
            }
            else {
                numspoken.add(0);
                if(usedtwice.contains(0))
                {}
                else if(usedNums.contains(0)){
                    usedtwice.add(0);
                    Collections.sort(usedtwice);
                } else{
                    usedNums.add(0);
                    Collections.sort(usedNums);
                }
            }

           // System.out.println("turn: " + i + " value: " + numspoken.get(i));
           if(i%10000==0)
               System.out.println(i);
        }
                

        
        
            
       System.out.println(numspoken.get(numspoken.size()-1)) ;    
            
    }
    
}
