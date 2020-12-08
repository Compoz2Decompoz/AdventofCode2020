/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode8;

/**
 *
 * @author hopki
 */
public class Command {
    
    public String command = "";
    public int detail = 0;
    public int timesRun = 0;
    
    public Command(){
        command = "";
        detail = 0;
        timesRun = 0;
    }
    
    public Command(String com, int det){
        command = com;
        detail = det;
    }
    
    public String getCommand(){
        timesRun++;
        return command;
        
    }
    
    public int getDetail(){
        return detail;
    }
            
    public int timesRun(){
        return timesRun;
    }
    
}
