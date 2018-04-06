package dkeep.logic;

import java.util.Random;

public class GuardDrunken extends Guard{
	
	
	/**
	 * drunken guard constructor
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public GuardDrunken(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Drunken guard movement function
	 */
	@Override
	public void moveGuard(Board b) {
		char guardchaves[] = getGuardKeys();
		sleep();
		if(asleep) {
			Random rand = new Random();
			int sleep = rand.nextInt(5);
			if(sleep == 0)
				wakeUp();
			else return;
		}
		if(correctDirection) {
		
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
	 * method to make the guard sleep
	 */
	private void sleep()
	{
		Random rand = new Random();
		int sleep = rand.nextInt(5);
		if(sleep == 0)
			asleep = !asleep;
		setIcon('g');
	}
	/**
	 * method to wake the guard up
	 */
	
	private void wakeUp() {
		Random rand = new Random();
		int direction = rand.nextInt(1);
		if(direction == 0)
			correctDirection = !correctDirection;
		setIcon('G');
	}
	

}
