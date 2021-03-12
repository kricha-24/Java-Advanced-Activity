package com.ltts.model;

public class Player {
	private int runs, wickets, matches;
	private String name, dob;
	
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Player( String name,String dob, int runs, int wickets, int matches) {
		super();
		this.runs = runs;
		this.wickets = wickets;
		this.matches = matches;
		this.name = name;
		this.dob = dob;
	}
	public Player() {
		super();
	}
	@Override
	public String toString() {
		return "Player [runs=" + runs + ", wickets=" + wickets + ", matches=" + matches + ", name=" + name + ", dob="
				+ dob + "]";
	}
}


