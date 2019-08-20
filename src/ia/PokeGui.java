package ia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * This class provides methods for different GUI-windows and uses multithreading 
 * Only "startMainMenu()"-method is public
 * 
 * */
public class PokeGui extends JComponent implements Runnable {

	private static final long serialVersionUID = -2522585051142276013L;
/*
 * my Screensize: 3000x2000  -> width = 857 -> height = 512 -> fontsize = 17
 * adapting sizes to screensize: 
 */
//	final static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//	final static int width = (int)(screen.getWidth()/3.5);
//	final static int height = (int)(screen.getHeight()/3.9);
//	final static int fontsize = (int)(height/30);
	
	final static int width = 1100;
	final static int height = 700;
	final static int fontsize = (int)(height/30);
	static Boolean checkRadioBtnInput = null;
	static int gameControl = 0; // event-driven gameControl with ">>>"-Button. Depending on gameControl-state there will be different actions

			public void run() {
				startMainMenu();
			}
			
	public PokeGui() {
	}

	/*
	 * This method provides main menu with three options: Pokedex[team], start fight, end game 
	 * */
	public void startMainMenu() {	
		PokeGame.randomWildesPoke();
		JFrame fightFrame = new JFrame("Pokemon");
		fightFrame.setBounds(1000, 800, width, height);
		fightFrame.setLocationRelativeTo(null); //override bound-settings with relative location
		fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fightFrame.getContentPane().setLayout(null);
				
		JButton btnstart = new JButton("new fight");
		btnstart.setBounds(550,300, width/4, height/15);
		btnstart.setFont(new Font("inhalt", Font.PLAIN, fontsize+5));
		JButton btnend = new JButton("exit game");
		btnend.setBounds(550,400, width/4, height/15);
		btnend.setFont(new Font("inhalt", Font.PLAIN, fontsize+5));
		JButton btnPokedex = new JButton("Pokedex[team]");
		btnPokedex.setBounds(550,200, width/4, height/15);
		btnPokedex.setFont(new Font("inhalt", Font.PLAIN, fontsize+5));

		fightFrame.getContentPane().add(btnstart);
		fightFrame.getContentPane().add(btnend);
		fightFrame.getContentPane().add(btnPokedex);
		
		ImageIcon index = new ImageIcon(getClass().getResource("index.png"));
		JLabel lblIndex = new JLabel(index);
		lblIndex.setBounds(0, 0, 500, 158);
		fightFrame.getContentPane().add(lblIndex);
		fightFrame.setVisible(true);
		
		btnstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				fightFrame.dispose();
				initializeGuiFight();
			}
		});
		
		btnend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				System.exit(0);
			}
		});
		
		btnPokedex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				fightFrame.dispose();
				viewPokedex();
				
			}
		});
		
		
	}
	
	
	/*
	 * This method provides access to the pokedex[team] and heal-function.
	 * 
	 * */
	
	public void viewPokedex() {
		JFrame fightFrame = new JFrame("Pokemon");
		fightFrame.setBounds(1000, 800, width, height);
		fightFrame.setLocationRelativeTo(null); //override bound-settings with relative location
		fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fightFrame.getContentPane().setLayout(null);
		
		JButton back = new JButton("main menu");
		back.setBounds((int)(width/1.4),(int)(height/20), 250, 70);
		back.setFont(new Font("inhalt",Font.PLAIN,fontsize+2));
		fightFrame.getContentPane().add(back);
		back.setVisible(true);
		
		JButton heal = new JButton("Pokemon heilen");
		heal.setBounds((int)(width/1.4),(int)(height/5), 250, 70);
		heal.setFont(new Font("inhalt",Font.PLAIN,fontsize+2));
		fightFrame.getContentPane().add(heal);
		heal.setVisible(true);
		
		JTextArea pokeInfo = new JTextArea("");
		pokeInfo.setBounds(width/20,height/6,width/2, 230);
		pokeInfo.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(pokeInfo);
		
		JRadioButton radioGlum = new JRadioButton(PokeGame.team[0].getClass().getSimpleName());	
		radioGlum.setBounds(50,((int)(height/1.4)),180,50);
		radioGlum.setFont(new Font("inhalt", Font.PLAIN,fontsize+3));
		
		JRadioButton radioGlut = new JRadioButton(PokeGame.team[1].getClass().getSimpleName());
		radioGlut.setBounds(230,((int)(height/1.4)),180,50);
		radioGlut.setFont(new Font("inhalt", Font.PLAIN,fontsize+3));
		
		JRadioButton radioSchig = new JRadioButton(PokeGame.team[2].getClass().getSimpleName());
		radioSchig.setBounds(410,((int)(height/1.4)),180,50);
		radioSchig.setFont(new Font("inhalt", Font.PLAIN,fontsize+3));

		JRadioButton radioBisa = new JRadioButton(PokeGame.team[3].getClass().getSimpleName());
		radioBisa.setBounds(590,((int)(height/1.4)),180,50);
		radioBisa.setFont(new Font("inhalt", Font.PLAIN,fontsize+3));
		
		JRadioButton radioSchill = new JRadioButton(PokeGame.team[4].getClass().getSimpleName());
		radioSchill.setBounds(770,((int)(height/1.4)),180,50);
		radioSchill.setFont(new Font("inhalt", Font.PLAIN,fontsize+3));
		
		JRadioButton[] btnArr = {radioGlum,radioGlut,radioSchig,radioBisa,radioSchill};
		ButtonGroup group = new ButtonGroup();
		
		for(int i = 0; i< PokeGame.team.length;i++) {
				fightFrame.getContentPane().add(btnArr[i]);
			}

		JLabel lblPic = new JLabel(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[0]))));
		lblPic.setBounds((int)(width/1.9), (int)(height/5.9), 200, 300);
		fightFrame.getContentPane().add(lblPic);
		lblPic.setVisible(false);
		
		group.add(radioGlum);
		group.add(radioGlut);
		group.add(radioSchig);
		group.add(radioBisa);
		group.add(radioSchill);
		
		radioGlum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[0]))));
				pokeInfo.setText(PokeGame.team[0].toString() + "\n" + PokeGame.team[0].lebendig + "\nErfahrungspunkte: " + PokeGame.team[0].erfahrungspunkte);
				lblPic.setVisible(true);
				pokeInfo.setVisible(true);
				lblPic.updateUI();
			}
			
		});
		
		radioGlut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[1]))));
				pokeInfo.setText(PokeGame.team[1].toString() + "\n" + PokeGame.team[1].lebendig + "\nErfahrungspunkte: " + PokeGame.team[1].erfahrungspunkte);
				lblPic.setVisible(true);
				pokeInfo.setVisible(true);
				lblPic.updateUI();

			}
		});
		
		radioSchig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[2]))));
				pokeInfo.setText(PokeGame.team[2].toString() + "\n" + PokeGame.team[2].lebendig + "\nErfahrungspunkte: " + PokeGame.team[2].erfahrungspunkte);
				pokeInfo.setVisible(true);
				lblPic.setVisible(true);
				lblPic.updateUI();
			}
		});
	
		radioBisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[3]))));
				pokeInfo.setText(PokeGame.team[3].toString() + "\n" + PokeGame.team[3].lebendig + "\nErfahrungspunkte: " + PokeGame.team[3].erfahrungspunkte);
				lblPic.setVisible(true);
				pokeInfo.setVisible(true);
				lblPic.updateUI();
			}
		});
				
		radioSchill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.team[4]))));
				pokeInfo.setText(PokeGame.team[4].toString() + "\n" + PokeGame.team[4].lebendig + "\nErfahrungspunkte: " + PokeGame.team[4].erfahrungspunkte);
				lblPic.setVisible(true);
				pokeInfo.setVisible(true);
				lblPic.updateUI();
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				fightFrame.dispose();
				startMainMenu();
				
			}
		});
		
		heal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				pokeInfo.setBackground(Color.white);
				PokeGame.heal();
				pokeInfo.setBackground(new Color(190, 244, 65));
				pokeInfo.setVisible(true);
				pokeInfo.setText("Alle Pokemon wurden geheilt");
				for(int i = 0; i< btnArr.length; i++) {
					if(btnArr[i].isSelected()) {
						pokeInfo.setText(PokeGame.team[i].toString() + "\n" + PokeGame.team[i].lebendig + "\nErfahrungspunkte: " + PokeGame.team[i].erfahrungspunkte);
						break;
					}
				}
				pokeInfo.setVisible(true);
				pokeInfo.updateUI();
			}
		});
		
		fightFrame.setVisible(true);

	}
	
	private void initializeGuiFight()  {
		ImageIcon wildesPokePic = new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.wildesPokemon)));

		JFrame fightFrame = new JFrame("Ein wildes Pokemon greift an ... !");
		fightFrame.setBounds(1000, 800, width, height);
		fightFrame.setLocationRelativeTo(null); //override bound settings with relative location
		fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fightFrame.getContentPane().setLayout(null);
		fightFrame.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, ((int)(height/1.7)),width-10, 70);
		textArea.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(textArea);
			
		//Pictures 
		JLabel lblWildespoke = new JLabel(wildesPokePic);
		lblWildespoke.setBounds(500, 20, 200, 300);
		fightFrame.getContentPane().add(lblWildespoke);
        wildesPokePic.setImage(wildesPokePic.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)); 
        
		JLabel lblStatusWildesPoke = new JLabel(PokeGame.wildesPokemon.toString());
		lblStatusWildesPoke.setBounds(500, 240, 700, 40);
		lblStatusWildesPoke.setFont(new Font("inhalt", Font.PLAIN, (int)(fontsize/1.15)));
		fightFrame.getContentPane().add(lblStatusWildesPoke);
	
		textArea.setEditable(false);
				
		// poke-selection 
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radioGlum = new JRadioButton(PokeGame.team[0].getClass().getSimpleName());	
		radioGlum.setBounds(10,((int)(height/1.4)),180,50);
		radioGlum.setFont(new Font("inhalt", Font.PLAIN,fontsize));
		
		JRadioButton radioGlut = new JRadioButton(PokeGame.team[1].getClass().getSimpleName());
		radioGlut.setBounds(190,((int)(height/1.4)),180,50);
		radioGlut.setFont(new Font("inhalt", Font.PLAIN,fontsize));
		
		JRadioButton radioSchig = new JRadioButton(PokeGame.team[2].getClass().getSimpleName());
		radioSchig.setBounds(370,((int)(height/1.4)),180,50);
		radioSchig.setFont(new Font("inhalt", Font.PLAIN,fontsize));

		JRadioButton radioBisa = new JRadioButton(PokeGame.team[3].getClass().getSimpleName());
		radioBisa.setBounds(550,((int)(height/1.4)),180,50);
		radioBisa.setFont(new Font("inhalt", Font.PLAIN,fontsize));
		
		JRadioButton radioSchill = new JRadioButton(PokeGame.team[4].getClass().getSimpleName());
		radioSchill.setBounds(730,((int)(height/1.4)),180,50);
		radioSchill.setFont(new Font("inhalt", Font.PLAIN,fontsize));
		
		JRadioButton[] btnArr = {radioGlum,radioGlut,radioSchig,radioBisa,radioSchill};
		
		group.add(radioGlum);
		group.add(radioGlut);
		group.add(radioSchig);
		group.add(radioBisa);
		group.add(radioSchill);
		
		// add radioButtuns into ConentPane with pokemon that are lebendig 
		for(int i = 0; i< PokeGame.team.length;i++) {
			if(!PokeGame.checkIsDead(PokeGame.team[i])){
				fightFrame.getContentPane().add(btnArr[i]);
			}
		}
		radioGlum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				PokeGame.getPokePic(PokeGame.meinPokemon = PokeGame.team[0]);
				checkRadioBtnInput = true;
				gameControl = 1;
				if(gameControl == 1) {	
					fightFrame.dispose();
					getgameControlGui();
				}
			}
		});
		
		radioGlut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				PokeGame.getPokePic(PokeGame.meinPokemon = PokeGame.team[1]);
				checkRadioBtnInput = true;
				gameControl = 1;
				if(gameControl == 1) {
					fightFrame.dispose();
					getgameControlGui();
				}
			}
		});
		
		radioSchig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				PokeGame.getPokePic(PokeGame.meinPokemon = PokeGame.team[2]);
				checkRadioBtnInput = true;
				gameControl = 1;
				if(gameControl == 1) {
					fightFrame.dispose();
					getgameControlGui();
				}
			
			}
		});
	
		radioBisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				PokeGame.getPokePic(PokeGame.meinPokemon = PokeGame.team[3]);
				checkRadioBtnInput = true;
				gameControl = 1;
				if(gameControl == 1) {
					fightFrame.dispose();
					getgameControlGui();
				}
			}
		});
				
		radioSchill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				PokeGame.getPokePic(PokeGame.meinPokemon = PokeGame.team[4]);
				checkRadioBtnInput = true;
				gameControl = 1;
				if(gameControl == 1) {
					fightFrame.dispose();
					getgameControlGui();
				}
				
			}
		});
		textArea.setText(PokeGame.introAngriff());
		fightFrame.setVisible(true);
	}


	private void getgameControlGui() {
		gameControl = 0;
		ImageIcon wildesPokePic = new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.wildesPokemon)));
		
		JFrame fightFrame = new JFrame("Pokemon");
		fightFrame.setBounds(1000, 800, width, height);
		fightFrame.setLocationRelativeTo(null); //override bound-settings with relative location
		fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fightFrame.getContentPane().setLayout(null);
		fightFrame.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, ((int)(height/1.78)),width-10, 100);
		textArea.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(textArea);
		
		PrintStream ps = new PrintStream(new RedirectOutputStream(textArea));
		System.setOut(ps);	

		// first printStream 
		String Attacke = PokeGame.meinPokemon.attacke[1][0];
		ImageIcon meinPokePic= new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.meinPokemon)));
		textArea.setText("  >>" +PokeGame.meinPokemon.name + " " + "(" + PokeGame.meinPokemon.getClass().getSimpleName() + ") " + " du bist dran!");
		
		JLabel lblMeinpoke = new JLabel(meinPokePic);
		meinPokePic.setImage(meinPokePic.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)); 
		lblMeinpoke.setBounds(100,90,200, 300);
		fightFrame.getContentPane().add(lblMeinpoke);
		lblMeinpoke.setVisible(true);
		
		JLabel lblStatusMeinPoke = new JLabel(PokeGame.meinPokemon.toString());
		lblStatusMeinPoke.setBounds(100, 310, 700, 40);
		lblStatusMeinPoke.setFont(new Font("inhalt", Font.PLAIN, (int)(fontsize/1.15)));
		fightFrame.getContentPane().add(lblStatusMeinPoke);
		
		JLabel lblWildespoke = new JLabel(wildesPokePic);
		lblWildespoke.setBounds(490, 10, 200, 300);
		fightFrame.getContentPane().add(lblWildespoke);
        wildesPokePic.setImage(wildesPokePic.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)); 
        
		JLabel lblStatusWildesPoke = new JLabel(PokeGame.wildesPokemon.toString());
		lblStatusWildesPoke.setBounds(490, 240, 700, 40);
		lblStatusWildesPoke.setFont(new Font("inhalt", Font.PLAIN,(int) (fontsize/1.15)));
		fightFrame.getContentPane().add(lblStatusWildesPoke);
	
		textArea.setEditable(false);
		lblStatusMeinPoke.setVisible(true);
		
		JButton btnAttacke = new JButton(Attacke);
		btnAttacke.setBounds((int)(width/2.7), ((int)(height/1.3)),width/4, height/15);
		btnAttacke.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(btnAttacke);
		btnAttacke.setVisible(false);
		
		JButton btnTackle = new JButton("Tackle");
		btnTackle.setBounds(width/15,((int)(height/1.3)), width/4, height/15);
		btnTackle.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(btnTackle);
		btnTackle.setVisible(false);
		
		JButton btnGo = new JButton(">>>");
		btnGo.setBounds((int)(width/1.5),((int)(height/1.3)), width/4, height/15);
		btnGo.setFont(new Font("inhalt", Font.PLAIN, fontsize));
		fightFrame.getContentPane().add(btnGo);
		fightFrame.setVisible(true);
		
