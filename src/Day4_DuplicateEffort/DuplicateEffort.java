package Day4_DuplicateEffort;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DuplicateEffort {
    ArrayList<String> assigmentPair;

    public DuplicateEffort(){
        assigmentPair = new ArrayList<>();
    }

    public DuplicateEffort(Path p){
        assigmentPair = new ArrayList<>();
        readFromFile(p);
    }
    public void readFromFile(Path p){
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String st;
            while ((st = br.readLine()) != null) {
                assigmentPair.add(st);
            }
        }catch (IOException e){
            System.out.println("wrong input path");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAssigmentPair() {
        return assigmentPair;
    }
    public int[] parseStringToIntegerArray(String stringArray){
        String[] temp = stringArray.split(",");
        String[] st1 = temp[0].split("-");
        String[] st2 = temp[1].split("-");
        return new int[]{Integer.parseInt(st1[0]),Integer.parseInt(st1[1]),
                Integer.parseInt(st2[0]),Integer.parseInt(st2[1])};
    }

    public boolean ifPairFullyDuplicate(String st){
        int[] pair = parseStringToIntegerArray(st);
        boolean compareFirstDigit = pair[0]>pair[2] ? true : false;
        boolean compareSecondDigit = pair[1]>pair[3] ? true : false;
        if (pair[0]==pair[2] || pair[1]==pair[3]){
            return true;
        } else if (compareFirstDigit == true && compareSecondDigit == true){
            return false;
        } else if (compareFirstDigit == false && compareSecondDigit == false){
            return false;
        }
        return true;
    }

    public int countFullyDuplicatePair(ArrayList<String> list){
        int counter = 0;
        for (String st : list){
            if (ifPairFullyDuplicate(st)){
                counter++;
            }
        }
        return counter;
    }

    public boolean isAnyNotDuplicatePair(String st){
        int[] pair = parseStringToIntegerArray(st);
        if (pair[2]>pair[1] || pair[0]>pair[3]){
            return true;
        }
        return false;
    }

    public int countDuplicatePair(ArrayList<String> list){
        int count = 0;
        for (String s : list){
            if (!isAnyNotDuplicatePair(s)){
                count++;
            }
        }
        return count;
    }



}//class
