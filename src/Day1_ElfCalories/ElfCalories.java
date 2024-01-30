package Day1_ElfCalories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * ElfCalories
 */
public class ElfCalories {

     private static final String Do = null;

     public static void main(String[] args) throws Exception {
          BufferedReader dataIn = new BufferedReader(new FileReader("src/Day1_ElfCalories/ElfCalories_input.txt"));
          String st = "";
          ArrayList<Integer> elfIntake = new ArrayList<Integer>();
          int i = 0;

          do{
          String s = dataIn.readLine();
          if (!s.isBlank()){
          int j = Integer.parseInt(s);
          i += j;
          }


          if (s.isBlank()){
               elfIntake.add(i);
               i=0;
               continue;
          }


          }while (dataIn.ready());
          
          Collections.sort(elfIntake, Collections.reverseOrder());

          int maxThreeElfIntake = 0;
          for (int j = 0; j < 3; j++) {
               maxThreeElfIntake += elfIntake.get(j);
          }
          System.out.println(maxThreeElfIntake);

     }
}