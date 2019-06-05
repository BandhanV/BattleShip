package util;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Ship;

public class Util {
	
	public static List<String> generateShipCoordinates(String boundaries, String type, int x, int y, String loc) throws CustomException{
		List<String> list = new ArrayList<String>();
		char[] bArr = boundaries.trim().toCharArray();
		char len = bArr[0];
		char bre = bArr[2];
		
		char[] arr = loc.trim().toCharArray();
		char alpha = arr[0];
		char num = arr[1];
		
		for(int i=0; i<y; i++){
			for(int j=0; j<x; j++){
				char ch = (char)((int)alpha + i);
				char nu = (char)((int)num + j);
				if(ch>bre || nu>len){
					throw new CustomException("Position of ship is out of battle area boundary. Please provide valid ship position");
				}
				
				String str = String.valueOf(ch) + String.valueOf(nu);
				list.add(str);
				if(type.equalsIgnoreCase("Q")){
					list.add(str);
				}
			}
		}
		return list;
	}

	public static List<String> generateTargets(String target){
		List<String> targets = new ArrayList<String>();
		
		String[] arr = target.trim().split(" ");
		
		for(String str: arr){
			targets.add(str);
		}
		
		return targets;
	}
	
	public static boolean hitTarget(Player player, String target){
		List<Ship> ships = player.getShips();
		for(Ship ship: ships){
			boolean rem = ship.getCoordinates().remove(target);
			if(rem){
				return true;
			}
		}
		return false;
	}
	
	public static boolean completeDestroy(Player player){
		List<Ship> ships = player.getShips();
		for(Ship ship: ships){
			boolean isEmpty = ship.getCoordinates().isEmpty();
			if(!isEmpty){
				return false;
			}
		}
		return true;
	}
}
