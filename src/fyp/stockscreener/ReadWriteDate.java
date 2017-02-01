/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

/**
 *
 * @author Lim
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadWriteDate {
    
    private String path;
    private boolean append_to_file = false;
    
    public static void WriteDate() {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        File f = new File("Date.txt");
        if (f.exists()){
            f.delete();
        }
        try {
            FileWriter writer = new FileWriter("Date.txt", true);
            
            Date date = new Date();
            writer.write(sdf.format(date));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String ReadDate(){
        
        String DateTime="";
        try {
            FileReader reader = new FileReader("Date.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                DateTime = line;
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DateTime;
    }
    
    public boolean CheckDate(){
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String FileWriteDate = ReadDate(); 
        
        int space = (FileWriteDate.indexOf(" ") >= 0) ? FileWriteDate.indexOf(" ") : FileWriteDate.length()-1;
        String WriteDate = FileWriteDate.substring(0,space);

        Date newDate = new Date();
        String CurrentDate = sdf.format(newDate);
        
        if(WriteDate.equals(CurrentDate)){
            return true;
        }
        else{
            return false;
        }
    }
}
