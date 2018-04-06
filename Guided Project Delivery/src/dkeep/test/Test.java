package dkeep.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import dkeep.cli.Game_array;

public class Test {
	
	public void main(String[] args) {
		

	}
	
	//TESTES PARTE 1
		@org.junit.Test
		public void testMoveIntoFreeCell() {
			Game_array jogo = new Game_array();
			jogo.LevelOneLoad();
			assertEquals(1, jogo.getBoard().getHero().getX());
			assertEquals(1, jogo.getBoard().getHero().getY());
			jogo.LevelOneLoop('d',jogo.getBoard());
			assertEquals(1, jogo.getBoard().getHero().getX());
			assertEquals(2, jogo.getBoard().getHero().getY());
		}
			
		@org.junit.Test
		public void testMoveIntoWall() {
				Game_array jogo = new Game_array();
				jogo.LevelOneLoad();
				assertEquals(1, jogo.getBoard().getHero().getX());
				assertEquals(1, jogo.getBoard().getHero().getY());
				jogo.LevelOneLoop('w',jogo.getBoard());
				assertEquals(1, jogo.getBoard().getHero().getX());
				assertEquals(1, jogo.getBoard().getHero().getY());
				
			}
		
		@org.junit.Test
		public void testGuardCollision() {
				Game_array jogo = new Game_array();
				jogo.LevelTestLoad();
				assertEquals(1, jogo.getBoard().getHero().getX());
				assertEquals(1, jogo.getBoard().getHero().getY());
				jogo.LevelTestLoop('d',jogo.getBoard());
				assertEquals(1, jogo.getBoard().getHero().getX());
				assertEquals(2, jogo.getBoard().getHero().getY());
				assertEquals(false,jogo.getBoard().getHero().getAlive());
				
			}
		
		@org.junit.Test
		public void testDoorCollision() {
				Game_array jogo = new Game_array();
				jogo.LevelTestLoad();
				assertEquals(1, jogo.getBoard().getHero().getX());
				assertEquals(1, jogo.getBoard().getHero().getY());
				jogo.LevelTestLoop('d',jogo.getBoard());
				jogo.LevelTestLoop('a',jogo.getBoard());
				jogo.LevelTestLoop('s',jogo.getBoard());
				jogo.LevelTestLoop('a',jogo.getBoard());
				assertEquals(0, jogo.getExit());
				
			}
		
		@org.junit.Test
		public void testLever() {
				Game_array jogo = new Game_array();
				jogo.LevelTestLoad();
				jogo.LevelTestLoop('d',jogo.getBoard());
				assertEquals(true, jogo.getBoard().getAlavancaUsed());
				
			}
		
		@org.junit.Test 
		public void testLeave() {
		
				Game_array jogo = new Game_array();
				jogo.LevelTestLoad();
				jogo.LevelTestLoop('d',jogo.getBoard());
				jogo.LevelTestLoop('a',jogo.getBoard());
				jogo.LevelTestLoop('s',jogo.getBoard());
				assertEquals(true, jogo.getBoard().heroExit('a'));
				
			}


		//TESTES PARTE 2
		@org.junit.Test
		public void testOgreKill() {
			Game_array jogo = new Game_array();
			jogo.LevelTestLoadDois();
			jogo.LevelTestLoopDois('d',jogo.getBoard());
			jogo.LevelTestLoopDois('d',jogo.getBoard());
			assertEquals(false,jogo.getBoard().getHero().getAlive());
			
		} 
		
		@org.junit.Test
		public void testKeyGet() {
			Game_array jogo = new Game_array();
			jogo.LevelTestLoadDois();
		
			jogo.LevelTestLoopDois('s',jogo.getBoard());
			
			jogo.LevelTestLoopDois('s',jogo.getBoard());
	
			assertEquals('V',jogo.getBoard().getHero().getIcon());
			
		} 
		
		@org.junit.Test
		public void testLeaveFail() {
			Game_array jogo = new Game_array();
			jogo.LevelTestLoadDois();
			jogo.LevelTestLoopDois('s',jogo.getBoard());
			assertEquals(2, jogo.getBoard().getHero().getX());
			assertEquals(1, jogo.getBoard().getHero().getY());
			jogo.LevelTestLoopDois('a',jogo.getBoard());
			assertEquals(2, jogo.getBoard().getHero().getX());
			assertEquals(1, jogo.getBoard().getHero().getY());
			
		} 
		@org.junit.Test
		public void testLeaveSuccess() {
			Game_array jogo = new Game_array();
			jogo.LevelTestLoadDois();
		
			jogo.LevelTestLoopDois('s',jogo.getBoard());
		
			jogo.LevelTestLoopDois('s',jogo.getBoard());
	
			jogo.LevelTestLoopDois('w',jogo.getBoard());
	
			jogo.LevelTestLoopDois('a',jogo.getBoard());
		
			assertEquals(true, jogo.getBoard().heroExit('a'));
		} 
		
		@org.junit.Test
		public void testLeaveGameEnd() {
			Game_array jogo = new Game_array();
			jogo.LevelTestLoadDois();
			jogo.LevelTestLoopDois('s',jogo.getBoard());
			jogo.LevelTestLoopDois('s',jogo.getBoard());
			jogo.LevelTestLoopDois('w',jogo.getBoard());
			jogo.LevelTestLoopDois('a',jogo.getBoard());
			assertEquals(1,jogo.getExit());
			
		} 
}
