/*
	Kolokvijum 06.05.2022
	Zadatak:
		Napraviti klasu Vrtic koja sadrzi listu Vaspitaca(Svaki ima unikatno ime, godine radnog staza i listu dece/sticenika)
		Svako dete ima svoje ime, pol i broj godina (Pri unosu sortirani po godinama)
		1. Napraviti jednu toString metodu za ispis liste Vrtica - Pozeljno u svakoj klasi napisati toString metodu
		2. Napraviti metodu za unos vaspitaca, paziti na ime moze samo jedno isto da bude - preporuka equalsIgnoreCase
			2.1 Napraviti metodu za unos dece/sticenika - sortirati po broju prilikom unosa, deca mogu imati ista imena.
		3. Napraviti metodu koja uklanja vaspitaca i svu njegovu decu prebacuje sledecem u listi (ako ga ima, u drugom slucaju samo obrisati svu decu)
			bez zauzimanja nove memorije
*/

class KLK{
	
	
	public static void main(String [] args){
		Vrtic so = new Vrtic();
		
		so.dodajVaspitaca("Dragan", 2);
		System.out.println(so);
		so.dodajDete("Milan", "Musko", 2, "Dragan");
		System.out.println(so);
		
		
	}

}

class Vrtic{
		
		Vaspitac prviVaspitac;
		
		class Vaspitac{
		String ime;
		Vaspitac veza;
		int godinaRad;
		Sticenik dete;
		
		public Vaspitac(String ime, int godinaRad){
			this.ime = ime;
			this.godinaRad = godinaRad;
			this.veza = null;
		}
		
		public String toString(){
			String rez = "[" +ime+" "+godinaRad+ ":";
			Sticenik dite = dete;
			if(dite != null){
				rez += "" +dite;
				dite = dite.veza;
				while (dite != null)
				{
					rez += ", " +dite;
					dite = dite.veza;
				}
			}
			rez += "]";
			return rez;
			
		}
		}
		
		class Sticenik{
			
			String ime, pol;
			int brGod;
			Sticenik veza;
			
			public Sticenik(String ime, String pol, int brGod){
				
				this.ime = ime;
				this.pol = pol;
				this.brGod = brGod;
				this.veza = null;
			}
			
			public String toString(){
				return "dete: " + ime + pol + brGod;
				
			}
		}
		
		public String toString(){
			String rez = "Vrtic: [ ";
			Vaspitac tek = prviVaspitac;
			if (tek != null)
			{
				rez += " " +tek;
				tek = tek.veza;
				while (tek != null)
				{
					rez += ", " +tek;
					tek = tek.veza;
				}
			}
			rez += "]";
			return rez;
		}
		
		public void dodajVaspitaca(String ime, int godRad){
				if(!postojiVaspitac(ime)){
					Vaspitac novi = new Vaspitac(ime, godRad);
					novi.veza = prviVaspitac;
					prviVaspitac = novi;
				}
			
		}
		
		public boolean postojiVaspitac(String ime){
				Vaspitac tek = prviVaspitac;
				while (tek != null)
				{
					if (tek.ime.equalsIgnoreCase(ime))
					{
						return true;
					}
					tek = tek.veza;
				}
				return false;
			
		}
		public Vaspitac nadjiVaspitaca(String imeV){
				if (prviVaspitac != null)
				{
					if (prviVaspitac.ime.equalsIgnoreCase(imeV))
					{
						return prviVaspitac;
					} else
					{
						Vaspitac preth = prviVaspitac;
						while (preth.veza !=null)
						{
							if (preth.veza.ime.equalsIgnoreCase(imeV))
							{
								return preth.veza;
							}
							preth = preth.veza;
						}

					}
				}
				return null;
		}
		
		public void dodajDete(String ime, String pol, int brGod, String vaspitaca){
				Vaspitac cilj = nadjiVaspitaca(vaspitaca);
				if (cilj == null)
				{
					dodajVaspitaca(vaspitaca, 1);
					cilj = nadjiVaspitaca(vaspitaca);
				}
				Sticenik novi = new Sticenik (ime, pol, brGod);
				novi.veza = cilj.dete;
				cilj.dete = novi;
			
		}
}
