package Events;

/**
 * The Corn Hole event
 */
public class CornHoleEvent extends Event {
    private int numBeanBags;

    /**
     * Construct a Corn Hole object
     */
    public CornHoleEvent() {
        super("Corn Hole", 21, false, 27);
    }

    /**
     * Retrieve any extra information for this event.
     *
     * @return extra information for this event
     */
    public String getExtraInfo() {
        return "Num Bean Bags: " + numBeanBags;
    }

    /**
     * Retrieve the number of bean bags
     *
     * @return the number of bean bags
     */
    public int getNumBeanBags() {
        return numBeanBags;
    }

    /**
     * Set the number of bean bags
     *
     * @param numBeanBags the number of bean bags
     */
    public void setNumBeanBags(int numBeanBags) {
        this.numBeanBags = numBeanBags;
    }
}
