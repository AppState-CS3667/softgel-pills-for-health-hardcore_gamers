package pills;

public class FailureInspector extends Inspector {
    
    int nullCount;
    int totalCount;

    @Override
    public String report() {
        //throw new UnsupportedOperationException("Unimplemented method 'report'");
        return "nullCount is: " + nullCount + ".\n" + "totalCount is: " +
            totalCount + ".\n";
    }

    @Override
    public void reset() {
        //need to call first to initialize variables
        //throw new UnsupportedOperationException("Unimplemented method 'reset'");
        nullCount = 0;
        totalCount = 0;
    }

    public void inspect(AdultAcheAway e) {
        totalCount++;
    }

    public void inspect(ChildAcheAway e) {
        totalCount++;
    }

    public void inspect(AdultDreamly e) {
        totalCount++;
    }

    public void inspect(ChildDreamly e) {
        totalCount++;
    }

    public void inspect(NullAcheAway e) {
        nullCount++;
        totalCount++;
    }

    public void inspect(NullDreamly e) {
        nullCount++;
        totalCount++;
    }

    public double getFailRate() {
        return nullCount / totalCount;
    }
}
