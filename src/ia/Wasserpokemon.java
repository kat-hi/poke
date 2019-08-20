package ia;
public abstract class Wasserpokemon extends Pokemon {

	public Wasserpokemon(String name) {
		super.name = name;
	}
	
	public Wasserpokemon() {
	}

	public boolean entwicklungsCheck(Pokemon[] team) {
		if((this.entwicklungsstufe == 1) && (this.erfahrungspunkte >= 50)) {
				team[2]=((Schiggy)this).entwickeltSich();
				PokeGame.meinPokemon = team[2];
				return true;
		}
	
		if((this.entwicklungsstufe == 2) && (this.erfahrungspunkte >= 100)) {
				if(this.name.equals("Ulrich")) {
					team[2] = ((Schillok)this).entwickeltSich();
					PokeGame.meinPokemon = team[2];
					return true;
				} else {
					team[4] = ((Schillok)this).entwickeltSich();
					PokeGame.meinPokemon = team[4];
					return true;
				}
		}
		return false;

	}
	public abstract Wasserpokemon entwickeltSich();
}
