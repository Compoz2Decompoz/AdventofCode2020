/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode2;

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
public class AdventCode2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = 
                new BufferedReader(
                    new FileReader("test/input2.txt"));
        
        
        List<String> Entries = new LinkedList();
        String temp;
        while((temp=input.readLine())!=null){
            Entries.add(temp);
        }
                    
        
        int MaxLine = Entries.size()-1;
        int MinLine = 0;
        
        int ValidPass = 0;
        
        System.out.println("FirstLine "+MinLine+" Value " +Entries.get(MinLine));
        System.out.println("LastLine "+MaxLine+" Value " +Entries.get(MaxLine));
        
        for (String str : Entries){
            int DashAt = str.indexOf('-');
            int SpaceAt = str.indexOf(' ');
            int MinVals = Integer.parseInt(str.substring(0,DashAt));
            int MaxVals = Integer.parseInt(str.substring(DashAt+1, SpaceAt));
            char testchar = str.charAt(SpaceAt+1);
            String password = str.substring(SpaceAt+4);
            int countChars=0;
            System.out.println(MinVals+" "+MaxVals+" "+testchar+" "+password);
//            for (int i=0; i < password.length(); i++)
//                if (password.charAt(i) == testchar)
//                    countChars++;
//            if (countChars >= MinVals && countChars <= MaxVals)
//                ValidPass++;

        if(password.charAt(MinVals-1)==testchar^password.charAt(MaxVals-1)==testchar)
            ValidPass++;
        
        }
                    
        System.out.println(ValidPass);

        input.close();
    }
    
}
