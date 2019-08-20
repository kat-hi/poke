package ia;
/**
 * @author kat
 * @see Pokemon
 * @see PokeGui
 * @see RedirectOutputStream
 * @see Feuerpokemon
 * @see Wasserpokemon
 * @see Pflanzenpokemon
 * ...
 * */

/*
 * NOTES:
 *  jar-file is executable with:
 *  1. chmod 774 filename.jar 
 *  2. java -jar filename.jar 
 *  
*/

public class PokeGame {
	public static Pokemon[] pokedex = new Pokemon[9];
	public static Pokemon[] team = new Pokemon[5];
	public static Pokemon meinPokemon = null;
	public static Pokemon wildesPokemon;

	public static void main(String[] args) {
		pokedex[0] = new Glumanda("Wildes Pokemon");
		pokedex[1] = new Glutexo("Wildes Pokemon");
		pokedex[2] = new Glurak("Wildes Pokemon");		
		pokedex[3] = new Bisasam("Wildes Pokemon");
		pokedex[4] = new Bisaknosp("Wildes Pokemon");
		pokedex[5] = new Bisaflor("Wildes Pokemon");
		pokedex[6] = new Schiggy("Wildes Pokemon");
		pokedex[7] = new Schillok("Wildes Pokemon");
		pokedex[8] = new Turtok("Wildes Pokemon");
		
		team[0] = new Glumanda("Heinz");
		team[1] = new Glutexo("Karl");
		team[2] = new Schiggy("Ulrich");
		team[3] = new Bisasam("Lollipop");
		team[4] = new Schillok("Zauberfee");
		
		new Thread(new PokeGui()).start();	
	} //main
	
	
/*Print-methods for GUI 
 *Using RedirectOutputStream in PokeGui.class -> output: textArea 
 * */
	
	//DefaultAttack defines attack with status "neutral" == it is always "tackle"
	public static void printDefaultAttack() {
		System.out.println(meinPokemon.name + " (" + meinPokemon.getClass().getSimpleName() + ") " + meinPokemon.attacke[0][0] + "!");
	}
	
	//TypAttack depends on the attacking pokemon
	public static void printTypAttack() {
		System.out.println(meinPokemon.name + " (" + meinPokemon.getClass().getSimpleName() + ") " + meinPokemon.attacke[1][0] + "!");
	}
	
	public static void IntroTextWildesPokemonGreiftAn() {
		System.out.println("Ein " + wildesPokemon.getClass().getSimpleName() + " (wild) "  + "greift an...");
		System.out.println(wildesPokemon);
	}
	
	public static void askForPokemon() {
		System.out.println("Welches Pokemon möchtest du einsetzen?");		
	}
	
	public static void printSieg() {
		System.out.print("Der Gegner wurde besiegt.");
	}
		
	public static void chooseAttacke() {
		System.out.print("Du bist dran! Waehle eine Attacke!");
	}
	
	public static void printEntwicklung() {
		if(meinPokemon instanceof Feuerpokemon) {
			if(meinPokemon.getClass().getSimpleName().equals("Glutexo")){
				System.out.println("Glumanda ist zu "   + meinPokemon.getClass().getSimpleName() + " geworden!");
			} else {
				System.out.println("Glutexo ist zu "  + meinPokemon.getClass().getSimpleName() + " geworden!");	
			}
		}
		
		if(meinPokemon instanceof Wasserpokemon) {
			if(meinPokemon.getClass().getSimpleName().equals("Schillok")){
				System.out.println("Schiggy ist zu "   + meinPokemon.getClass().getSimpleName() + " geworden!");
			} else {
				System.out.println("Schillok ist zu "   + meinPokemon.getClass().getSimpleName() + " geworden!");
			}
		}
		
		if(meinPokemon instanceof Pflanzenpokemon) {
			if(meinPokemon.getClass().getSimpleName().equals("Bisaknosp")){
				System.out.println("Bisasam ist zu " + meinPokemon.getClass().getSimpleName() + " geworden!");
			} else {
				System.out.println("Bisaknosp ist zu "  + meinPokemon.getClass().getSimpleName() + " geworden!");
			}
		}
	}
	
	public static String introAngriff() {
		return "Ein " + wildesPokemon.getClass().getSimpleName() + " (wild) "  + "greift an... \nWelches Pokemon wählst du?" ;
	}
	
	public static void startAgain() {
		System.out.print("Bereit für den nächsten Gegner?");
		wildesPokemon = pokedex[(int)(Math.random()*8)];
	}
	
/* GameControl methods */	
	public static boolean stdAngriff() {
		meinPokemon.greiftAn(wildesPokemon, meinPokemon.attacke[0][1]);
		return gegnerBesiegt();
	}
	
	public static boolean typAngriff() {
		meinPokemon.greiftAn(wildesPokemon, meinPokemon.attacke[1][1]);
		return gegnerBesiegt();
	}
	
