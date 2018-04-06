package dkeep.logic;

public class Character{
	
	private int posx;
	private int posy; 
	private char icon;
	
	/**
	 * constructor for any character
	 * @param x x coordinate for a character
	 * @param y y coordinate for a character
	 */
	public Character(int x, int y)
	{
		posx = x;
		posy = y;
		icon = 'c';
	}
	
	/**
	 * constructor for character including their specific icon
	 * @param x x coordinate for a character
	 * @param y y coordinate for a character
	 * @param i the icon for the character
	 */
	public Character(int x, int y, char i)
	{
		posx = x;
		posy = y;
		icon = i;
	}
	
	/**
	 * returns the x position of the character
	 * @return x coordinate
	 */
	public int getX() {
		return posx;
	}; 
	
	/**
	 * returns the y position of the character
	 * @return y coordinate
	 */
	
	public int getY() {
		return posy;
	};
	
	/**
	 * returns the character's icon
	 * @return the icon
	 */
	
	public char getIcon() {
		return icon;
	}; 
	
	/**
	 * sets a new x coordinate for the character
	 * @param x x coordinate
	 */

	public void setX(int x)
	{
		posx = x;
	}
	
	/**
	 * sets a new y coordinate for the character
	 * @param y y coordinate
	 */
	public void setY(int y)
	{
		posy = y;
	}
	
	/**
	 * sets a new icon for the character
	 * @param c icon
	 */
	
	public void setIcon(char c)
	{
		icon = c;
	}
	
	/**
	 * basic movement function for any character
	 * @param str the direction they're moving, based on the key
	 * @param b the board they're moving in
	 */
	public void Move(char str, Board b) {

	
		if(b.getNextChar(str, this) == 'I'||b.getNextChar(str, this) == 'X')
			return;
		
		switch (str) {

		case 'w':
		posx = posx - 1;
		if(posx<0)
			posx = 0;
		break;

		case 'd':
		{
		posy = posy + 1;
		if(posy > 10)
			posy = 10;
		break;
			}

		case 's':
		posx = posx + 1;
		if(posx > 10)
			posx = 10;
		break;

		case 'a':
		posy = posy - 1;
		if(posy < 0)
			posy = 0;
		break;
			
		default:
			break;
		}
	}
	
}
