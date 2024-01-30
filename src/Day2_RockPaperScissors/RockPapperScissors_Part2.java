package Day2_RockPaperScissors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RockPapperScissors_Part2 {
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
               roundScore = calculateScore(newRoundResult(roundResult));
//               System.out.println("The round result is " + roundScore);
               game.add(roundScore);
          } while (dataIn.ready());

          int sum = 0;
          for (int score : game) {
               sum += score;
          }
          System.out.println(sum);

     }

     public static int calculateScore(char[] roundResult) {
          int yourScore = identifyScore(roundResult[1]);
          int opponentScore = identifyScore(roundResult[0]);

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

     public static int identifyScore(char choice) {
          int choiceScore = -1;
          switch (choice) {
               case 'X':
                    return 1;// X = Rock, 1 point
               case 'Y':
                    return 2;// Y = paper, 2 points
               case 'Z':
                    return 3;// Z = scissors, 3 points

               case 'A':
                    return 1;// A = Rock, 1 point
               case 'B':
                    return 2;// B = paper, 2 point
               case 'C':
                    return 3;// C = scissors, 3 point
               default:
                    return choiceScore;
          }
     }

     public static char[] newRoundResult(char[] oldRoundResult) {
          int opponentScore = identifyScore(oldRoundResult[0]);
          char newYourChoice = ' ';

          switch (oldRoundResult[1]) {
               case 'X':
                    newYourChoice = yourChoiceToLose(opponentScore);
                    break;
               case 'Y':
                    newYourChoice = yourChoiceToDraw(opponentScore);
                    break;
               case 'Z':
                    newYourChoice = yourChoiceToWin(opponentScore);
                    break;
               default:
                    break;
          }

          return new char[] { oldRoundResult[0], newYourChoice };
     }

     public static char yourChoiceToLose(int opponentScore) {
          if ((opponentScore - 1) == 1) {
               return 'X'; // Rock
          } else if ((opponentScore - 1) == 2) {
               return 'Y'; // paper
          } else {
               return 'Z'; // scissors
          }
     }

     public static char yourChoiceToDraw(int opponentScore) {
          if (opponentScore == 1) {
               return 'X';
          } else if (opponentScore == 2) {
               return 'Y';
          } else {
               return 'Z';
          }
     }

     public static char yourChoiceToWin(int opponentScore) {
          if ((opponentScore + 1) == 2) {
               return 'Y';// paper
          } else if ((opponentScore + 1) == 3) {
               return 'Z';// scissors
          } else {
               return 'X';// rock
          }
     }
}
