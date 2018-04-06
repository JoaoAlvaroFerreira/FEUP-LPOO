package dkeep.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dkeep.logic.Board;
import dkeep.logic.Guard;
import dkeep.logic.GuardDrunken;
import dkeep.logic.GuardRookie;
import dkeep.logic.GuardSuspicious;
import dkeep.logic.Hero;
import dkeep.logic.Ogre;
import dkeep.cli.Game_array;
import dkeep.gui.GraphicalMap;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;


public class GameGUI {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblGuardPersonality;
	private JLabel lblGameStatus;
	private GraphicalMap mapa;
	private static Game_array jogo;
	private static Board novoJogo = new Board();
	JButton btnNewButton = new JButton("Up");
	JButton btnNewButton_1 = new JButton("Down");
	JButton btnNewButton_2 = new JButton("Left");
	JButton btnNewButton_3 = new JButton("Right");
	JButton btnSaveButton = new JButton("Save");
	JButton btnLoadButton = new JButton("Load");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					jogo = new Game_array();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	public void movement(char c) {		

		if (jogo.getExit() == 0) {
			
			novoJogo = jogo.Level(c,novoJogo);
			mapa.loadBoard(novoJogo.VirtualBoard());
			mapa.updateUI();
		
			mapa.repaint();
			//mapa.paintComponent(novoJogo.getBoard());
			lblGameStatus.setText("First level");
		}
		
		else if (jogo.getExit() == 1) {
			jogo.Level(c,novoJogo);
			mapa.loadBoard(novoJogo.VirtualBoard());
			mapa.repaint();
			//textArea.setText(novoJogo.getBoard().toString());
			lblGameStatus.setText("Second level.");}
		
			else if (jogo.getExit() == 2) {
			lblGameStatus.setText("You win! Congratulations!");
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(false);
			btnNewButton_2.setEnabled(false);
			btnNewButton_3.setEnabled(false);
			
		}
			else if (jogo.getExit() == -1){
			lblGameStatus.setText("You lose, try to get better!.");
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(false);
			btnNewButton_2.setEnabled(false);
			btnNewButton_3.setEnabled(false);
		}else{
			lblGameStatus.setText("...");
		}
		mapa.requestFocusInWindow();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 760, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		mapa = new GraphicalMap();
		mapa.setBackground(Color.WHITE);
		mapa.setBounds(236, 20, 500, 500);
		mapa.loadSource();
		mapa.loadBoard(novoJogo.VirtualBoard());
		mapa.addKeyListener(new KeyListener() {  
			
			@Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

          
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT: 
					movement('a');
					break;
				case KeyEvent.VK_RIGHT:
					movement('d');
					break;
				case KeyEvent.VK_UP: 
					movement('w');
					break;
				case KeyEvent.VK_DOWN: 
					movement('s');
					break;
				 }	
				
			}

		
			}
        );						
		mapa.setFocusable(true);
		frame.getContentPane().add(mapa);
		
				
		JLabel lblNewLabel = new JLabel("Number of Ogres: ");
		lblNewLabel.setBounds(10, 11, 104, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(107, 14, 119, 20);
		textField.setText("0");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblGuardPersonality = new JLabel("Guard Personality:");
		lblGuardPersonality.setBounds(10, 47, 94, 14);
		frame.getContentPane().add(lblGuardPersonality);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Suspicious", "Rookie", "Drunken"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(107, 45, 119, 17);
		frame.getContentPane().add(comboBox);
		

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_1.setBounds(107, 73, 119, 20);
		frame.getContentPane().add(comboBox_1);
		
		btnSaveButton.setEnabled(false);
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jogo.saveGame(novoJogo);
			}});

		btnSaveButton.setBounds(10, 440, 216, 23);
		frame.getContentPane().add(btnSaveButton);
		
		btnLoadButton.setEnabled(false);
		btnLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novoJogo = jogo.getBoard();
			}});

		btnLoadButton.setBounds(10, 470, 216, 23);
		frame.getContentPane().add(btnLoadButton);
		
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movement('w');
			}
		});
		btnNewButton.setBounds(70, 181, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movement('s');
			}
		});
		btnNewButton_1.setBounds(70, 249, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movement('a');
			}
		});
		btnNewButton_2.setBounds(10, 215, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movement('d');
			}
		});
		btnNewButton_3.setBounds(132, 215, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitGame.setBounds(10, 500, 216, 23);
		frame.getContentPane().add(btnQuitGame);
		
		lblGameStatus = new JLabel("Game Status");
		lblGameStatus.setBounds(21, 603, 223, 14);
		frame.getContentPane().add(lblGameStatus);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(49, 76, 46, 14);
		frame.getContentPane().add(lblLevel);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				novoJogo = new Board();
				
				Guard guarda = new Guard(1,8);
				
				
				if(comboBox.getSelectedItem().toString() == "Suspicious")
				{
					guarda = new GuardSuspicious(1,8);
				}
				else if(comboBox.getSelectedItem().toString() == "Drunken")
				{
					guarda = new GuardDrunken(1,8);
				}
				else if(comboBox.getSelectedItem().toString() == "Rooki")
				{
					guarda = new GuardRookie(1,8);
				}
				
				novoJogo.addGuard(guarda);

			if (textField.getText().equals("") || Integer.parseInt(textField.getText()) > 5)
					{
					lblGameStatus.setText("Escolhe um numero valido!!");
					}
			
				for(int i = 0; i < Integer.parseInt(textField.getText()); i++)
				{	
					
					Random rand = new Random();
					int x = rand.nextInt(8);
					x++;
					int y = rand.nextInt(8);
					y++;
					
				
					Ogre shrek = new Ogre(x,y);
					novoJogo.addOgre(shrek);					
				}
				
				
				Hero heroi = new Hero(1,1);
				jogo.setExit(0);
				if(comboBox_1.getSelectedItem().toString() == "2")
				{
					jogo.setExit(1);
					novoJogo.newBoard();
					
				}
				novoJogo.setHero(heroi);
				
				btnNewButton.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				btnNewButton_3.setEnabled(true);
				btnSaveButton.setEnabled(true);
				btnLoadButton.setEnabled(true);
				mapa.loadBoard(novoJogo.VirtualBoard());
				mapa.repaint();
				mapa.requestFocusInWindow();
			}
		});
		btnNewGame.setBounds(10, 410, 216, 23);
		frame.getContentPane().add(btnNewGame);		
		
		
	}
}
