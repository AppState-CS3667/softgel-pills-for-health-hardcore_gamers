package pills;

/*
 * NullDreamly class
 */
public class NullDreamly extends Dreamly {
    /*
     * NullDreamly no-arg constructor that give falsy values to the super const.
     */
    public NullDreamly() {
        super(0.0, 0.0, "", "", "", "");
    }

    /*
     * accept method
     * 
     * calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    public void accept(Inspector insp) {
        insp.inspect(this);
    }

}
