package ia;

public class Bisaknosp extends Pflanzenpokemon{
	public Bisaknosp(String name){
		super.name = name;
		angriffspunkte = 25;
		kampfpunkte = 140;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Megastrahl";
		attacke[1][1] = "Pflanze";
		erfahrungspunkte = 50;
		entwicklungsstufe = 2;
		pokedexID = "4";
	}
	
	public Bisaknosp(Bisasam vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte;
		angriffspunkte = 25;
		erfahrungspunkte = 50;
		entwicklungsstufe = 2;
		pokedexID = "4";
	}
	
	public Bisaflor entwickeltSich() {
		return new Bisaflor(this);
	}

}
