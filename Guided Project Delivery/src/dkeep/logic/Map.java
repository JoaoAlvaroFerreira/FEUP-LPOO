package dkeep.logic;

public class Map {


private int nivel;
private char[][] board = null;

private char[][] board1 = {
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

private char[][] board2 = {
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

/**
 * generic constructor for the map class, the basic board underneath the characters
 */

	public Map(){
	board = board1;
}
	
	/**
	 * constructor for a custom map
	 * @param novomap the new map 
	 */
	public Map(char[][] novomap) {
		board = novomap;
	}
	
	/**
	 * enables the map to change between level 1 and 2
	 */
	
	public void nextLevel() {
		
		nivel = 2;
		board = board2;
	}
	
	/**
	 * sets the current map to be something else
	 * @param newBoard the new map
	 */
	public void setBoard(char[][] newBoard)
	{
		
		board = newBoard;
	}
	
	/**
	 * returns the current map
	 * @return the current map
	 */
	public char[][] getBoard(){
		return board;
	}
	/**
	 * changes the doors the hero can go through from closed to open
	 */
	
	public void openDoors() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'I') {
				board[i][0] = 'S';
			}
		}
	}
}