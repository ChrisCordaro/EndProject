package Competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import Events.Event;
import Events.EventManager;
import Queues.QueueItemList;
import Stacks.StackItemList;
import Teams.Team;
import Teams.TeamManager;

public class CompetitionManager {
	private EventManager em;
	private TeamManager tm;

	private Competition head;
	private Competition tail;
	private int numCompetitions;
	private BufferedReader input;
	private Team winnerArray[];
	/**
	 * Construct a new CompetitionManager
	 *
	 * @param em
	 *            the event manager that manages which events can be played in a
	 *            competition
	 * @param tm
	 *            the team manager that manages the teams that can participate
	 *            in a competition
	 */
public CompetitionManager(EventManager em, Event[] gameEvents)
	{
		/*
	 * 
	 */
	this.em = em;
	
	QueueItemList CompetitionList = new QueueItemList();
	CompetitionList.randomQueue(em.getT());
	
	StackItemList StackList = new StackItemList();
	
	input = new BufferedReader(new InputStreamReader(System.in));
	String line;
	
	int numEvents = gameEvents.length;
	int eventsPlayed = 0;
	/*
	 * while there is still events to play
	 */
	while(eventsPlayed < numEvents){
		int[] completedEvents = new int[em.getEvents().length];
		Boolean check = false;
		int completeEventsNum = 0;
		int currGameEvent = 0;
		while (check == false){
			System.out.println("What number event would you like to play?");
			currGameEvent = Integer.parseInt(input.readLine());
			if(!Arrays.asList(completedEvents).contains(currGameEvent)){
				check = true;
				completedEvents[completeEventsNum] = currGameEvent;
				completeEventsNum++;
			}else{
				System.out.println("You already played that event, enter a new number");
			}
			
			if(currGameEvent > numEvents){
				System.out.println("please enter a number between 1-8");
			} else {
				System.out.println("Currently Creating a competition of " + em.getSingleEvent(currGameEvent));
				Event currEvent = em.getSingleEvent(currGameEvent);	
			}
		}
				
		while (CompetitionList.peekNextTeams() != null){
			Team[] playingTeams = CompetitionList.getNextTeams();
			Team t1 = playingTeams[0];
			Team t2 = playingTeams[1];
			Team[] results = compete(em.getSingleEvent(currGameEvent), t1, t2);
			CompetitionList.enqueue(results[0]);
			StackList.push(results[1]);
		}
		
		/*
		 * when peekNextTeams returns only 1 team
		 * push that team onto the stack and thus makes it the winner of the competition
		 * print out to the user the placings of the teams
		 * for every competition started by the user:
		 * 	1)User is prompted to enter what event he/she like to play
		 * 	2)Add that event to completedEvents array
		 * 	3)Dequeue two teams from randomly generated queue
		 * 	4)Have the results of getNextTeams() compete() which runs the fight() method
		 * 	5)Fight randomly decides a winner
		 * 	6)Enqueues winner back to queue and pushes loser to stack
		 * 	7)When peek next teams is null, the competition is over
		 * 	8)Print out placings
		 */
		StackList.push(CompetitionList.getFirst().getTeamValue());
		
		int count = 1;
		System.out.println("Competition has ended. Here are the results. The first listed is the winner for  " + em.getSingleEvent(currGameEvent));
		
		//Record winners of each events
		winnerArray[currGameEvent] = StackList.peekTopTeam();	
		
		while (!StackList.isEmpty()){
			System.out.println(count + ": " + StackList.pop().toString());
			count++;			
		}
		eventsPlayed++;
		check = false;
	}
}

	

	private Team[] compete(Event currEvent, Team t1, Team t2) {
		Team[] results = fight(t1, t2);
		returnTeams(results[0],results[1]);
		return results;
	}
	
	public void trackWinners(StackItemList s, int x){
		winnerArray[x] = s.peekTopTeam();
	}
	
	public Team[] fight(Team t1, Team t2) {
		Team[] returnTeam = new Team[2];
		Random rn = new Random();
		int decidingInt = rn.nextInt(10) + 1;
		if (decidingInt > 5) {
			returnTeam[0] = t1;
			returnTeam[1] = t2;
			return returnTeam;
		} else {
			returnTeam[0] = t2;
			returnTeam[1] = t1;
			return returnTeam;
		}

	}