/*
 * event-driven game control with PokeGame methods:
 * */	
		// ">>>" Button
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				lblStatusWildesPoke.setVisible(true);
				lblStatusMeinPoke.setVisible(true);
				if (PokeGame.meinPokemon.status.equals("win") && (gameControl == 1)) {
					textArea.setText("");
					PokeGame.meinPokemon.increaseErfahrungspunkte();
					gameControl =0;
				} else if (PokeGame.meinPokemon.status.equals("win") && (gameControl == 0)) {
					fightFrame.dispose();
					PokeGame.resetPokemon();
					if((PokeGame.checkTypFürEntwicklung())) {
						startGuiEntwicklung();
						} else {
						startMainMenu();
						}				} else if (PokeGame.meinPokemon.lebendig.equals("tot")){
					PokeGame.resetPokemon();
					fightFrame.dispose();
					if((PokeGame.checkTypFürEntwicklung())) {
						startGuiEntwicklung();
						} else {
						startMainMenu();
						}
					} else {
				// gameControl for selecting a specific action by clicking the ">>>" Button
					if(gameControl == 1) {
						gameControl = 0;
						PokeGame.askForPokemon();
					}
					if(gameControl == 0) {
						PokeGame.IntroTextWildesPokemonGreiftAn();
						gameControl = 1;
					}
					if(PokeGame.getKampfStatusIndex()) {
						textArea.setText("");
						PokeGame.chooseAttacke();
						btnTackle.setVisible(true);
						btnAttacke.setVisible(true);
					} else {
						textArea.setText("");
						btnTackle.setVisible(false);
						btnAttacke.setVisible(false);
						PokeGame.gegnerAngriff();
						lblStatusMeinPoke.setText(PokeGame.meinPokemon.toString());	
						if(PokeGame.checkVerloren()) {
							textArea.setBackground(new Color(244, 110, 66));
						}
					}
				}}
		});
		
		// "Tackle" Button : Neutral attack 
		btnTackle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				btnTackle.setVisible(false);
				btnAttacke.setVisible(false);
				textArea.setText("");
				boolean besiegt = PokeGame.stdAngriff();
				PokeGame.printDefaultAttack();
				lblStatusWildesPoke.setText(PokeGame.wildesPokemon.toString());				
				fightFrame.setVisible(true);
				if(besiegt) {
					textArea.setBackground(new Color(190, 244, 65));
					PokeGame.printSieg();
					textArea.setVisible(true);
					btnTackle.setVisible(false);
					btnAttacke.setVisible(false);
					lblStatusWildesPoke.updateUI();
				}
			}
		});
		
		// "type-attack" Button: attack depends on pokemon
		btnAttacke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				textArea.setText("");
				btnTackle.setVisible(false);
				btnAttacke.setVisible(false);
				
				PokeGame.printTypAttack();
				if(!PokeGame.typAngriff()) {
					lblStatusWildesPoke.setText(PokeGame.wildesPokemon.toString());	
				} else {
					textArea.setBackground(new Color(190, 244, 65));
					PokeGame.printSieg();
					textArea.setVisible(true);
					btnTackle.setVisible(false);
					btnAttacke.setVisible(false);
					lblStatusWildesPoke.updateUI();
				}
			}
		});
	}
	
	private void startGuiEntwicklung() {
		JFrame fightFrame = new JFrame("Dein Pokemon entwickelt sich! ");
		fightFrame.setBounds(1000, 800, width-300, height-100);
		fightFrame.setLocationRelativeTo(null); //override bound-settings with relative location
		fightFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fightFrame.getContentPane().setLayout(null);
		fightFrame.setFont(new Font("inhalt", Font.PLAIN, fontsize));

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, ((int)(height/1.7)),width-10, 90);
		textArea.setFont(new Font("inhalt", Font.PLAIN, fontsize+4));
		textArea.setVisible(true);
		textArea.setEditable(false);
		fightFrame.getContentPane().add(textArea);
		PrintStream ps = new PrintStream(new RedirectOutputStream(textArea));
		System.setOut(ps);	
		
		JButton go = new JButton(">>>");
		go.setBounds(10, 10, 100, 50);
		fightFrame.getContentPane().add(go);
		fightFrame.setVisible(true);
		JLabel lblPic = new JLabel(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.meinPokemon))));
		lblPic.setIcon(new ImageIcon(getClass().getResource(PokeGame.getPokePic(PokeGame.meinPokemon))));
		lblPic.setBounds((int)(width/3), (int)(height/9), 200, 300);
		lblPic.setVisible(false);
		fightFrame.getContentPane().add(lblPic);

		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if(gameControl == 0) {
					PokeGame.printEntwicklung();
					lblPic.setVisible(true);
					fightFrame.setVisible(true);
					gameControl = 1;
				} else {
					fightFrame.dispose();
					gameControl = 0;
					startMainMenu();
				}
				
			}
		});
		
	}	
}

