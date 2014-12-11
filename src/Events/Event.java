package Events;
import Teams.Team;


public abstract class Event {
	private String name;
	private int playTo;
	private boolean isPlayToExact;
	private int playDistance;

	/**
	 * Construct a new event, this should be called by whomever subclasses this
	 * class
	 *
	 * @param name
	 *            the name of the event
	 * @param playTo
	 *            the number of points to play to
	 * @param isPlayToExact
	 *            whether the number of points to play to must be exactly hit
	 * @param playDistance
	 *            the distance between the two areas of play
	 */
	public Event(String name, int playTo, boolean isPlayToExact,
			int playDistance) {
		this.name = name;
		this.playTo = playTo;
		this.isPlayToExact = isPlayToExact;
		this.playDistance = playDistance;
	}

	/**
	 * Retrieve any extra information for this event.
	 *
	 * @return extra information for this event
	 */
	public abstract String getExtraInfo();

	/**
	 * Retrieve the name of this event
	 *
	 * @return the name of this event
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this event
	 *
	 * @param name
	 *            the name of this event
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieve the number of points to play to for this event
	 *
	 * @return the number of points to play to for this event
	 */
	public int getPlayTo() {
		return playTo;
	}

	/**
	 * Set the number of points to play to for this event
	 *
	 * @param playTo
	 *            the number of points to play to for this event
	 */
	public void setPlayTo(int playTo) {
		this.playTo = playTo;
	}

	/**
	 * Retrieve whether this event only ends when a player hits the playTo
	 * exactly
	 *
	 * @return true if this event requires exactly hitting the playTo, false
	 *         otherwise
	 */
	public boolean isPlayToExact() {
		return isPlayToExact;
	}

	/**
	 * Set whether this event only ends when a player hits the playTo exactly
	 *
	 * @param isPlayToExact
	 *            true if this event requires exactly hitting the playTo, false
	 *            otherwise
	 */
	public void setPlayToExact(boolean isPlayToExact) {
		this.isPlayToExact = isPlayToExact;
	}

	/**
	 * Retrieve the distance between the two play areas (in feet)
	 *
	 * @return the distance between the two play areas (in feet)
	 */
	public int getPlayDistance() {
		return playDistance;
	}

	/**
	 * Set the distance between the two play areas (in feet)
	 *
	 * @param playDistance
	 *            the distance between the two play areas (in feet)
	 */
	public void setPlayDistance(int playDistance) {
		this.playDistance = playDistance;
	}

	/*public void createQueue(Team[] t) {
		QueueItemList q = new QueueItemList();
		for (int i = 0; i < t.length; i++) {
			q.enqueue(t);

		}
	}*/



	public void enqueueWinner(Team t) {

	}
}
