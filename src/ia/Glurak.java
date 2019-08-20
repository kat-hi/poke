package ia;

public class Glurak extends Feuerpokemon{
	public Glurak(String name){
		super.name = name;
		angriffspunkte = 30;
		kampfpunkte = 160;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Feuersturm";
		attacke[1][1] = "Feuer";
		erfahrungspunkte = 100;
		entwicklungsstufe = 3;
		pokedexID = "2";
	}
	
	public Glurak(Glutexo vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 30;
		entwicklungsstufe = 3;
		erfahrungspunkte = 100;
		pokedexID = "2";
	}
	
	@Override
	public Glurak entwickeltSich() {
		return this;
	}

}
