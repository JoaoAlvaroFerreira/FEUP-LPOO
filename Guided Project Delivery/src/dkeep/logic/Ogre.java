package dkeep.logic;

import java.util.Random;

public class Ogre extends Character{

	private int posmx; 
	private int posmy; //posicao da moca
	private boolean stunned = false;
	
	
	/**
	 * constructor for the ogre class
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Ogre(int x, int y) {
		super(x, y, 'O');
	}

	/**
	 * returns the x position of the ogre's club
	 * @return the x position of the ogre's club
	 */
	public int getMocaX() {
		return posmx; 
	}
	/**
	 * returns the y position of the ogre's club
	 * @return the y position of the ogre's club
	 */
	public int getMocaY() {
		return posmy; 
	}
	/**
	 * returns the stunned status of the ogre
	 * @return the stunned status of the ogre
	 */
	public boolean isStunned()
	{
		return stunned;
	}

	/**
	 * enables the ogre to get hit 
	 */
	
	public void getHit()
	{
		stunned = true;
		setIcon('8');
	}
	
	/**
	 * enables the ogre to recover from a hit
	 */
	public void recovery() {
		stunned = false;
		setIcon('O');
	}
	
	/**
	 * enables the ogre to move
	 * @param b the board in which the ogre moves in
	 */
	public void ogreMove(Board b) {
		
		if(isStunned())
		{
			Random rand = new Random();
			int stun = rand.nextInt(2);
			if(stun == 0)
				recovery();
			
			return;
		}
		Random rand = new Random();
		char str = ' ';
		int Walk = rand.nextInt(4);
		switch(Walk) {
		case 0:
			str = 'w';
			break;
		case 1:
			str = 'a';
			break;
		case 2:
			str = 's';
			break;
		case 3:
			str = 'd';
			break;
		
		}

		this.Move(str, b);
	}
	/**
	 * enables the ogre to smash with his club
	 */
	public void SMASH()
	{
		Random rand = new Random();

		int Smash = rand.nextInt(3);
		
		switch(Smash) {
	
		case 0:  
			posmx = this.getX()+1;
			posmy = this.getY();
			break;
		case 1:  
			posmx = this.getX();
			posmy = this.getY()+1;
			break;
		case 2:  
			posmx = this.getX()-1;
			posmy = this.getY();
			break;
		case 3:  
			posmx = this.getX();
			posmy = this.getY()-1;
			break;
		}
		
		if(posmx == 9)
			posmx = 8;
		if(posmy == 9)
			posmy = 8;
	}

}
