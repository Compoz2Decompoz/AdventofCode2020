/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */
public class AdventCode5 {
    
    
    
    private static int findRow(String RowStr){
        int minseat = 1;
        int maxseat = 128;
        int numrows = 128;
        char curdir = ' ';
        
        
      for (char dir : RowStr.toCharArray()){
          curdir = dir;
          int halfrows = numrows/2;
          numrows-=halfrows;
          if (dir == 'B'){
              minseat+=halfrows;
          }
          else 
              maxseat-=halfrows;
              
     }
        
      if(curdir=='B')  
        return maxseat-1;
      else
          return minseat-1;
    };
    
    private static int findCol(String ColStr){
        int minseat = 1;
        int maxseat = 8;
        int numrows = 8;
        
        char curdir = ' ';
      for (char dir : ColStr.toCharArray()){
          curdir = dir;
          int halfrows = numrows/2;
          numrows-=halfrows;
          if (dir == 'R')
              minseat+=halfrows;
          else 
              maxseat-=halfrows;
              
     }
      if(curdir=='R')  
        return maxseat-1;
      else
          return minseat-1;
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
                //read file
        String temp;
        List<String> Entries = new LinkedList();
        int highSeatID = 0;
        boolean[] PlaneSeats = new boolean[1024];
        
        for(int x = 0; x < 1024; x++)
            PlaneSeats[x] = false;
        
        BufferedReader input = 
            new BufferedReader(
                new FileReader("test/input.txt"));

        while((temp=input.readLine())!=null)
            Entries.add(temp);
            
        for(String Ticket : Entries ){
            int row = findRow(Ticket.substring(0,7));
            int col = findCol(Ticket.substring(7));
            System.out.println(row+" " + col);
            int tempID = row*8+col;
            PlaneSeats[tempID] = true;
            if (tempID > highSeatID)
                highSeatID = tempID;
            
            
            
        }
        for(int x = 0; x < 1024; x++)
            if(PlaneSeats[x] == false){
                System.out.println("--------------");
                System.out.println(x-1);
                System.out.println(x);
                System.out.println(x+1);
            }
    }   
    
}
