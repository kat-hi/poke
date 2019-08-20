package ia;

public class Bisaflor extends Pflanzenpokemon {
	public Bisaflor(String name){
		super.name = name;
		angriffspunkte = 30;
		kampfpunkte = 160;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Hyperstrahl";
		attacke[1][1] = "Pflanze";	
		erfahrungspunkte = 100;
		entwicklungsstufe = 3;
		pokedexID = "5";
	}
	
	public Bisaflor(Bisaknosp vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 30;
		erfahrungspunkte = 100;
		entwicklungsstufe = 3;
		pokedexID = "5";
	}

	@Override
	public Bisaflor entwickeltSich() {
		return this;
	}
}
