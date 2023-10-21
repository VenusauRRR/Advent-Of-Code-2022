package Day5_SupplyStacks;
public class Step {

    protected int movingCrateAmt;
    protected int originalStack;
    protected int targetedStack;

    public Step(){}

    public Step(String st){
        parseNumberInStringToIntegerArray(st);
    }

    public void parseNumberInStringToIntegerArray(String st){
        String[] temp = st.split(" ");
        this.movingCrateAmt = Integer.parseInt(temp[1]);
        this.originalStack = Integer.parseInt(temp[3]);
        this.targetedStack = Integer.parseInt(temp[5]);
    }

    public int getMovingCrateAmt() {
        return movingCrateAmt;
    }

    public int getOriginalStack() {
        return originalStack;
    }

    public int getTargetedStack() {
        return targetedStack;
    }
}
