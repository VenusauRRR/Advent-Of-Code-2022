package Day3_rucksackReorganization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RucksackReorganization {
     public static void main(String[] args) throws Exception {
          BufferedReader dataIn = new BufferedReader(new FileReader("src/Day3_rucksackReorganization/RucksackReorganization.txt"));
          String st = "";
          char commonLetter = ' ';
          int commonLetterScore = 0;
          int sum = 0;


          do{
          st = dataIn.readLine();
          commonLetter = findCommonCharacter(st);
          commonLetterScore = findPriorityScore(commonLetter);
          sum += commonLetterScore;


          }while(dataIn.ready());

          System.out.println(sum);
     }

     public static char findCommonCharacter(String st) {
          ArrayList<Character> c1 = new ArrayList<Character>();
          ArrayList<Character> c2 = new ArrayList<Character>();

          for (int i = 0; i < st.length() / 2; i++) {
               c1.add(st.charAt(i));
          }

          for (int i = st.length() / 2; i < st.length(); i++) {
               c2.add(st.charAt(i));
          }

          c2.retainAll(c1);

          return c2.get(0);
     }

     public static int findPriorityScore(char letter) {
          String lowercase = "abcdefghijklmnopqrstuvwxyz";
          String alfabet = lowercase + lowercase.toUpperCase();

          int letterIndex = alfabet.indexOf(letter);

          return letterIndex+1;

     }

}
