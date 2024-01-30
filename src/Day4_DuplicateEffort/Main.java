package Day4_DuplicateEffort;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        DuplicateEffort de = new DuplicateEffort();
        Path p = Paths.get("src/Day4_DuplicateEffort/Input");
        de.readFromFile(p);
        int totalPair = de.countFullyDuplicatePair(de.getAssigmentPair());
        System.out.println("Total fully duplicate pair: " + totalPair);

        int totalDuplicatePair = de.countDuplicatePair(de.getAssigmentPair());
        System.out.println("Total duplicate pair: " + totalDuplicatePair);

    }
}