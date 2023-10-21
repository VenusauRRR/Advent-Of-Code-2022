package Day5_SupplyStacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SupplyStack {
    protected ArrayList<CrateStack> stackList;
    protected ArrayList<String> crateList;
    protected ArrayList<String> stepList;

    public SupplyStack(){
        this.stackList = new ArrayList<>();
        this.crateList = new ArrayList<>();
        this.stepList = new ArrayList<>();
    }

    public SupplyStack(ArrayList<String> crateList, ArrayList<String> stepList){
        this.crateList = new ArrayList<>(crateList);
        this.stepList = new ArrayList<>(stepList);
        this.stackList = new ArrayList<>();
    }

    public SupplyStack(Path p){
        this.stackList = new ArrayList<>();
        this.crateList = new ArrayList<>();
        this.stepList = new ArrayList<>();
        readFromFile(p);
    }

    public void readFromFile(Path p){
        try {
            BufferedReader br = Files.newBufferedReader(p);
            ArrayList<String> tempList = new ArrayList<>();
            String temp;
            int indexForEmptyRow = 0;
            while ((temp = br.readLine()) != null){
                tempList.add(temp);
            }
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals("")){
                    indexForEmptyRow = i;
                    break;
                }
            }
            this.crateList = new ArrayList<>(tempList.subList(0,indexForEmptyRow));
            this.stepList = new ArrayList<>(tempList.subList(indexForEmptyRow+1,tempList.size()));
        } catch (IOException e){
            System.out.println("invalid path");
            e.printStackTrace();
        }
    }//method

    public void moveCrateInStack(){
        ArrayList<CrateStack> tempCrate = rewrite2DArrayToArrayList(this.crateList);
        Step tempStep;
        char targetCrateToBeMoved;
        for (String i : this.stepList){
            tempStep = new Step(i);
            for (int j = 0; j < tempStep.getMovingCrateAmt(); j++) {
                targetCrateToBeMoved = tempCrate.get(tempStep.getOriginalStack()-1).getLastChar();
                tempCrate.get(tempStep.getTargetedStack()-1).addTargetChar(targetCrateToBeMoved);
                tempCrate.get(tempStep.getOriginalStack()-1).removeLastChar();
            }
        }
        setStackList(tempCrate);
    }

    public void moveCrateWithNewMachine(){
        ArrayList<CrateStack> tempCrate = rewrite2DArrayToArrayList(this.crateList);
        Step tempStep;
        char targetCrateToBeMoved;
        int indexPositionToBeMoved;
        for (String i : this.stepList){
            tempStep = new Step(i);
            indexPositionToBeMoved = tempCrate.get(tempStep.getOriginalStack()-1).getStack().size()-tempStep.getMovingCrateAmt();
            for (int j = 0; j < tempStep.getMovingCrateAmt(); j++) {
                targetCrateToBeMoved = tempCrate.get(tempStep.getOriginalStack()-1).getStack().get(indexPositionToBeMoved);
                tempCrate.get(tempStep.getTargetedStack()-1).addTargetChar(targetCrateToBeMoved);
                tempCrate.get(tempStep.getOriginalStack()-1).getStack().remove(indexPositionToBeMoved);
            }
        }
        setStackList(tempCrate);
    }



    public ArrayList<CrateStack> rewrite2DArrayToArrayList(ArrayList<String> st){
        char[][] stackIn2DArray = parseStackStringTo2DArray(st);
        int row = stackIn2DArray.length;
        int column = stackIn2DArray[0].length;
        CrateStack temp = new CrateStack();
        for (int i = 0; i < column; i++) {
            for (int j = row-1; j >= 0; j--) {
                if (stackIn2DArray[j][i]!='*'){
                    temp.getStack().add(stackIn2DArray[j][i]);
                }
            }
            stackList.add(new CrateStack(temp));
            temp.getStack().clear();
        }
        return stackList;
    }

    public char[][] parseStackStringTo2DArray(ArrayList<String> st){
        int[] indexList = getIndexOfNumbers(st.get(st.size()-1));
        int row = st.size();
        int column = indexList.length;
        char[][] temp = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (st.get(i).length()<indexList[j]){
                    temp[i][j] = '*';
                } else if (st.get(i).charAt(indexList[j])==' '){
                    temp[i][j] = '*';
                } else {
                    temp[i][j] = st.get(i).charAt(indexList[j]);
                }
            }
        }
        return temp;
    }

    public int[] getIndexOfNumbers(String st){
        int valueOfLastNumber = Integer.parseInt(String.valueOf(st.charAt(st.length()-1)));
        int[] temp = new int[valueOfLastNumber];
        for (int i = 1; i <= valueOfLastNumber; i++) {
            temp[i-1] = st.indexOf(String.valueOf(i));
        }
        return temp;
    }

    public ArrayList<CrateStack> getStackList() {
        return stackList;
    }

    public String printMovingResult(){
        String temp = "";
        for (CrateStack i : stackList){
            temp += i.getLastChar();
        }
        return temp;
    }

    public ArrayList<String> getCrateList() {
        return crateList;
    }

    public ArrayList<String> getStepList() {
        return stepList;
    }

    public void setStackList(ArrayList<CrateStack> stackList) {
        this.stackList = new ArrayList<>(stackList);
    }
}
