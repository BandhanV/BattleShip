package model;

import java.util.List;

import util.CustomException;
import util.Util;

public class Ship {
	private String type;
	
	private int xDimen;
	
	private int yDimen;
	
	private String location;
	
	private List<String> coordinates;
	
	public Ship(){
		
	}
	
	public Ship(String boundaries, String type, int x, int y, String loc) throws CustomException{
		this.type = type;
		this.xDimen = x;
		this.yDimen = y;
		this.location = loc;
		List<String> coList = Util.generateShipCoordinates(boundaries, type, x, y, loc);
		this.coordinates = coList;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getxDimen() {
		return xDimen;
	}

	public void setxDimen(int xDimen) {
		this.xDimen = xDimen;
	}

	public int getyDimen() {
		return yDimen;
	}

	public void setyDimen(int yDimen) {
		this.yDimen = yDimen;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<String> coordinates) {
		this.coordinates = coordinates;
	}
	
}
