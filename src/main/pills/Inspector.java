package pills;

public abstract class Inspector {
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

    public abstract String report();

    public abstract void reset();
} 