package Day5SupplyStacks;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path p = Paths.get("src/Day5SupplyStacks/InputPuzzel");
        Path p1 = Paths.get("src/Day5SupplyStacks/Temp");
        SupplyStack s = new SupplyStack(p);
        s.moveCrateInStack();
        System.out.println("Result of Part 1: " + s.printMovingResult());

        SupplyStack sNew = new SupplyStack(p);
        sNew.moveCrateWithNewMachine();
        System.out.println("Result of Part 2: " + sNew.printMovingResult());
    }
}
