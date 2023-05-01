package pills;

/*
 * AcheAwayMock class.
 * This class is used for AcheAway tests.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AcheAwayMock extends AcheAway {
    
    public AcheAwayMock(double strength, double size,
                    String color, String casing,
                    String solution, String active) {
        super(strength, size, color, casing, solution, active);
    }

    public void accept(Inspector insp) { }
}
