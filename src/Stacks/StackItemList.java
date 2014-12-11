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
	
	public boolean isEmpty(){
		if(last == null){
			return true;
		}else{
			return false;
		}
		
	}
	
	 /*public Team peek() {
		 System.out.println("Peeking Stack: ");
	      return last.getTeamValue();
	      
	    }*/
	
	
	/**
	 * checks to see if there is only one remaining team on queue
	 * if so, push that team onto the stack
	 * @param QI
	 */
	public void pushLastTeam(QueueItem QI){
		
	}
}
