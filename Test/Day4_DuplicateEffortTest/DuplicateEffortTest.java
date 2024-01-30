package Day4_DuplicateEffortTest;

import Day4_DuplicateEffort.DuplicateEffort;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class DuplicateEffortTest {
    DuplicateEffort de = new DuplicateEffort();
    Path input = Paths.get("Test/Temp");

    @Test
    public void readFromFileTest(){
        de.readFromFile(input);
        String st = "2-4,6-8";
        String st1 = "2-3,4-5";
        assertTrue(de.getAssigmentPair().get(0).equals(st));
        assertTrue(de.getAssigmentPair().get(1).equals(st1));
    }

    @Test
    public void parseStringToIntegerArrayTest(){
        String st = "2-4,6-8";
        String st1 = "2-3,4-5";
        int[] in = {2,4,6,8};
        int[] in2 = {2,3,4,5};
        assertTrue(Arrays.equals(de.parseStringToIntegerArray(st),in));
        assertTrue(Arrays.equals(de.parseStringToIntegerArray(st1),in2));
    }

    @Test
    public void ifPairFullyDuplicateTest(){
        String st = "2-4,6-8";//false, true
        String st1 = "5-6,4-7";//true, true
        String st2 = "1-7,2-6";//false, false
        String st3 = "3-8,2-6";//true, false
        assertFalse(de.ifPairFullyDuplicate(st));
        assertTrue(de.ifPairFullyDuplicate(st1));
        assertTrue(de.ifPairFullyDuplicate(st2));
        assertFalse(de.ifPairFullyDuplicate(st3));
    }

    @Test
    public void countFullyDuplicatePairTest(){
        Path p2 = Paths.get("Test/Temp2");
        DuplicateEffort de1 = new DuplicateEffort(p2);
        int expected = 3;
        assertTrue(de1.countFullyDuplicatePair(de1.getAssigmentPair())==expected);
        assertFalse(de1.countFullyDuplicatePair(de1.getAssigmentPair())==1);
    }

    @Test
    public void isAnyNotDuplicatePairTest(){
        String st = "2-4,6-8";
        String st1 = "5-6,4-7";
        String st2 = "1-7,2-6";
        String st3 = "7-8,2-4";
        assertTrue(de.isAnyNotDuplicatePair(st));
        assertFalse(de.isAnyNotDuplicatePair(st1));
        assertFalse(de.isAnyNotDuplicatePair(st2));
        assertTrue(de.isAnyNotDuplicatePair(st3));
    }

    @Test
    public void countDuplicatePairTest(){
        Path p = Paths.get("Test/Temp");
        DuplicateEffort de = new DuplicateEffort(p);
        int expected = 4;
        assertTrue(de.countDuplicatePair(de.getAssigmentPair())==expected);
        assertFalse(de.countDuplicatePair(de.getAssigmentPair())==1);
    }

}
