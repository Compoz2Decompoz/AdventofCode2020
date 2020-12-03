/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */

class IntCompare implements Comparator<Integer>
{  
    @Override
    public int compare(Integer num1, Integer num2) 
    {
        if(num1==num2)  
        return 0;  
        else if(num1>num2)  
        return 1;  
        else  
        return -1;  
    }  
}    
public class AdventCode1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = 
                new BufferedReader(
                    new FileReader("test/input.txt"));
        
        
        List<Integer> Entries = new LinkedList();
        String temp;
        while((temp=input.readLine())!=null){
            Entries.add(Integer.parseInt(temp));
        }
                    
        Entries.sort(new IntCompare());
        
        int MaxLine = Entries.size()-1;
        int MinLine = 0;
        
        System.out.println("FirstLine "+MinLine+" Value " +Entries.get(MinLine));
        System.out.println("LastLine "+MaxLine+" Value " +Entries.get(MaxLine));
        
        int Sum = 0;
        
        for (int x = 0; x < Entries.size();x++)
            for (int y = x+1; y < Entries.size();y++)
                for (int z = Entries.size()-1; z > y; z--){
                    Sum = Entries.get(x)+Entries.get(y)+Entries.get(z);
                    if (Sum == 2020){
                        System.out.println(Sum);
                        System.out.println("Numbers " + Entries.get(x)+Entries.get(y)+Entries.get(z));
                        int Product = Entries.get(x)*Entries.get(y)*Entries.get(z);
                        System.out.println(Product);
                        break;
                    }
                  
                }

        input.close();
}
}
