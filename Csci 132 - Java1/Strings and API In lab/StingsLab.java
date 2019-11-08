/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.System.console;
import static java.lang.System.out;
import java.util.Scanner;
/**
 *
 * @author Hunter
 */
public class StingsLab {
     public static int countVowels(String input)
     {
         String newString = input.replaceAll("[aeiou]", "");
    	 return input.length() - newString.length();
     }
     
     public static String[] returnEachWord(String input)
     {
    	 String[] words = input.split(" ");
    	 return words;
     }
     public static String removeWhiteSpace(String input)
     {
    	 String storage = "";
    	 for(Character location : input.toCharArray()) {
    		 if(Character.isWhitespace(location) != true) {
    			 storage += location;
    		 }
    	 }
    	 return storage;        
     }
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
    
        String answer = "yes";
        do{
           System.out.println("Give me a sentence you want to parse");
           String sentence = console.nextLine();
 //1.convert to lowercase
           System.out.println("");
           System.out.println("Number of vowels using count     = " + countVowels(sentence));
           String output[] = returnEachWord(sentence);
           for(String x : output)
                  System.out.println(x);
           System.out.println("String without spaces = |" + removeWhiteSpace(sentence) + "|");
           System.out.println("");
           System.out.println("Would you like to continue: ");
           answer = console.nextLine();
           
        System.out.println("");
      }while(answer.equals("yes"));  
   }
}