	public void returnTeams(Team winner, Team loser){
		winner.incrementWins();
		loser.incrementLosses();
	}

	public void showWinners(){
		for (int i = 0; i < winnerArray.length; i++){
			System.out.println("For the event " + em.getSingleEvent(i) + ", the winner was " + winnerArray[i].toString());
		} 
	}
		

	/**
	 * Start a new competition, this competition will exist until endCompetition
	 * is called
	 *
	 * @param event
	 *            the event that this competition will be played
	 * @param homeTeam
	 *            the home team playing this competition
	 * @param awayTeam
	 *            the away team playing this competition
	 */

	
	/**
	 * Retrieve the currently started competitions
	 *
	 * @return An array of competitions that are currently going on
	 */
	public ICompetition[] getCompetitions() {
		// convert the linked list of competitions to an array of competitions
		ICompetition[] competitions = new ICompetition[numCompetitions];
		Competition currItem = head;

		int currIdx = 0;
		while (currItem != null) {
			competitions[currIdx++] = currItem;
			currItem = currItem.getNext();
		}

		return competitions;
	}

	/**
	 * End a competition.
	 *
	 * @param competition
	 *            the competition to end
	 * @param winningTeam
	 *            the team that won the competition losing team gets added to
	 *            the stack winning team gets enqueued
	 */
	public void endCompetition(ICompetition competition, Team winningTeam) {
		Competition currItem = head;

		// find the item (or find the end of the list
		while (currItem != null && currItem != competition)
			currItem = currItem.getNext();

		// if we made it to the end, competition provided is not in our list.
		// Just return
		if (currItem == null)
			return;

		// found it, remove it
		numCompetitions--;

		if (currItem == head)
			head = currItem.getNext();
		if (currItem == tail)
			tail = currItem.getPrev();
		if (currItem.getPrev() != null)
			currItem.getPrev().setNext(currItem.getNext());
		if (currItem.getNext() != null)
			currItem.getNext().setPrev(currItem.getPrev());

		// update the stats for the winning/losing teams
		if (currItem.getHomeTeam() == winningTeam) {
			currItem.getHomeTeam().incrementWins();
			currItem.getAwayTeam().incrementLosses();
		} else {
			currItem.getHomeTeam().incrementLosses();
			currItem.getAwayTeam().incrementWins();
		}
	}

	/**
	 * Retrieve the events that are currently not being played (they are open).
	 *
	 * @return an array of events that are open
	 */
	public Event[] getFreeEvents() {
		Event[] allEvents = em.getEvents();
		// free events is number of events minus number of competitions (one
		// event per competition)
		Event[] freeEvents = new Event[allEvents.length - numCompetitions];

		int currIdx = 0;

		// iterate through all events, only add ones that are free
		for (int i = 0; i < allEvents.length; i++) {
			if (isEventFree(allEvents[i]))
				freeEvents[currIdx++] = allEvents[i];
		}

		return freeEvents;
	}

	/**
	 * Retrieve the teams that are currently not playing (they are open).
	 *
	 * @return an array of teams that are open
	 */
	public Team[] getFreeTeams() {
		Team[] allTeams = tm.getTeams();
		// free teams is number of teams minus 2*number of competitions (two
		// teams per competition)
		Team[] freeTeams = new Team[allTeams.length - (numCompetitions * 2)];

		int currIdx = 0;

		// iterate through all teams, only add ones that are free
		for (int i = 0; i < allTeams.length; i++) {
			if (isTeamFree(allTeams[i]))
				freeTeams[currIdx++] = allTeams[i];
		}

		return freeTeams;
	}

	/**
	 * Determine if an event is currently free
	 *
	 * @param event
	 *            the event to check for
	 *
	 * @return true if the event is free, false otherwise
	 */
	private boolean isEventFree(Event event) {
		Competition currItem = head;

		while (currItem != null) {
			if (currItem.getEvent() == event)
				return false;

			currItem = currItem.getNext();
		}
		return true;
	}


	/**
	 * Determine if a team is currently free
	 *
	 * @param team
	 *            the team to check for
	 *
	 * @return true if the team is free, false otherwise
	 */
	private boolean isTeamFree(Team team) {
		Competition currItem = head;

		while (currItem != null) {
			if (currItem.getHomeTeam() == team
					|| currItem.getAwayTeam() == team)
				return false;

			currItem = currItem.getNext();
		}
		return true;
	}
}
