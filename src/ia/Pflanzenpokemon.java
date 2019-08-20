package ia;

public abstract class Pflanzenpokemon extends Pokemon{
	
	Pflanzenpokemon(String name) {
		super(name);
	}
	
	Pflanzenpokemon(){	
	}

	public boolean entwicklungsCheck(Pokemon[] team) {
		if((this.entwicklungsstufe == 1) && (this.erfahrungspunkte >= 50)) {
				team[3]=((Bisasam)this).entwickeltSich();
				PokeGame.meinPokemon = team[3];
				return true;
		}
	
		if((this.entwicklungsstufe == 2) && (this.erfahrungspunkte >= 100)) {
				if(this.name.equals("Lollipop")) {
					PokeGame.meinPokemon = team[2];
					return true;
				}
		}
		return false;
	}
	
	public abstract Pflanzenpokemon entwickeltSich();

}


