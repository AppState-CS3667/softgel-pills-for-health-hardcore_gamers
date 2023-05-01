package pills;

/*
 * ConsistencyInspector class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class ConsistencyInspector extends Inspector {

    int adultCount;
    int childCount;

    /*
     * report method
     * reports the current status of the inspector
     */
    @Override
    public String report() {
        return "The adultCount is: " + adultCount + ".\n" 
            + "The childCount is: " + childCount + ".\n";
    }

    /*
     * reset method
     * resets the inspector's accumulator variables to 0
     */
    @Override
    public void reset() {
        //need to call this first to initialize the variables.
        adultCount = 0;
        childCount = 0;
    }

    /*
     * inspect method
     * increments the count of adultCount by 1
     * 
     * @param e - an AdultAcheAway pill
     */
    public void inspect(AdultAcheAway e) {
        adultCount++;
    }

    /*
     * inspect method
     * increments the count of childCount by 1
     * 
     * @param e - a ChildAcheAway pill
     */
    public void inspect(ChildAcheAway e) {
        childCount++;
    }

    /*
     * inspect method
     * increments the count of adultCount by 1
     * 
     * @param e - an AdultDreamly pill
     */
    public void inspect(AdultDreamly e) {
        adultCount++;
    }

    /*
     * inspect method
     * increments the count of childCount by 1
     * 
     * @param e - a ChildDreamly pill
     */
    public void inspect(ChildDreamly e) {
        childCount++;
    }

    /*
     * soFarConsistent method
     * returns true or false based on if the counts in the order are consistent
     */
    public boolean soFarConsistent() {
        if (adultCount > 0 && childCount == 0) {
            return true;
        }
        else if (childCount > 0 && adultCount == 0) {
            return true;
        }
        if (childCount == 0 && adultCount == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
