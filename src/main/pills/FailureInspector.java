package pills;

/*
 * FailureInspector class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class FailureInspector extends Inspector {
    
    int nullCount;
    int totalCount;

    /*
     * Reports the current status of the inspector
     */
    @Override
    public String report() {
        return "nullCount is: " + nullCount + ".\n" + "totalCount is: " 
            + totalCount + ".\n";
    }

    /*
     * Resets the inspector's accumulator variables to 0
     */
    @Override
    public void reset() {
        //need to call first to initialize variables
        nullCount = 0;
        totalCount = 0;
    }

    /*
     * Increments the count of totalCount by 1
     * 
     * @param e - an AdultAcheAway pill
     */
    public void inspect(AdultAcheAway e) {
        totalCount++;
    }

    /*
     * Increments the count of totalCount by 1
     * 
     * @param e - a ChildAcheAway pill
     */
    public void inspect(ChildAcheAway e) {
        totalCount++;
    }

    /*
     * Increments the count of totalCount by 1
     * 
     * @param e - an AdultDreamly pill
     */
    public void inspect(AdultDreamly e) {
        totalCount++;
    }

    /*
     * Increments the count of totalCount by 1
     * 
     * @param e - a ChildDreamly pill
     */
    public void inspect(ChildDreamly e) {
        totalCount++;
    }

    /*
     * Increments the count of totalCount and nullCount by 1
     * 
     * @param e - a NullAcheAway pill
     */
    public void inspect(NullAcheAway e) {
        nullCount++;
        totalCount++;
    }

    /*
     * Increments the count of totalCount and nullCount by 1
     * 
     * @param e - a NullDreamly pill
     */
    public void inspect(NullDreamly e) {
        nullCount++;
        totalCount++;
    }

    /*
     * Returns the current ratio of null pills to total pills 
     */
    public double getFailRate() {
        return nullCount / totalCount;
    }
}
