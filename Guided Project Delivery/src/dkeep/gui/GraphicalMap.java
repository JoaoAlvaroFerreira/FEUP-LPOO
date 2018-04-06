package dkeep.gui;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dkeep.logic.Board;
import dkeep.logic.Map;

public class GraphicalMap extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map b;
	private Image Link;
	private Image Ganon;
	private Image Wall;
	private Image Knight;
	private Image Shrek;
	private Image Botao;
	private Image Moca;
	private Image Door;
	private Image Key;
	private Image KeyHero;
	private Image Sword;
	private Image Chao;
	private Image OpenDoor;
	/**
	 * Create the panel.
	 */
	public void reSizePanel(int novoSize)
	{
		this.setLayout(new GridLayout(novoSize, novoSize));
		//this.setBounds(80,80);
	}
	
	public Image reSizeIcon(ImageIcon icon)
	{
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / 10, this.getHeight() / 10, Image.SCALE_FAST);

		return newimg;
	}
	
	public void loadSource()
	{

		Link = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/baixo.png")));
		Ganon = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/ganon.png")));
		Wall = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/parede.png")));
		Moca = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/buraco.png")));
		Botao = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/botao.png")));
		Door = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/door.png")));
		OpenDoor = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/opendoor.png")));
		Key = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/triforce.png")));
		KeyHero = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/linkcarryingkey.png")));
		Knight = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/shovelknight.png")));
		Shrek = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/shrek.png")));
		Sword = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/linkwithsword.png")));
		Chao = reSizeIcon(new ImageIcon(this.getClass().getResource("resources/chao.png")));
	}
	
	public void loadBoard(Map jogo)
	{
		b = jogo;
	}
	
	public GraphicalMap() {
		super();
	}

		@Override
	protected void paintComponent(Graphics g)
	{
			
		char c;
		super.paintComponent(g);
		
	
		for(int i = 0; i < b.getBoard().length; i++)
		{
			for(int j = 0; j < b.getBoard()[i].length; j++)	
			{
				c = b.getBoard()[j][i];
				
				
				switch (c) {
				case ' ':
					g.drawImage(Chao, 50*i,50*j,null);
					break;
				case 'X':
					g.drawImage(Wall, 50*i, 50*j, null);
					break;
				case 'I':
					g.drawImage(Door, 50*i, 50*j, null);
					break;
				case 'l':
					g.drawImage(Botao, 50*i,50*j, null);
					break;
				case 'G':
					g.drawImage(Knight, 50*i, 50*j, null);
					break;
				case 'H':
					g.drawImage(Link, 50*i, 50*j, null);
					break;
				case 'k':
					g.drawImage(Key, 50*i, 50*j, null);
					break;
				case 'V':
					g.drawImage(KeyHero, 50*i, 50*j, null);
					break;
				case 'S':
					g.drawImage(OpenDoor, 50*i, 50*j, null);
					break;
				case 'O':
					g.drawImage(Ganon, 50*i, 50*j, null);
					break;
				case 'A':
					g.drawImage(Sword, 50*i, 50*j, null);
					break;
				case 'K':
					g.drawImage(Key, 50*i, 50*j, null);
					break;
				case '8':
					g.drawImage(Shrek, 50*i, 50*j, null);
					break;
				case 'P':
					g.drawImage(Moca, 50*i, 50*j, null);
					break;
				case 'g':
					g.drawImage(Shrek, 50*i, 50*j, null);
					break;
				default:
					g.drawImage(Chao, 50*i,50*j,null);
					break;
				}

				

			}
		}
	}
}
