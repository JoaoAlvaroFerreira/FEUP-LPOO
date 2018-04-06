package dkeep.logic;

import java.util.ArrayList;

public class Board {

	private Hero heroi = new Hero(1,1);
	private ArrayList<Guard> guardas = new ArrayList<Guard>();
	private ArrayList<Ogre> swamp;

	private int posax = 8;
	private int posay = 6; // posicao da alvanca
	
	private int poscx = 1; 
	private int poscy = 8; //posicao da chave
	
	private int possx = 6; 
	private int possy = 0; //posição da saída
	private int nivel;
	
	private boolean alavancaUsed = false;
	
	private Map mapa;
	
	/**
	 * Constructor for class Board
	 */
	
	public Board() {
		guardas = new ArrayList<Guard>();
		swamp = new ArrayList<Ogre>();
		mapa = new Map();
		nivel = 1;
	}
	
	/**
	 * Method that does the "level change", from Dungeon to Keep, updating the board and its attributes
	 */
	
	public void newBoard()
	{	
		mapa.nextLevel();
		nivel = 2;
		setAlavanca(25, 25);
		setKey(5,5);
		heroi = new Hero(1,1);
		
	}
	
	/**
	 * Sets a custom board as the board currently in use.
	 * @param newBoard 
	 */
	
	public void setBoard(char[][] newBoard)
	{
		
		mapa.setBoard(newBoard);
	}
	
	/**
	 * Returns the current board
	 * @return
	 */
	public char[][] getBoard()
	{
		return mapa.getBoard();
	}
	
	/**
	 * Clears the guards ArrayList
	 */
	public void clearGuards() {
		guardas.clear();
	}
	
	/**
	 * Clears the ogres (swamp) ArrayList
	 */	
	public void clearOgres() {
		swamp.clear();
	}
	
	/**
	 * Adds a guard to the guards ArrayList
	 */
	public void addGuard(Guard g) {
		guardas.add(g);
	}


	/**
	 * Adds an ogre to the ogres (swamp) ArrayList
	 */
	public void addOgre(Ogre o) {
		swamp.add(o);
	}
	
	/**
	 * Sets a new Hero as the current hero for the level
	 * @param h the new hero
	 */
	public void setHero(Hero h)
	{
		heroi = h;
	}
	
	/**
	 * Gives the key new coordinates
	 * @param x x coordinate for key
	 * @param y y coordinate for key
	 */
	public void setChave(int x, int y)
	{
		poscx = x;
		poscy = y;
	}
	
	/**
	 * Gives the lever new coordinates
	 * @param x x coordinate for lever
	 * @param y y coordinate for lever
	 */
	public void setAlavanca(int x, int y)
	{
		posax = x;
		posay = y;
	}
	
	/**
	 * Gives the exit new coordinates
	 * @param x x coordinate for exit
	 * @param y y coordinate for exit
	 */
	public void setExit(int x, int y)
	{
		possx = x;
		possy = y;
	}
	
	/**
	 * Answers if the lever has been pulled or not
	 * @return alavancaUsed
	 */
	
	public boolean getAlavancaUsed()
	{
		return alavancaUsed;
	}
	
	/**
	 * returns the current hero
	 * @return current hero
	 */
	
	public Hero getHero()
	{
		return heroi;
	}
	
	/**
	 * returns the guards arraylist
	 * @return guards arraylist
	 */
	public ArrayList<Guard> getGuards()
	{
		return guardas;
	}
	
	/**
	 * returns the ogres arraylist
	 * @return ogres arraylist
	 */
	public ArrayList<Ogre> getOgres()
	{
		return swamp;
	}


	/**
	 * returns the next char in a certain direction of the board, relative to a certain character
	 * @param n the char indicative of the direction the character wants to walk in
	 * @param c the character
	 * @return the char in a certain direction of the board
	 */
	public char getNextChar(char n, Character c) //vê qual é o caracter adjacente ao heroi na direção escolhida
	{
		switch(n){
			
			case 'w':
			return mapa.getBoard()[c.getX()-1][c.getY()];
			
			case 'd':
			return mapa.getBoard()[c.getX()][c.getY()+1];
			
			case 'a':
			return mapa.getBoard()[c.getX()][c.getY()-1];
			
			case 's':
			return mapa.getBoard()[c.getX()+1][c.getY()];
		}
		return 'E';
	}
	
