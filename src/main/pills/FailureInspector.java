package pills;

public class FailureInspector extends Inspector {
    
    int nullCount;
    int totalCount;

    @Override
    public String report() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'report'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    public void inspect(AdultAcheAway e) {

    }

    public void inspect(ChildAcheAway e) {

    }

    public void inspect(AdultDreamly e) {

    }

    public void inspect(ChildDreamly e) {

    }

    public void inspect(NullAcheAway e) {

    }

    public void inspect(NullDreamly e) {

    }

    public double getFailRate() {
        
    }
}
