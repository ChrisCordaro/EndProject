package Stacks;

import Queues.QueueItem;
import Teams.Team;

public class StackItemList {
	private StackItem first;
	private StackItem last;
	private StackItem currItem;

	public StackItemList() {
		first = last = currItem = new StackItem();
	}

	public StackItem getFirst() {
		return first;
	}

	public StackItem getLast() {
		return last;
	}

	public StackItem getCurrItem() {
		return currItem;
	}

	public void setFirst(StackItem first) {
		this.first = first;
	}

	public void setLast(StackItem last) {
		this.last = last;
	}

	public void setCurrItem(StackItem currItem) {
		this.currItem = currItem;
	}

	/*
	 * checks to see if stack is null
	 * if it is an empty stack, push the item onto it and create it as first/last/curr
	 * if there is currently an item
	 * last now becomes the item
	 */
	public void push(Team t) {
		StackItem s = new StackItem(t);
		if (first == null) {
			first = s;
			last = s;
			currItem = s;
		} else {
			StackItem temp = currItem;

			last = s;
			currItem.setNext(s);
			currItem = s;
			currItem.setPrev(temp);

		}

	}
	
	/*
	 * removes the last item of the stack
	 */

	public Team pop() {
		if (first == null) {
			System.out.println("Stack is empty, cannot pop");
			return null;
		} else {
			Team returnTeam = last.getTeamValue();
			last = last.getPrev();

			return returnTeam;
		}

	}

	public boolean isEmpty() {
		if (last == null) {
			return true;
		} else {
			return false;
		}

	}
	
	/*
	 * returns the team at the top of the stack
	 * but it does not dequeue it
	 * used to print out the list of winners in CompetitionManager
	 */
	
	public Team peekTopTeam(){
		if(last == null){
			return null;
		}else{
			Team topTeam = last.getTeamValue();
			return topTeam;
		}
	}

}
