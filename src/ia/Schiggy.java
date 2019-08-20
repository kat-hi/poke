package ia;

public class Schiggy extends Wasserpokemon {

	public Schiggy(String name){
		super.name = name;
		angriffspunkte = 20;
		kampfpunkte = 120;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Aquaknarre";
		attacke[1][1] = "Wasser";
		erfahrungspunkte = 10;
		entwicklungsstufe = 1;
		pokedexID = "6";
	}
	
	public Schiggy(){
	}
	
	public Schillok entwickeltSich() {
		return new Schillok(this);
	}
}
