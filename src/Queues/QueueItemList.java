package Queues;

import java.util.ArrayList;
import java.util.Random;

import Events.Event;
import Events.EventManager;
import Teams.Team;

public class QueueItemList {
	// Not sure if these should be QueueItems or Teams
	private QueueItem first;
	private QueueItem last;
	private QueueItem currItem;

	public QueueItemList() {
		first = last = currItem = new QueueItem();

	}

	/**
	 * the winning team of a competition gets put back on the queue the two
	 * dequeued teams 'fight' winning team is returned back into the queue
	 * 
	 * @param t
	 */

	public void enqueue(Team t) {
		QueueItem q = new QueueItem(t);
		if (first == null || first.getTeamValue() == null) {
			first = q;
			last = q;
			currItem = q;

		} else {
			last = q;
			currItem.setNext(q);
			currItem = q;

		}
	}

	/**
	 * removes first item on the queue FIFO
	 * 
	 * @return
	 */

	public Team dequeue() {
		if (first == null) {
			System.out.println("queue empty");
			return null;
		} else {
			Team returnTeam = first.getTeamValue();
			first = first.getNext();

			return returnTeam;
		}

	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returns the next two teams from the bracket system but does not dequeue
	 * them not sure if it should return a Team[] or Team based off how I
	 * currently have my list coded
	 * 
	 * @return
	 */
	public Team[] peekNextTeams() {
		System.out.println("Peeking queue: ");
		if (first == null) {
			return null;
		} else if (first != null && first.getNext() == null) {
			return null;
		} else {
			Team returnTeam = first.getTeamValue();
			Team returnTeam2 = first.getNext().getTeamValue();

			Team[] teamArray = new Team[2];
			teamArray[0] = returnTeam;
			teamArray[1] = returnTeam2;

			return teamArray;

		}
	}

	public Team[] getNextTeams() {

		System.out.println("Setting up team vs team");
		if (first == null) {
			return null;
		} else {
			Team nextTeam = dequeue();
			Team nextTeam2 = dequeue();

			Team[] teamArray = new Team[2];
			teamArray[0] = nextTeam;
			teamArray[1] = nextTeam2;

			return teamArray;

		}
	}

	public void ReturnTeams(Team winner, Team lost) {
		//Keeps track of who wins and who loses a competition
		//Return the winner of every event
		
		
	}

	/**
	 * creates a queue based on the teams variable found in the team manager
	 * class however, it must be randomized currently they are placed in order
	 * 1,2,3.....
	 * 
	 * @param t
	 */

	public void randomQueue(Team[] t) {
		/*
		 * creates a blank queue
		 * creates an array list of 8 random integers
		 * int a is a random integer between 1-8 (maybe need to add +1)
		 * if the array list does not contain the random number 'a'
		 * add 'a' to the array list 
		 
		 */
		QueueItemList q = new QueueItemList();
		ArrayList<Integer> randNums = new ArrayList();
		Random random = new Random();
		while (randNums.size() != 8) {
			int a = random.nextInt(8);
			if (!randNums.contains(a))
				randNums.add(a);
		}
		for (int i = 0; i < randNums.size(); i++) {
			q.enqueue(t[randNums.get(i)]);
		}
	}

	public QueueItem getFirst() {
		return first;
	}

	public QueueItem getLast() {
		return last;
	}

	public QueueItem getCurrItem() {
		return currItem;
	}

	public void setFirst(QueueItem first) {
		this.first = first;
	}

	public void setLast(QueueItem last) {
		this.last = last;
	}

	public void setCurrItem(QueueItem currItem) {
		this.currItem = currItem;
	}

}
