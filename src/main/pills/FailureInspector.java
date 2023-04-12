package pills;

/*
 * FailureInspector class
 */
public class FailureInspector extends Inspector {
    
    int nullCount;
    int totalCount;

    /*
     * report method
     * reports the current status of the inspector
     */
    @Override
    public String report() {
        return "nullCount is: " + nullCount + ".\n" + "totalCount is: " 
            + totalCount + ".\n";
    }

    /*
     * reset method
     * resets the inspector's accumulator variables to 0
     */
    @Override
    public void reset() {
        //need to call first to initialize variables
        nullCount = 0;
        totalCount = 0;
    }

    /*
     * inspect method
     * increments the count of totalCount by 1
     * 
     * @param e - an AdultAcheAway pill
     */
    public void inspect(AdultAcheAway e) {
        totalCount++;
    }

    /*
     * inspect method
     * increments the count of totalCount by 1
     * 
     * @param e - a ChildAcheAway pill
     */
    public void inspect(ChildAcheAway e) {
        totalCount++;
    }

    /*
     * inspect method
     * increments the count of totalCount by 1
     * 
     * @param e - an AdultDreamly pill
     */
    public void inspect(AdultDreamly e) {
        totalCount++;
    }

    /*
     * inspect method
     * increments the count of totalCount by 1
     * 
     * @param e - a ChildDreamly pill
     */
    public void inspect(ChildDreamly e) {
        totalCount++;
    }

    /*
     * inspect method
     * increments the count of totalCount and nullCount by 1
     * 
     * @param e - a NullAcheAway pill
     */
    public void inspect(NullAcheAway e) {
        nullCount++;
        totalCount++;
    }

    /*
     * inspect method
     * increments the count of totalCount and nullCount by 1
     * 
     * @param e - a NullDreamly pill
     */
    public void inspect(NullDreamly e) {
        nullCount++;
        totalCount++;
    }

    /*
     * getFailRate method
     * returns the current ratio of null pills to total pills 
     */
    public double getFailRate() {
        return nullCount / totalCount;
    }
}
