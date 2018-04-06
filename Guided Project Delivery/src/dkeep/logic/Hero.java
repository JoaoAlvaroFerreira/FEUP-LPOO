package dkeep.logic;

public class Hero extends Character {

	private boolean hasKey = false;
	private boolean armed = false;
	private boolean alive = true;
	
	/**
	 * constructor for a hero
	 * @param x
	 * @param y
	 */
	public Hero(int x, int y) {
		super(x,y,'H');
		armed = false;	
	}
	/**
	 * returns the living status of the hero
	 * @return alive
	 */
	public boolean getAlive()
	{
		return alive;
	}
	
	/**
	 * enables the hero to find a weapon between levels, letting him stun ogres
	 */
	public void findWeapon() {
		armed = true;
		setIcon('A');
		if(hasKey)
			setIcon('V');
	}
	/**
	 * returns if the hero has a weapon or not
	 * @return armed
	 */
	
	public boolean isArmed() {
		return armed;
	}
	
	/**
	 * returns if the hero has a key or not
	 * @return hasKey
	 */
	public boolean hasKey() {
		return hasKey;
	}
	
	/**
	 * enables the hero to find a key
	 */
	public void gotKey()
	{
		hasKey = true;
		setIcon('V');
	}
	
	/**
	 * enables hero collision with a guard
	 * @param g the guard to collide with
	 * @return if he got hit
	 */
	public boolean heroCollision(Guard g) {
		if(g.getAsleep())
			return false;
		else {
		if ((getX() == g.getX() && g.getY() == getY())
				|| ((getX() + 1) == g.getX() && getY() == g.getY())
				|| (getX() == g.getX() && (getY() + 1) == g.getY())
				|| ((getX() - 1) == g.getX() && getY() == g.getY())
				|| (getX() == g.getX() && (getY() - 1) == g.getY())) {
			alive = false;
			return true;
		}
		}
		return false;
	}
	
	/**
	 * enables ogres to hit the hero
	 * @param o ogre
	 * @return if he hit the ogre
	 */
	public boolean heroCollision2(Ogre o) {
		if ((getX() == o.getX() && getY() == o.getY()) || (getX() == o.getMocaY() && getY() == o.getMocaY())){
			alive = false;
			return true;
		}
		return false;
	}
	
	/**
	 * enables the hero to hit the ogre
	 * @param o ogre
	 * @return if he hit the ogre or not
	 */
	public boolean heroCollision3(Ogre o) {

		if(armed)
			return false;
		if(getX()-1 <= o.getX() && getX()+1 >= o.getX() && getY()-1 <= o.getY() && getY()+1 >= o.getY() && armed)
		{
			o.getHit();
			return true;
		}
		return false;
		
	}
}