/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

/**
 *
 * @author Wandi Mtshali
 */
public class Question1 {

    public static void main(String[] args) {

        String words = "i love going out";
        String newWords = "";

        for (int i = words.length() -1; i >= 0; i--) {

            newWords += words.charAt(i);
            
            

            

        }System.out.print(newWords);

    }
}
