package pills;

/*
 * NullAcheAway class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class NullAcheAway extends AcheAway {
    
    /*
     * NullAcheAway no-arg constructor 
     * that give falsy values to the super const.
     */
    public NullAcheAway() {
        super(0.0, 0.0, "", "", "", "");
    }

    /*
     * calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    public void accept(Inspector insp) {
        insp.inspect(this);
    }
}
