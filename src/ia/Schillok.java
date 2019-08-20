package ia;

public class Schillok extends Wasserpokemon {
	public Schillok(String name){
		super.name = name;
		angriffspunkte = 25;
		kampfpunkte = 140;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Hydropumpe";
		attacke[1][1] = "Wasser";
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "7";
	}
	
	public Schillok(Schiggy vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 25;
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "7";
	}

	public Turtok entwickeltSich() {
		return new Turtok(this);
	}
}
