package Day5_SupplyStacks;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path p = Paths.get("src/Day5_SupplyStacks/InputPuzzel");
        SupplyStack s = new SupplyStack(p);
        s.moveCrateInStack();
        System.out.println("Result of Part 1: " + s.printMovingResult());

        SupplyStack sNew = new SupplyStack(p);
        sNew.moveCrateWithNewMachine();
        System.out.println("Result of Part 2: " + sNew.printMovingResult());
    }
}
