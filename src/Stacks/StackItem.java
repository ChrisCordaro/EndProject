package Stacks;
import Teams.Team;


public class StackItem {
	private StackItem next;
	private StackItem prev;
	private Team teamValue;

	public StackItem(){
		this.next = null;
		this.prev = null;
		this.teamValue = null;
	}
	
	/*public StackItem(int v){
		this.next = null;
		this.prev = null;
		this.value = v;
	}*/

	public StackItem(Team t){
		this.next = null;
		this.prev = null;
		this.teamValue = t;
	}

	public StackItem getNext() {
		return next;
	}

	public StackItem getPrev() {
		return prev;
	}

	/*public int getValue() {
		return value;
	}*/
	
	public Team getTeamValue(){
		return teamValue;
	}

	public void setNext(StackItem next) {
		this.next = next;
	}

	public void setPrev(StackItem prev) {
		this.prev = prev;
	}

	/*public void setValue(int value) {
		this.value = value;
	}*/
	
	public void setTeamValue(Team t){
		this.teamValue = t;
	}
}
