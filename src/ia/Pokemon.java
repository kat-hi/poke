package ia;

public abstract class Pokemon {
	public String name;
	public String pokedexID;
	public int entwicklungsstufe;
	public double kampfpunkte;
	public double angriffspunkte;
	public String[][] attacke = new String[2][2];
	public int erfahrungspunkte;
	public String status = "angriff";
	public String lebendig = "lebendig";
	
	public Pokemon(String name){
		this.name = name;
	}
	
	public Pokemon() {	
	}
	
	public abstract Pokemon entwickeltSich();
	
	@Override
	public String toString() {
		String typ = "";
		if(this instanceof Feuerpokemon) {
			typ = "Feuer";
		} else if(this instanceof Wasserpokemon) {
			typ = "Wasser";
		} else if (this instanceof Pflanzenpokemon) {
			typ = "Pflanze";
		}
		return(this.name + " (" + this.getClass().getSimpleName() + " | " + typ + " | " + this.kampfpunkte + " KP; " +  this.angriffspunkte + " AP)");
	}

	/* This factor depends on the type of the chosen attack.
	 * It may be that you'll hit the wild Pokemon perfectly and get a "Volltreffer" (alias "impact") which causes more damage to its "kampfpunkte".
	 * */	
	public double getAngriffsfaktor(Pokemon gegner, String attackentyp) {
		if(attackentyp.equals(this.attacke[0][1])) {
			return this.angriffspunkte;
		}
		
		if((this instanceof Feuerpokemon) && (gegner instanceof Wasserpokemon)) {
			if(attackentyp.equals("Feuer")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.angriffspunkte/2;
			}
		}
		
		if((this instanceof Feuerpokemon) && (gegner instanceof Pflanzenpokemon)) {
			if(attackentyp.equals("Feuer")){
				System.out.println("Das war sehr effektiv! ");
				return this.angriffspunkte*2;
			}
		}
		
		if((this instanceof Pflanzenpokemon) && (gegner instanceof Wasserpokemon)) {
			if(attackentyp.equals("Pflanze")){
				System.out.println("Das war sehr effektiv! ");
				int impact = (int)(Math.random()*20);
					if(impact > 15) {
						System.out.print("Volltreffer! ");
						return this.angriffspunkte*2+impact;
					}
				return this.angriffspunkte*2;
			} 
		}
		
		if((this instanceof Pflanzenpokemon) && (gegner instanceof Feuerpokemon)) {
			if(attackentyp.equals("Pflanze")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.angriffspunkte/2;
			} 
		}
		
		if((this instanceof Wasserpokemon) && (gegner instanceof Feuerpokemon)) {
			if(attackentyp.equals("Wasser")){
				System.out.print("Das war sehr effektiv! ");
				int impact = (int)(Math.random()*20);
					if(impact > 15) {
						System.out.print("Volltreffer! ");
						return this.angriffspunkte*2 +impact;
					}
				return this.angriffspunkte*2;
			} 
		}
		if((this instanceof Wasserpokemon) && (gegner instanceof Pflanzenpokemon)) {
			if(attackentyp.equals("Wasser")){
				System.out.println("Das war nicht sehr effektiv! ");
				return this.angriffspunkte/2;
			} else {
				return this.angriffspunkte;
			}
		}
		if((this instanceof Wasserpokemon) && (gegner instanceof Wasserpokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.println("Volltreffer!");
				return this.angriffspunkte*2+impact;
			}
		}
		
		if((this instanceof Feuerpokemon) && (gegner instanceof Feuerpokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.print("Volltreffer! ");
				return this.angriffspunkte+impact;
			}
		}
		
		if((this instanceof  Pflanzenpokemon) && (gegner instanceof Pflanzenpokemon)) {
			int impact = (int)(Math.random()*20);
			if(impact > 15) {
				System.out.print("Volltreffer! ");
				return this.angriffspunkte+impact;
			}
		}
			return this.angriffspunkte;
	}
	
	public void greiftAn(Pokemon gegner, String attacke) {
		gegner.kampfpunkte = gegner.kampfpunkte - this.getAngriffsfaktor(gegner,attacke);
	}	
	
	public void increaseErfahrungspunkte () {
		this.erfahrungspunkte = this.erfahrungspunkte+30;
		System.out.println("Dein " + this.getClass().getSimpleName() + " hat 30 Erfahrungspunkte hinzugewonnen!");	
	}
	
}
