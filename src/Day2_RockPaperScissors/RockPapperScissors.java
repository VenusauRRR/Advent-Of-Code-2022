package Day2_RockPaperScissors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RockPapperScissors {
     public static void main(String[] args) throws Exception {
          BufferedReader dataIn = new BufferedReader(new FileReader("src/Day2_RockPaperScissors/RockPapperScissors_input.txt"));
          ArrayList<Integer> game = new ArrayList<Integer>();
          char[] roundResult = new char[2];
          String st = "";
          int roundScore = 0;

          do {
               st = dataIn.readLine();
               roundResult[0] = st.charAt(0); // opponent choice
               roundResult[1] = st.charAt(2); // your choice
               roundScore = calculateScore(roundResult);
//               System.out.println("The round result is "+roundScore);
               game.add(roundScore);
          } while (dataIn.ready());

          int sum = 0;
          for (int score : game) {
               sum += score;
          }
          System.out.println(sum);

     }

     public static int calculateScore(char[] roundResult) {
          int yourScore = -1;
          int opponentScore = -1;

          switch (roundResult[0]) {
               case 'A':
                    opponentScore = 1;
                    break; // A = Rock, 1 point
               case 'B':
                    opponentScore = 2;
                    break; // B = paper, 2 point
               case 'C':
                    opponentScore = 3;
                    break; // C = scissors, 3 point
               default:
                    break;
          }
          switch (roundResult[1]) {
               case 'X':
                    yourScore = 1;
                    break; // X = Rock, 1 point
               case 'Y':
                    yourScore = 2;
                    break;// Y = paper, 2 points
               case 'Z':
                    yourScore = 3;
                    break;// Z = scissors, 3 points
               default:
                    break;

          }

          int scoreDifference = yourScore - opponentScore;
          int resultScore = -1;

          switch (scoreDifference) {
               case 1:
                    resultScore = 6;
                    break;
               case -1:
                    resultScore = 0;
                    break;
               case 2:
                    resultScore = 0;
                    break;
               case -2:
                    resultScore = 6;
                    break;
               case 0:
                    resultScore = 3;
                    break;
               default:
                    break;
          }

          return yourScore + resultScore;
     }
}
