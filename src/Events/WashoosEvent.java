package Events;



/**
 * The Washoos event
 */
public class WashoosEvent extends Event {
    private boolean hasAutoWinStick;
    private int numWashoos;

    /**
     * Construct a washoos object
     */
    public WashoosEvent() {
        super("Washoos", 21, false, 15);
    }

    /**
     * Retrieve any extra information for this event.
     *
     * @return extra information for this event
     */
    public String getExtraInfo() {
        return "Auto Win Stick: " + hasAutoWinStick + "   Num Washoos: " + numWashoos;
    }

    /**
     * Retrieve whether this washoos event has an auto-win stick
     *
     * @return true if this washoos event has an auto-win stick, false otherwise
     */
    public boolean isHasAutoWinStick() {
        return hasAutoWinStick;
    }

    /**
     * Set whether this washoos event has an auto-win stick
     *
     * @param hasAutoWinStick true if this washoos event has an auto-win stick, false otherwise
     */
    public void setHasAutoWinStick(boolean hasAutoWinStick) {
        this.hasAutoWinStick = hasAutoWinStick;
    }

    /**
     * Retreieve the number of washoos
     *
     * @return the number of washoos
     */
    public int getNumWashoos() {
        return numWashoos;
    }

    /**
     * Set the number of washoos
     *
     * @param numWashoos the number of washoos
     */
    public void setNumWashoos(int numWashoos) {
        this.numWashoos = numWashoos;
    }
}
