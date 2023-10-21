package Day5SupplyStacksTest;

import Day5SupplyStacks.Step;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class StepTest {
    Step step = new Step();

    @Test
    public void parseNumberInStringToIntegerArrayTest(){
        String st1 = "move 1 from 2 to 1";
        Step step1 = new Step(st1);
        assertTrue(step1.getMovingCrateAmt()==1);
        assertTrue(step1.getOriginalStack()==2);
        assertTrue(step1.getTargetedStack()==1);
    }

    @Test
    public void getterTest(){
        Step s = new Step("move 1 from 2 to 1");
        assertTrue(s.getMovingCrateAmt()==1);
        assertTrue(s.getOriginalStack()==2);
        assertTrue(s.getTargetedStack()==1);
    }
}
