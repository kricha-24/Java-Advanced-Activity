package com.ltts.model;

public class Aution {
	private int autionId;
	private int playerID;
	private int teamId;
	private String ayear;
	private double price;
	
	public Aution() {
		super();
	}
	public Aution(int autionId, int playerID, int teamId, String ayear2, double price) {
		super();
		this.autionId = autionId;
		this.playerID = playerID;
		this.teamId = teamId;
		this.ayear = ayear2;
		this.price = price;
	}
	public int getAutionId() {
		return autionId;
	}
	public void setAutionId(int autionId) {
		this.autionId = autionId;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getYear() {
		return ayear;
	}
	public void setYear(String year) {
		this.ayear = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Aution [autionId=" + autionId + ", playerID=" + playerID + ", teamId=" + teamId + ", year=" + ayear
				+ ", price=" + price + "]";
	}
}