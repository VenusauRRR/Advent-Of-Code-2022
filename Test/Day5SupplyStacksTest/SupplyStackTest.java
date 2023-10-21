package Day5SupplyStacksTest;

import Day5SupplyStacks.Main;
import Day5SupplyStacks.Step;
import Day5SupplyStacks.SupplyStack;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class SupplyStackTest {
    SupplyStack ss = new SupplyStack();

    ArrayList<String> input = new ArrayList<>(Arrays.asList(
            "    [D]",
            "[N] [C]",
            "[Z] [M] [P]",
            " 1   2   3"
    ));

    ArrayList<String> steps = new ArrayList<>(Arrays.asList(
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
    ));


    SupplyStack s1 = new SupplyStack(input,steps);

    Path p = Paths.get("Test/Day5SupplyStacksTest/Temp");

    @Test
    public void readFromFileTest(){
        SupplyStack sx = new SupplyStack(p);

        String st0 = "    [D]";
        String st3 = " 1   2   3";
        String st5 = "move 1 from 2 to 1";
        String st6 = "move 3 from 1 to 3";

        assertTrue(sx.getCrateList().get(0).equals(st0));
        assertTrue(sx.getCrateList().get(3).equals(st3));
        assertTrue(sx.getStepList().get(0).equals(st5));
        assertTrue(sx.getStepList().get(1).equals(st6));
    }

    @Test
    public void parseStackStringTo2DArrayTest(){
        ArrayList<String> input = new ArrayList<>(Arrays.asList(
                "    [D]",
                "[N] [C]",
                "[Z] [M] [P]",
                " 1   2   3"
        ));
        char[] c1 = {'*','D','*'};
        char[] c2 = {'N','C','*'};
        char[] c3 = {'Z','M','P'};
        assertTrue(Arrays.equals(ss.parseStackStringTo2DArray(input)[0],c1));
        assertTrue(Arrays.equals(ss.parseStackStringTo2DArray(input)[1],c2));
        assertTrue(Arrays.equals(ss.parseStackStringTo2DArray(input)[2],c3));
    }

    @Test
    public void getIndexOfNumbersTest(){
        String st = " 1   2   3";
        int[] index = {1,5,9};
        assertTrue(Arrays.equals(ss.getIndexOfNumbers(st),index));
    }
    @Test
    public void rewrite2DArrayToArrayListTest(){
        ArrayList<String> input = new ArrayList<>(Arrays.asList(
                "    [D]",
                "[N] [C]",
                "[Z] [M] [P]",
                " 1   2   3"
        ));

        assertTrue(ss.rewrite2DArrayToArrayList(input).get(0).toString().equals("1ZN"));
        assertTrue(ss.rewrite2DArrayToArrayList(input).get(1).toString().equals("2MCD"));
        assertTrue(ss.rewrite2DArrayToArrayList(input).get(2).toString().equals("3P"));
    }

    @Test
    public void moveCrateInStackTest(){
        s1.moveCrateInStack();
        assertTrue(s1.getStackList().get(0).toString().equals("1C"));
        assertTrue(s1.getStackList().get(1).toString().equals("2M"));
        assertTrue(s1.getStackList().get(2).toString().equals("3PDNZ"));
    }

    @Test
    public void moveCrateWithNewMachineTest(){
        s1.moveCrateWithNewMachine();
        assertTrue(s1.getStackList().get(0).toString().equals("1M"));
        assertTrue(s1.getStackList().get(1).toString().equals("2C"));
        assertTrue(s1.getStackList().get(2).toString().equals("3PZND"));
    }

    @Test
    public void printMovingResultTest(){
        String st = "CMZ";
        s1.moveCrateInStack();
        assertTrue(s1.printMovingResult().equals(st));
    }

}//class
