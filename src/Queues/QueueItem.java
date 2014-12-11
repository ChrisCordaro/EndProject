package Queues;
import Teams.Team;

public class QueueItem {

	/**
	 * Have a queued list of teams replace ints with team
	 */
	private QueueItem next;
	private Team teamValue;

	public QueueItem() {
		this.next = null;
		this.teamValue = null;
	}

	public QueueItem(Team x) {
		this.next = null;
		this.teamValue = x;
	}

	public QueueItem getNext() {
		return next;
	}

	public Team getTeamValue() {
		return teamValue;
	}

	public void setNext(QueueItem next) {
		this.next = next;
	}

}
