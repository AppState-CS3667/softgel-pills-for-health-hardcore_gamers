package pills;

public class StrengthInspector extends Inspector {
    
    double dreamlyStrength;
    double acheAwayStrength;

    @Override
    public String report() {
        //throw new UnsupportedOperationException("Unimplemented method 'report'");
        return "The total Dreamly strength is: " + dreamlyStrength + ".\n" +
            "The total AcheAway strength is: " + acheAwayStrength + ".\n";
    }

    @Override
    public void reset() {
        //need to call first to initialize variables
        //throw new UnsupportedOperationException("Unimplemented method 'reset'");
        dreamlyStrength = 0;
        acheAwayStrength = 0;
    }

    public void inspect(AdultAcheAway e) {
        acheAwayStrength += e.getStrength();
    }

    public void inspect(ChildAcheAway e) {
        acheAwayStrength += e.getStrength();
    }

    public void inspect(AdultDreamly e) {
        dreamlyStrength += e.getStrength();
    }

    public void inspect(ChildDreamly e) {
        dreamlyStrength += e.getStrength();
    }

    public double getDreamlyStrength() {
        return dreamlyStrength;
    }

    public double getAcheAwayStrength() {
        return acheAwayStrength;
    }
}
