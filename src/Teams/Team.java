package Teams;

import Olympians.Olympian;




/**
 * The Team class represents two olympians that have been paired up for the games
 */
public class Team {
    private Olympian olympian1;
    private Olympian olympian2;
    private int numWins;
    private int numLosses;

    /**
     * Construct a new Team object
     *
     * @param olympian1 the first olympian on the team
     * @param olympian2 the second olympian on the team
     */
    public Team(Olympian olympian1, Olympian olympian2) {
        this.olympian1 = olympian1;
        this.olympian2 = olympian2;
    }

    /**
     * Retrieve the first olympian on the team
     *
     * @return the first olympian on the team
     */
    public Olympian getOlympian1() {
        return olympian1;
    }

    /**
     * Set the first olympian on the team
     *
     * @param olympian the olympian
     */
    public void setOlympian1(Olympian olympian) {
        this.olympian1 = olympian;
    }

    /**
     * Retrieve the second olympian on the team
     *
     * @return the second olympian on the team
     */
    public Olympian getOlympian2() {
        return olympian2;
    }

    /**
     * Set the second olympian on the team
     *
     * @param olympian the olympian
     */
    public void setOlympian2(Olympian olympian) {
        this.olympian2 = olympian;
    }

    /**
     * Increment the number of wins this team has
     */
    public void incrementWins() {
        numWins++;
    }

    /**
     * Increment the number of losses this team has
     */
    public void incrementLosses() {
        numLosses++;
    }

    /**
     * Retrieve the number of wins this team has
     *
     * @return the number of wins this team has
     */
    public int getNumWins() {
        return numWins;
    }

    /**
     * Retrieve the number of losses this team has
     *
     * @return the number of losses this team has
     */
    public int getNumLosses() {
        return numLosses;
    }

    /**
     * Provide a custom toString method for easy printing
     *
     * @return A string representation of this team
     */
    public String toString()
    {
        return olympian1.getName() + " & " + olympian2.getName();
    }
}