	/**
	 * returns the map with all the characters already inserted in it, for easy conversion by the graphics package
	 * @return the map with all the characters
	 */
	public Map VirtualBoard() {
	
	char[][] s = new char[10][10];
	    
	    for (int i=0; i < 10; i++) {
	        for (int j=0; j < 10; j++) {
	        	
	        	
	        	if(heroi.getX() == i && heroi.getY() == j) //imprime chave
				{	
	        		System.out.print(heroi.getIcon());
	        		s[i][j] = heroi.getIcon();
	        		if(nivel == 2) {
	        			heroi.findWeapon();
	        		
	        		}
					continue;
					}
	        
	        	if(guardas.size() > 0) {
					if(guardas.get(0).getX() == i && guardas.get(0).getY() == j &&  nivel == 1)
					{
						
						
						s[i][j] = guardas.get(0).getIcon();
						continue;
						
					}}
				
	        	
					
	        	if(!swamp.isEmpty()) {
	        		if(swamp.get(0).getX() == i && swamp.get(0).getY() == j &&  nivel == 2)
					{
					
						s[i][j] = swamp.get(0).getIcon();
						continue;
						
					}
				
					if(swamp.get(0).getMocaX() == i && swamp.get(0).getMocaY() == j && nivel == 2)
					{
						
						s[i][j] = 'P';
						continue;
						
						}
					if(swamp.size() > 1)
					{
						if(swamp.get(1).getX() == i && swamp.get(1).getY() == j &&  nivel == 2)
						{
						
							s[i][j] = swamp.get(1).getIcon();
							continue;
							
						}
					
						if(swamp.get(1).getMocaX() == i && swamp.get(1).getMocaY() == j && nivel == 2)
						{
							
							s[i][j] = 'P';
							continue;
							
							}
						
						if(swamp.size() > 2)
						{
							if(swamp.get(2).getX() == i && swamp.get(2).getY() == j &&  nivel == 2)
							{
							
								s[i][j] = swamp.get(2).getIcon();
								continue;
								
							}
						
							if(swamp.get(2).getMocaX() == i && swamp.get(2).getMocaY() == j && nivel == 2)
							{
								
								s[i][j] = 'P';
								continue;
								
								}
							
							if(swamp.size() > 3)
							{if(swamp.get(3).getX() == i && swamp.get(3).getY() == j &&  nivel == 2)
							{
							
								s[i][j] = swamp.get(3).getIcon();
								continue;
								
							}
						
							if(swamp.get(3).getMocaX() == i && swamp.get(3).getMocaY() == j && nivel == 2)
							{
								
								s[i][j] = 'P';
								continue;
								
								}}
						}
					}
						
					
	        	}
				if(poscx == i && poscy == j ) //imprime chave
				{
					
					s[i][j] = 'k';
					continue;	
	
				}
				if(posax == i && posay == j) //imprime alavanca
				{
				
					s[i][j] = 'l';
					continue;			
				}
				
				
				s[i][j] = mapa.getBoard()[i][j];
	        }
	       
	    }
	    
	    Map sMapa = new Map(s);
	    return sMapa;
	}	
	
	/**
	 * opens the door after a lever has been pulled
	 */
	
	public void alterExit(){
		
		if ((heroi.getX() == 8 && heroi.getY() == 7)||(heroi.getX() == 8 && heroi.getY() == 6)) {
			alavancaUsed = true;
			mapa.openDoors();
		}
	}
	
	/**
	 * the hero picks up the key and it gets moved off-screen
	 */
	public void getsKey()
	{
		
		if (heroi.getX() == poscx && heroi.getY() == poscy) {
			poscx = 25;
			poscy = 25;
			heroi.gotKey();
		}
	}
	
	/**
	 * changes the coordinates of the key
	 * @param x x coordinate for key
	 * @param y y coordinate for key
	 */
	public void setKey(int x, int y)
	{
		
		poscx = x;
		poscy = y;
			
	}
	
	/**
	 * lets the hero exit the level if he's in the right place and has already opened the door or has a key
	 * @param str the direction the hero has to walk in to leave the level
	 * @return if hero left the level or not
	 */
	public boolean heroExit(char str) {
		
		if (((heroi.getX() == possx && heroi.getY() == possy && str == 'a')||(heroi.getX() == 6 && heroi.getY() == 1 && str == 'a')||(heroi.getX() == 5 && heroi.getY() == 1 && str == 'a')) && (heroi.hasKey()||alavancaUsed)) {
			alterExit();
			return true;
		}
	
		return false;
}
	
}
