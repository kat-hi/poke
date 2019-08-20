package ia;

public class Glutexo extends Feuerpokemon {	
	public Glutexo(String name){
		super.name = name;
		angriffspunkte = 25;
		kampfpunkte = 140;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Feuerwirbel";
		attacke[1][1] = "Feuer";
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "1";
	}
	
	public Glutexo(Glumanda vorstufe) {
		this.name = vorstufe.name;
		this.kampfpunkte = vorstufe.kampfpunkte+20;
		angriffspunkte = 25;
		erfahrungspunkte = 50;
		entwicklungsstufe =2;
		pokedexID = "1";
	}
	
	@Override
	public Glurak entwickeltSich() {
		return new Glurak(this);
	}
}
