package pills;

public class ConsistencyInspector extends Inspector {

    int adultCount;
    int childCount;

    @Override
    public String report() {
        //throw new UnsupportedOperationException("Unimplemented method 'report'");
        return "The adultCount is: " + adultCount + ".\n" + "The childCount is: " +
            childCount + ".\n";
    }

    @Override
    public void reset() {
        //need to call this first to initialize the variables.
        //throw new UnsupportedOperationException("Unimplemented method 'reset'");
        adultCount = 0;
        childCount = 0;
    }

    public void inspect(AdultAcheAway e) {
        adultCount++;
    }

    public void inspect(ChildAcheAway e) {
        childCount++;
    }

    public void inspect(AdultDreamly e) {
        adultCount++;
    }

    public void inspect(ChildDreamly e) {
        childCount++;
    }

    public boolean soFarConsistent() {
        if (adultCount > 0 && childCount == 0) {
            return true;
        }
        else if (childCount > 0 && adultCount == 0) {
            return true;
        }
        else if (childCount == 0 && adultCount == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
