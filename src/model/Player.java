package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	
	private List<Ship> ships;
	
	private List<String> targets;
	
	public Player(){
		List<Ship> ships = new ArrayList<Ship>();
		this.ships = ships;
		
		List<String> targList = new ArrayList<>();
		this.targets = targList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public List<String> getTargets() {
		return targets;
	}

	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	
	
}