	// Event: 'click ">>>" Button': this method controls which pokemon is next 
	public static boolean getKampfStatusIndex() {
		if(meinPokemon.status.equals("angriff")) {
			meinPokemon.status = "verteidigung";
			wildesPokemon.status = "angriff";
			return false;
		} else if (meinPokemon.status.equals("verteidigung")) {
			meinPokemon.status = "angriff";
			wildesPokemon.status = "verteidigung";
			return true;
		}
		throw new RuntimeException();
	}
	
	public static boolean checkTypFürEntwicklung() {
		if(meinPokemon instanceof Feuerpokemon) {
			return ((Feuerpokemon)meinPokemon).entwicklungsCheck(team);
		}
		
		if(meinPokemon instanceof Wasserpokemon) {
			return ((Wasserpokemon)meinPokemon).entwicklungsCheck(team);
		}
		
		if(meinPokemon instanceof Pflanzenpokemon) {
			return ((Pflanzenpokemon)meinPokemon).entwicklungsCheck(team);
		}
		throw new RuntimeException();
	}
	
	public static void gegnerAngriff() {
		String angriff = wildesPokemon.attacke[0][(int)(Math.random()*2)];
		if(angriff.equals(wildesPokemon.attacke[0][0])) {
			System.out.println(wildesPokemon.getClass().getSimpleName() + " (wild) greift an ... " + "Tackle!");
			wildesPokemon.greiftAn(meinPokemon, wildesPokemon.attacke[0][1]);
		} else {
			System.out.println(wildesPokemon.getClass().getSimpleName() + " (wild) greift an ... " + wildesPokemon.attacke[1][0] + "!");
			wildesPokemon.greiftAn(meinPokemon, wildesPokemon.attacke[1][1]);
		}
	}
	
	public static boolean checkVerloren() {
		if(meinPokemon.kampfpunkte <= 0) {
			System.out.print("Du hast verloren");
			meinPokemon.lebendig = "tot";
			return true;
		}
		return false;
	}
	
	public static boolean gegnerBesiegt() {
		if(wildesPokemon.kampfpunkte <= 0) {
		meinPokemon.status = "win";
		return true;
		} else {
			return false;
		}
	}
	
	/*
	 * getting the right picture with matching array-index and pokedexID
	 * */
	public static String getPokePic(Pokemon poke) {
		String pokePic ="";
		String[][] pokePicture = new String[9][2];
		
		pokePicture[0][0] = "glumanda2.png";
		pokePicture[1][0] = "glutexo2.png";
		pokePicture[2][0] = "glurak2.png";
		pokePicture[3][0] = "bisa2.png";
		pokePicture[4][0] = "bisaknosp2.png";
		pokePicture[5][0] = "bisaflor2.png";
		pokePicture[6][0] = "schiggy2.png";
		pokePicture[7][0] = "schillok2.png";
		pokePicture[8][0] = "turtok2.png";
		
		for(int i = 0; i < 9; i++) {
			pokePicture[i][1] = i+"";
		}
		
		for(int i = 0; i< pokePicture.length; i++) {
			if(poke.pokedexID.equals(pokePicture[i][1])){
				pokePic = pokePicture[i][0];
				break;
			} 
		}
		return pokePic;
	}
	
	/* This method checks whether any of my pokemon is dead: 
	 * for initializing new radioButton that offer selection of a pokemon for a new fight
	 * */
	public static boolean checkIsDead(Pokemon poke) {
		for(int i = 0; i < team.length; i++) {
			if(poke.lebendig.equals("tot")) {
				return true;
			}
		}
		return false;
	}
	
	public static void randomWildesPoke() {
		wildesPokemon = pokedex[(int)(Math.random()*8)];
	}
	
	// this method ensures that a new fight always starts with a wild pokemon that is healed regardless of the outcome of recent fights 
	public static void resetPokemon() {
		if(wildesPokemon.entwicklungsstufe == 1 || meinPokemon.entwicklungsstufe ==1) {
			wildesPokemon.kampfpunkte = 120;
		}
		if(wildesPokemon.entwicklungsstufe == 2 || meinPokemon.entwicklungsstufe ==2) {
			wildesPokemon.kampfpunkte = 140;
		}
		if(wildesPokemon.entwicklungsstufe == 3 || meinPokemon.entwicklungsstufe ==3) {
			wildesPokemon.kampfpunkte = 160;
		}
		meinPokemon.status = "angriff";
		PokeGui.gameControl = 0;
	}
	
	public static void heal() {
		for(int i = 0; i < team.length; i++) {
			if(team[i].entwicklungsstufe==1) {
				team[i].kampfpunkte = 120;
			} else if(team[i].entwicklungsstufe ==2) {
				team[i].kampfpunkte = 140;
			} else if(team[i].entwicklungsstufe==3){
				team[i].kampfpunkte = 160;
			}
			if(team[i].lebendig.equals("tot")) {
				team[i].lebendig = "lebendig";
			}
		}
	}

} // class
