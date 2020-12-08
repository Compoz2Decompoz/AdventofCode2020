/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author hopki
 */
public class AdventCode8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //initialize variables
        String temp = "";
        List<Command> CommandList = new LinkedList();
        int accum = 0;
        int index = 0;
        int error = 0;
        int trackswitch = 0;
        boolean complete = false;
        int commnumber = 0;
        Iterator<Command> iter = CommandList.iterator();


        //read file
        BufferedReader input = 
            new BufferedReader(
                new FileReader("test/input.txt"));


        while((temp=input.readLine())!=null){
            Command tempcom = new Command(temp.substring(0,3),Integer.parseInt(temp.substring(4)));
            CommandList.add(tempcom);
            //System.out.println(tempcom.getCommand() + " " + tempcom.getDetail());           
        }
        
        System.out.println(CommandList.get(CommandList.size()-1).getCommand());
        
        while(index < CommandList.size()-1 && trackswitch < CommandList.size())
        {
            index = 0;
            commnumber = 0;
            accum=0;
            do{
                if(CommandList.get(index).getCommand().contentEquals("acc")){
                    accum+=CommandList.get(index).getDetail();
                    index++;
                }
                else{
                    if ((commnumber == trackswitch && CommandList.get(index).getCommand().contentEquals("nop")) || (commnumber != trackswitch && CommandList.get(index).getCommand().contentEquals("jmp") ))
                            index+=CommandList.get(index).getDetail();
                    else
                        index++;
                    //always increase commnumber for nop or jmp
                    commnumber++;
                }
                    
                

                
                System.out.println("track"+trackswitch+"comm"+commnumber);
                if (index > CommandList.size() || index < 0){
                    System.out.println("Index out of range");
                    error++;
                    break;
                }

            }while(CommandList.get(index).timesRun() == 0 && index != CommandList.size()-1);//run inside do until we repeat a command
            
            if(index == CommandList.size()-1){
                complete = true;
                break;
            }else{
            
            for (Command temp2 : CommandList)
                temp2.timesRun = 0;
            }
            trackswitch++;

            
        }//end while
        
        if(error==0 && complete == true)
            System.out.println(accum);
        else
            System.out.println("check ya code");
    }
    
    
    
    
}
