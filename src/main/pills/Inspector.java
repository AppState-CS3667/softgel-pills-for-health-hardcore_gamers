package pills;

/*
 * Inspector abstract class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public abstract class Inspector {

    /*
     * inspect methods to be overridden by classes that extend this
     */
    public void inspect(AdultAcheAway e) {}

    public void inspect(ChildAcheAway e) {}

    public void inspect(AdultDreamly e) { }

    public void inspect(ChildDreamly e) { }

    public void inspect(NullAcheAway e) {}

    public void inspect(NullDreamly e) {}

    /*
     * abstract methods to be implemented by classes that extend this
     */
    public abstract String report();

    public abstract void reset();
} 
