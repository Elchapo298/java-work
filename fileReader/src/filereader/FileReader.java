/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filereader;

import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author Wandi Mtshali
 */
public class FileReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        File file = new File("C:\\Users\\Wandi Mtshali\\Desktop//regstats.txt");
        
        FileReader fileReader = new FileReader( file);
        BufferedReader brr = new BufferedReader();
        
    }
    
}
