package Events;

import Queues.QueueItemList;
import Teams.TeamManager;
import Teams.Team;

/**
 * gets the events in the application
 */
public class EventManager {
	private Event[] events;
	private Team[] t;

	/**
	 * Construct a new EventManager
	 */
	public EventManager() {
		events = new Event[] { new WashoosEvent(), new HorseshoesEvent(),
				new CornHoleEvent(), new CanJamEvent(), new LadderBallEvent(),
				new StickGameEvent() };
	}

	
	/**
	 * Update EventManager to take as input the Teams that will be competiting
	 * those teams are found in the TeamManager class with getTeams()
	 * Take that array of teams and create a queue of them randomly
	 * using createQueue(team array)
	 * @param tm
	 */
	public EventManager(TeamManager tm) {
		t = tm.getTeams();
		
		events = new Event[] { new WashoosEvent(), new HorseshoesEvent(),
				new CornHoleEvent(), new CanJamEvent(), new LadderBallEvent(),
				new StickGameEvent() };

	}
	

	/**
	 * Retrieve the events
	 *
	 * @return the events
	 */
	public Event[] getEvents() {
		return events;
	}
	
	public Team[] getT(){
		return t;
	}
	
	public Event getSingleEvent(int E){
		return events[E];
	}
}
