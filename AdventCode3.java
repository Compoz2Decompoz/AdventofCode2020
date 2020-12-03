/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */
public class AdventCode3 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws IOException {
        BufferedReader input = 
                new BufferedReader(
                    new FileReader("test/input.txt"));
        
        
        List<String> Entries = new LinkedList();
        String temp;
        while((temp=input.readLine())!=null){
            Entries.add(temp);
        }
        
        int[][] slopes = {{1,1},{3,1},{5,1},{7,1},{1,2}};
        
        int treeCount[] = {0,0,0,0,0};
        
        int lineLength = Entries.get(0).length();
        
        int linePlace = 0;//initialize line placement for the first time
        
        System.out.println(lineLength + "  " + Entries.size() + "   " + slopes.length);
        
        for (int j = 0; j < slopes.length; j++){
            System.out.println("Iteration" + j + " " + slopes[j][1]);
            for (int i = slopes[j][1]; i < Entries.size(); i+=slopes[j][1]){
                if (linePlace+slopes[j][0] < lineLength)
                    linePlace+=slopes[j][0];
                else
                    linePlace = linePlace-lineLength+slopes[j][0];
                //System.out.println(linePlace);
                if(Entries.get(i).charAt(linePlace)=='#')
                    treeCount[j]++;
            }
            linePlace = 0;
        }
        int product = 1;
        for(int j = 0; j<treeCount.length; j++){
            System.out.println(treeCount[j]);
            product=treeCount[j]*product;
        }
     System.out.println(product);       
    }
    
}
