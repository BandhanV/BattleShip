package service;

import java.util.List;

import util.Util;
import model.Player;

public class BattleServiceImpl implements BattleService {

	@Override
	public void startBattle(Player playerA, Player playerB){
		
		List<String> aTargets = playerA.getTargets();
		List<String> bTargets = playerB.getTargets();
		
		String curPlayer = playerA.getName();
		int a = 0;
		int b = 0;
		
		while(true){
			if(curPlayer.equalsIgnoreCase(playerA.getName())){
				if(a>=aTargets.size()){
					System.out.println("Player-1 has no more missiles left");
					curPlayer = playerB.getName();
					continue;
				}
				
				String target = aTargets.get(a);
				a++;
				
				boolean success = Util.hitTarget(playerB, target);
				if(success){
					System.out.println("Player-1 fires a missile with target " + target + " which hit");
				}else{
					System.out.println("Player-1 fires a missile with target " + target + " which missed");
					curPlayer = playerB.getName();
				}
				
			}else{
				if(b>=bTargets.size()){
					System.out.println("Player-2 has no more missiles left");
					curPlayer = playerA.getName();
					continue;
				}
				
				String target = bTargets.get(b);
				b++;
				
				boolean success = Util.hitTarget(playerA, target);
				if(success){
					System.out.println("Player-2 fires a missile with target " + target + " which hit");
				}else{
					System.out.println("Player-2 fires a missile with target " + target + " which missed");
					curPlayer = playerA.getName();
				}
				
			}
			
			if(a>=aTargets.size() && b>=bTargets.size()){
				System.out.println("Missiles of both player are empty. No winner in the game.");
				break;
			}
			
			if(Util.completeDestroy(playerA)){
				System.out.println("Player-2 won the battle");
				break;
			}
			
			if(Util.completeDestroy(playerB)){
				System.out.println("Player-1 won the battle");
				break;
			}
		}
	}
}
