package dkeep.logic;

import java.util.Random;

public class GuardSuspicious extends Guard {

/**
 * constructor for the suspicious guard class
 * @param x x coordinate
 * @param y y coordinate
 */
	public GuardSuspicious(int x, int y) {
		super(x, y);
	}

	/**
	 * 
	 */
	
	/**
	 * movement function for the suspicious guard
	 */
	@Override
	public void moveGuard(Board b) {
		char guardchaves[] = getGuardKeys();
		suspicion();
		if(correctDirection)
		{
			char movimento = guardchaves[getMovementNumber()];
			updateGuard();
			this.Move(movimento,b);
			
		}
		
		else{
			reverseGuard();
			char movimento = guardchaves[getMovementNumber()];
			this.Move(reverseMotion(movimento),b);
		}
	}
	
	/**
	 * auxiliar function for his movement, enabling his suspicion
	 */

	private void suspicion()
	{
		Random rand = new Random();
		int suspicion = rand.nextInt(6);
		if(suspicion == 0)
			correctDirection = !correctDirection;
	}
}
