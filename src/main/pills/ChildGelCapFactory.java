package pills;

public class ChildGelCapFactory extends GelCapFactory {

    protected Dreamly constructDreamly(String casing,
        String solution, String active) {
        System.out.print("Constructing child version of Dreamly\n");
        return new ChildDreamly(casing, solution, active);
    }

    protected AcheAway constructAcheAway(String casing, 
        String solution, String active) {
        System.out.print("Constructing child version of AcheAway\n");
        return new ChildAcheAway(casing, solution, active);
    }

    protected double getDreamlyStrength() {
        return ChildDreamly.STRENGTH;
    }

    protected double getAcheAwayStrength() {
        return ChildAcheAway.STRENGTH;
    }
}
