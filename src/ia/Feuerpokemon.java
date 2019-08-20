package ia;

public abstract class Feuerpokemon extends Pokemon{
	
	Feuerpokemon(String name) {
		super(name);
	}
	
	Feuerpokemon(){
	}
	
	public boolean entwicklungsCheck(Pokemon[] team) {
		if((this.entwicklungsstufe == 1) && (this.erfahrungspunkte >= 50)) {
				team[0]=((Glumanda)this).entwickeltSich();
				PokeGame.meinPokemon = team[0];
				return true;
		}
	
		if((this.entwicklungsstufe == 2) && (this.erfahrungspunkte >= 100)) {
				if(this.name.equals("Heinz")) {
					team[0] = ((Glutexo)this).entwickeltSich();
					PokeGame.meinPokemon = team[0];
					return true;
				} else {
					team[1] = ((Glutexo)this).entwickeltSich();	
					PokeGame.meinPokemon = team[1];
					return true;
				}
		}
		return false;
	}
	
	@Override
	public abstract Feuerpokemon entwickeltSich();

}


