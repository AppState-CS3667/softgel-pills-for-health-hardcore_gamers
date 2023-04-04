package pills;

public class AdultGelCapFactory extends GelCapFactory {

    protected Dreamly constructDreamly(String casing,
        String solution, String active) {
        System.out.print("Constructing adult version of Dreamly\n");
        return new AdultDreamly(casing, solution, active);
    }

    protected AcheAway constructAcheAway(String casing, 
        String solution, String active) {
        System.out.print("Constructing adult version of AcheAway\n");
        return new AdultAcheAway(casing, solution, active);
    }

    protected double getDreamlyStrength() {
        return AdultDreamly.STRENGTH;
    }

    protected double getAcheAwayStrength() {
        return AdultAcheAway.STRENGTH;
    }
}
