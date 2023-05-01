package pills;

/*
 * DreamlyMock class.
 * This class is used for Dreamly tests.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class DreamlyMock extends Dreamly {

    public DreamlyMock(double strength,
        double size, String color, String solution, 
        String casing, String active) {
        super(strength, size, color, casing, solution, active);
    }

    public void accept(Inspector insp) {}
}
