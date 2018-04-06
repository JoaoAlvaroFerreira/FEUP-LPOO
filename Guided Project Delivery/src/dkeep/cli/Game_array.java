package dkeep.cli;

import dkeep.logic.Board;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Ogre;

public class Game_array {
	int exit = 0;
	Board currentBoard;
	
public Game_array()
{}

public int getExit()
{
	return exit;
}

public void setExit(int i)
{
	exit = i;
}

public Board getBoard()
{
	return currentBoard;
}

public void saveGame(Board b)
{
	currentBoard = b;
}

//ITERATION 1/2
public void LevelOneLoad() {

exit = 0;

Board board = new Board();
Hero heroi = new Hero(1,1);
Guard guarda = new Guard(1,8);

board.setHero(heroi);
board.addGuard(guarda);

currentBoard = board;


}
public void LevelOneLoop(char str, Board board) {
		
	board.getHero().Move(str, board);
	
	// quando chega à alavanca as portas abrem ('I' -> 'S')
	board.alterExit();

	// mover guardas
	for(int i = 0; i < board.getGuards().size(); i++)
	{
		board.getGuards().get(i).moveGuard(board);
	}

	// desenha o tabuleiro

	// se o heroi e um guarda se encontarem perde-se o jogo
	for(int i = 0; i < board.getGuards().size(); i++)
	{
		board.getHero().heroCollision(board.getGuards().get(i));
	}
	
	
}
public void LevelTwoLoad() {
	

exit = 0;

Ogre Shrek = new Ogre(5,5);
Ogre Fiona = new Ogre(2,2);

Hero heroi = new Hero(1,8);

Board board = new Board();


board.setChave(8, 8);

board.setHero(heroi);
board.getHero().findWeapon();

board.addOgre(Shrek);
board.addOgre(Fiona);
System.out.println();



}
public void LevelTwoLoop(char str, Board board) {
	
	// HEROI
	if(board.getHero().hasKey()) {
	if(board.heroExit(str))
	{
		System.out.println();
		System.out.println("Parabens, ganhaste");
		exit = 1;
	}
	}

	board.getHero().Move(str, board);
	
	

	// when the hero picks the key variable turns 1
	board.getsKey();
	
	// se o heroi e o Ogre ou a moca se encontarem perde-se o jogo
	for(int i = 0; i < board.getOgres().size(); i++)
	{	
		if(!board.getHero().heroCollision3(board.getOgres().get(i)))
		board.getHero().heroCollision2(board.getOgres().get(i));
}
	
	// OGRE MOVE
		for(int i = 0; i < board.getOgres().size(); i++)
		{
			if(!board.getOgres().get(i).isStunned())
			{
			board.getOgres().get(i).ogreMove(board);
			board.getOgres().get(i).SMASH();
			}
		}
		
}

//ITERATION 3
public void LevelTestLoad() {


exit = 0;

Board board = new Board();
char[][] newBoard = 
{{ 'X', 'X', 'X', 'X','X' },
{ 'X', ' ', ' ', ' ', 'X' },
{ 'I', ' ', ' ', ' ', 'X' },
{ 'X', ' ', ' ', ' ', 'X' },
{ 'X', 'X', 'X', 'X', 'X' } };

board.setBoard(newBoard);
Hero heroi = new Hero(1,1);
Guard guarda = new Guard(1,3);
board.setAlavanca(1, 2);
board.setExit(2,0);
board.setHero(heroi);
board.addGuard(guarda);

currentBoard = board;
}
public void LevelTestLoop(char str, Board board) {
	board.VirtualBoard();
	board.getHero().Move(str, board);
	//verifica se usou a alavanca
	board.alterExit();
	board.VirtualBoard();
	// se o heroi e um guarda se encontarem perde-se o jogo
	for(int i = 0; i < board.getGuards().size(); i++)
	{
		board.getHero().heroCollision(board.getGuards().get(i));
	}
	
	
	
}
public void LevelTestLoadDois() {

exit = 0;

Board board = new Board();
char[][] newBoard = 
{{ 'X', 'X', 'X', 'X','X' },
{ 'X', ' ', ' ', ' ', 'X' },
{ 'I', ' ', ' ', ' ', 'X' },
{ 'X', ' ', ' ', ' ', 'X' },
{ 'X', 'X', 'X', 'X', 'X' } };

board.setBoard(newBoard);
Hero heroi = new Hero(1,1);
Ogre Shrek = new Ogre(1,3);
board.setExit(0,2);
board.setKey(3, 1);
board.setHero(heroi);
board.addOgre(Shrek);

currentBoard = board;

}
public void LevelTestLoopDois(char str, Board board) {
	
	// HEROI
	if(board.getHero().hasKey()) {
	if(board.heroExit(str))
	{
		System.out.println();
		System.out.println("Parabens, ganhaste");
		exit = 1;
	}
	}

	board.getHero().Move(str, board);
	
	

	// when the hero picks the key variable turns 1
	board.getsKey();
	
	// se o heroi e o Ogre ou a moca se encontarem perde-se o jogo
	for(int i = 0; i < board.getOgres().size(); i++)
	{	
		if(!board.getHero().heroCollision3(board.getOgres().get(i)))
		board.getHero().heroCollision2(board.getOgres().get(i));
}
	
	// OGRE MOVE
	/*	for(int i = 0; i < board.getOgres().size(); i++)
		{
			if(!board.getOgres().get(i).isStunned())
			{
			board.getOgres().get(i).ogreMove(board);
			board.getOgres().get(i).SMASH();
			}
		}
		*/
	
	
}


//ITERATION 4
public Board Level(char str, Board board) {
	
	if(exit == 0) {
	board.getHero().Move(str, board);
	
	// quando chega à alavanca as portas abrem ('I' -> 'S')
	board.alterExit();

	// mover guardas
	for(int i = 0; i < board.getGuards().size(); i++)
	{
		board.getGuards().get(i).moveGuard(board);
	}

	// se o heroi e um guarda se encontarem perde-se o jogo
	for(int i = 0; i < board.getGuards().size(); i++)
	{
		if(board.getHero().heroCollision(board.getGuards().get(i)))
			exit = -1;
	}
	if(board.heroExit(str))
		{exit = 1;
		board.newBoard();
		Hero novoheroi = new Hero(1,1);
		Ogre shrek = new Ogre(4,4);
		board.setHero(novoheroi);
		board.addOgre(shrek);
		board.setAlavanca(25, 25);
		board.setChave(5, 5);
		}
	
	}
	
	if(exit == 1)
	{
		// HEROI
		board.getHero().Move(str, board);
		if(board.getHero().hasKey()) {
		if(board.heroExit(str))
		{
			
			exit = 2;
		}
		}

		
		
		// when the hero picks the key variable turns 1
		board.getsKey();
		
		// se o heroi e o Ogre ou a moca se encontarem perde-se o jogo
		for(int i = 0; i < board.getOgres().size(); i++)
		{	
			board.getHero().heroCollision3(board.getOgres().get(i));
			if(board.getHero().heroCollision2(board.getOgres().get(i)))
				exit = -1;
			
			
			
	}
		
		// OGRE MOVE
			for(int i = 0; i < board.getOgres().size(); i++)
			{
				if(!board.getOgres().get(i).isStunned())
				{
				board.getOgres().get(i).ogreMove(board);
				board.getOgres().get(i).SMASH();
				}
			}
			
	}
	
	return board;

	
}

public void LossState()
{

	System.out.println("Perdeste o jogo!! És mau, recarrega o jogo! \n");

}


}
