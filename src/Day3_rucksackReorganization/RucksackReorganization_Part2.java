package Day3_rucksackReorganization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RucksackReorganization_Part2 {
     public static void main(String[] args) throws Exception {
          BufferedReader dataIn = new BufferedReader(new FileReader("src/Day3_rucksackReorganization/RucksackReorganization.txt"));
          String st = "";
          String[] badgeGroup = new String[3];
          char commonLetter = ' ';
          int commonLetterScore = 0;
          int sum = 0;
          int counter = 0;

          do {

               st = dataIn.readLine();
               badgeGroup[counter] = st;
               counter++;

               if (counter % 3 == 0) {
                    commonLetter = findCommonCharacter(badgeGroup);
                    commonLetterScore = findPriorityScore(commonLetter);
                    sum += commonLetterScore;
                    counter = 0;
               }

          } while (dataIn.ready());

          System.out.println(sum);
     }

     public static char findCommonCharacter(String[] st) {
          ArrayList<Character> c1 = new ArrayList<Character>();
          ArrayList<Character> c2 = new ArrayList<Character>();
          ArrayList<Character> c3 = new ArrayList<Character>();

          for (int i = 0; i < st[0].length(); i++) {
               c1.add(st[0].charAt(i));
          }

          for (int i = 0; i < st[1].length(); i++) {
               c2.add(st[1].charAt(i));
          }

          for (int i = 0; i < st[2].length(); i++) {
               c3.add(st[2].charAt(i));
          }
          c2.retainAll(c1);

          c3.retainAll(c2);

          return c3.get(0);
     }

     public static int findPriorityScore(char letter) {
          String lowercase = "abcdefghijklmnopqrstuvwxyz";
          String alfabet = lowercase + lowercase.toUpperCase();

          int letterIndex = alfabet.indexOf(letter);

          return letterIndex + 1;

     }

}
