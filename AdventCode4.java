/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventcode4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hopki
 */
public class AdventCode4 {

    /**
     * @param args the command line arguments
     */
    private static boolean checkBYR(String byr){
        //System.out.println("BYR: " + byr);
        if (byr.length() == 4){
            if (Integer.parseInt(byr) >= 1920 && Integer.parseInt(byr) <= 2002)
                return true;}
        
        return false;
    };

    private static boolean checkIYR(String iyr){
        //System.out.println("IYR: " + iyr);
        if (iyr.length() == 4){
            if (Integer.parseInt(iyr) >= 2010 && Integer.parseInt(iyr) <= 2020)
                return true;
                        
        }
        return false;
    };    

    private static boolean checkEYR(String eyr){
        //System.out.println("EYR: " + eyr);
        if (eyr.length() == 4){
            if (Integer.parseInt(eyr) >= 2020 && Integer.parseInt(eyr) <= 2030)
                return true;
        }
        return false;
    };    

    private static boolean checkHGT(String hgt){
        //System.out.println("HGT: " + hgt);
        int hgnum = Integer.parseInt( hgt.replaceAll("\\D+",""));
        if(hgt.contains("in"))
            if (hgnum >= 59 && hgnum <= 76)
                return true;
        if(hgt.contains("cm"))
            if (hgnum >=150  && hgnum <= 193)
                return true;
        return false;
    };    

    private static boolean checkHCL(String hcl){
        //System.out.println("HCL: " + hcl);
        if(hcl.charAt(0)=='#')
            if (hcl.substring(1).length()==6)
                if (hcl.substring(1).matches("[a-zA-Z0-9]*"))
                    return true;
        return false;
    };    

    private static boolean checkECL(String ecl){
        //System.out.println("ECL: " + ecl);
        String[] goodcols = {"amb","blu","brn","gry","grn","hzl","oth"};
        for (String col : goodcols)
            if(ecl.equals(col))
                return true;
        return false;
    };    

    private static boolean checkPID(String pid){
        System.out.println("PID: " + pid);
        if(pid.matches("[0-9]*") && pid.length() == 9)
            return true;
        return false;
    };

    private static String extractVal(String input, String val){
        String endval = "";
        String[] Splitup = input.split(" ");
        for (String subspl : Splitup)
            if (subspl.contains(val)){
                endval = subspl.split(":")[1];
            }
        return endval;
                

    };

    public static void main(String[] args) throws IOException {

        //initialize variables
        String temp;
        boolean[] pins = {false,false,false,false,false,false,false};
        List<String> Entries = new LinkedList();
        int index = 0;
        String iline = "";
        int goodPassports=0;

        //read file
        BufferedReader input = 
            new BufferedReader(
                new FileReader("test/input.txt"));




        //byr,iyr,eyr,hgt,hcl,ecl,pid
        while((temp=input.readLine())!=null){
            Entries.add(temp);
        }


        iline = Entries.get(index);


        do{
            do{
                
                

                if(iline.contains("byr:"))
                    pins[0]=checkBYR(extractVal(iline,"byr"));
                if(iline.contains("iyr:"))
                    pins[1]=checkIYR(extractVal(iline,"iyr"));
                if(iline.contains("eyr:"))
                    pins[2]=checkEYR(extractVal(iline,"eyr"));
                if(iline.contains("hgt:"))
                    pins[3]=checkHGT(extractVal(iline,"hgt"));
                if(iline.contains("hcl:"))
                    pins[4]=checkHCL(extractVal(iline,"hcl"));
                if(iline.contains("ecl:"))
                    pins[5]=checkECL(extractVal(iline,"ecl"));
                if(iline.contains("pid:"))
                    pins[6]=checkPID(extractVal(iline,"pid"));
                index++;
                if(index < Entries.size())
                    iline = Entries.get(index);
            }while(!iline.isEmpty()&&index < Entries.size());
            boolean test = true;
            for (int i=0; i < pins.length; i++ )
            {
                if( pins[i]==false )
                        test = false;
            }
            if (test==true)
                goodPassports++;
            index++;
            for (int i=0; i < pins.length; i++ )
                pins[i]=false;
            if(index <= Entries.size())
                iline = Entries.get(index);
        }
        while(index<=Entries.size());
        
        System.out.println(goodPassports);
        System.out.println(Entries.size());
    }




}
