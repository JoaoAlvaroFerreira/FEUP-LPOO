package dkeep.logic;

public class Guard extends Character{

	protected boolean asleep = false;
	protected boolean correctDirection = true;
	private int n = 0; // movimento do guarda
	private char guardkeys[] = {'a', 's', 's', 's', 's', 'a', 'a', 'a',
			'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd', 'd', 'd', 'w', 'w',
			'w', 'w', 'w'};
	
	/**
	 * constructor for guard class
	 * @param x
	 * @param y
	 */
	public Guard(int x, int y) {
		super(x, y, 'G');
	}
	
	/**
	 * updates the counter on the guard travel
	 */
	public void updateGuard()
	{
		n++;
		if (n == 24)
			n = 0;
	}
	
	/**
	 * auxiliary function to reverse the guard movement
	 */
	public void reverseGuard()
	{
		if(n == 0)
			n = 24;
		n--;
		
	}
	/**
	 * reverses the direction of the guard's movement
	 * @param c the original direction of his movement
	 * @return the new direction
	 */
	protected char reverseMotion(char c) {
		switch(c) {
		case 'w':
			return 's';
		case 's':
			return 'w';
		case 'a':
			return 'd';
		case 'd':
			return 'a';
		default:
			return ' ';
		}
		
	}
	
	/**
	 * generic guard movement function
	 * @param b the board he's moving in
	 */
	
	public void moveGuard(Board b) {
		char movimento = guardkeys[n];
		updateGuard();
		this.Move(movimento,b);
	}
	
	/**
	 * returns the guard path
	 * @return guard path
	 */
	public char[] getGuardKeys()
	{
		return guardkeys;
	}
	
	/**
	 * gets the current step of his path the guard is on
	 * @return the number of his step
	 */
	
	public int getMovementNumber()
	{
		return n;
	}
	
	/**
	 * gets if the guard is asleep or not
	 * @return asleep
	 */
	public boolean getAsleep()
	{
		return asleep;
	}

}
