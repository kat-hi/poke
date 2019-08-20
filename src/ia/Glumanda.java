package ia;

public class Glumanda extends Feuerpokemon{
	
	public Glumanda(String name){
		super.name = name;
		angriffspunkte = 20;
		kampfpunkte = 120;
		attacke[0][0] = "Tackle";
		attacke[0][1] = "Neutral";
		attacke[1][0] = "Glut";
		attacke[1][1] = "Feuer";
		erfahrungspunkte = 10;
		entwicklungsstufe = 1;
		pokedexID = "0";
	}
	
	public Glumanda() {
	}

	@Override
	public Glutexo entwickeltSich() {
		return new Glutexo(this);
	}

}
