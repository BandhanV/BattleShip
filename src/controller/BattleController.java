package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.BattleService;
import service.BattleServiceImpl;
import util.CustomException;
import util.Util;
import model.Player;
import model.Ship;

public class BattleController {
	
	public static void main(String [] args){
		Player playerA = new Player();
		playerA.setName("A");
		
		Player playerB = new Player();
		playerB.setName("B");
		
		int numberOfShips = 2;
		
		try{
			readScannerInput(playerA, playerB, numberOfShips);
			
		}catch(InputMismatchException ex){
			System.out.println("Please provide the valid input");
			return;
			
		}catch (CustomException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		BattleService service = new BattleServiceImpl();
		service.startBattle(playerA, playerB);
		
	}
	
	public static void readScannerInput(Player playerA, Player playerB, int numOfShips) throws CustomException, InputMismatchException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter area boundaries:");
		String bound = sc.nextLine();
		
		for(int i=1; i<=numOfShips; i++){
			System.out.println("Type for battleship " + i);
			String type = sc.next().trim();
			if(!(type.equalsIgnoreCase("Q") || type.equalsIgnoreCase("P"))){
				throw new CustomException("Please provide valid Ship type P or Q");
			}
			
			System.out.println("Dimension for battleship " + i);
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("Location of battleship " +  i + " for player " + playerA.getName());
			String aLoc = sc.next();
			System.out.println("Location of battleship " +  i + " for player " + playerB.getName());
			String bLoc = sc.next();
			
			Ship aShip = new Ship(bound, type, x, y, aLoc);
			playerA.getShips().add(aShip);
			
			Ship bShip = new Ship(bound, type, x, y, bLoc);
			playerB.getShips().add(bShip);
		}
		
		sc.nextLine();
		System.out.println("Missile targets for player " + playerA.getName());
		String aMissile = sc.nextLine();

		playerA.setTargets(Util.generateTargets(aMissile));
		
		System.out.println("Missile targets for player " + playerB.getName());
		String bMissile = sc.nextLine();
		playerB.setTargets(Util.generateTargets(bMissile));
	}
	
}
