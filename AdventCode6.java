/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */
public class AdventCode6 {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws IOException {
            
            int index = 0;
            int sumYes = 0;
            boolean groupYes = true;
            String checklist = "";
            
            List<String> GroupAnswers = new LinkedList();
            
            BufferedReader input = 
                    new BufferedReader(
                        new FileReader("test/input.txt"));


            List<String> Entries = new LinkedList();
            String temp;
            while((temp=input.readLine())!=null){
                Entries.add(temp);
            }
            
            String iline = Entries.get(index);//get first line
            
            do{
                do{
                    //check if character is already in list
                    GroupAnswers.add(iline);
                    
                    index++;
                    if(index < Entries.size())
                        iline = Entries.get(index);
                }while(!iline.isEmpty()&&index < Entries.size());
                if (GroupAnswers.size() == 1)
                    sumYes+=GroupAnswers.get(0).length();
                else
                    for(int i = 0; i < GroupAnswers.get(0).length(); i++){
                        for(int j = 1; j < GroupAnswers.size(); j++)
                            if(!GroupAnswers.get(j).contains(String.valueOf(GroupAnswers.get(0).charAt(i))))
                                groupYes=false;
                        if (groupYes==true)
                        sumYes++;
                        groupYes = true;
                    }
                index++;
                checklist = "";
                GroupAnswers.clear();
                if(index <= Entries.size())
                    iline = Entries.get(index);
            }
            while(index<=Entries.size());
            System.out.println(sumYes);
        }
        
    
}
