package Events;


/**
 * The Horseshoes event
 */
public class HorseshoesEvent extends Event {
    private int numHorseshoes;

    /**
     * Construct a horseshoes object
     */
    public HorseshoesEvent() {
        super("Horseshoes", 11, false, 40);
    }

    /**
     * Retrieve any extra information for this event.
     *
     * @return extra information for this event
     */
    public String getExtraInfo() {
        return "Num Horseshoes: " + numHorseshoes;
    }

    /**
     * Retrieve the number of horseshoes
     *
     * @return the number of horseshoes
     */
    public int getNumHorseshoes() {
        return numHorseshoes;
    }

    /**
     * Set the number of horseshoes
     *
     * @param numHorseshoes the number of horseshoes
     */
    public void setNumHorseshoes(int numHorseshoes) {
        this.numHorseshoes = numHorseshoes;
    }
}
