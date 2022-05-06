class UlicaRadjaGresnikeOpet{

	public static void main(String[] args){
		Ulica test = new Ulica();
		
		test.dodajKucu(69);
		test.dodajOsobu(69, "MARKO JANJIC");
		test.dodajOsobu(69, "MARKO Kar");
		test.dodajOsobu(69, "MARKO adada");
		test.dodajKucu(44);
		test.dodajOsobu(44, "Oliver");
		test.dodajKucu(55);
		test.dodajOsobu(55, "Jovana <3");
		test.ukloniKucu(44);
		
		System.out.println(test);
	}
}

class Ulica{
	
		Kuca prva;
		
		class Kuca{
			Kuca veza;
			int id;
			Osoba prva;
			
			public Kuca(int id){
				this.id = id;
			}	
			public String toString(){
				String s = "Osobe [";
				Osoba nov = prva;
				if(nov != null){
					s += nov;
					nov = nov.veza;
					while(nov != null){
							s += ", " + nov;
							nov = nov.veza;
					}
				}
				return s +"]";
		}
			
		}
		
		class Osoba{
			Osoba veza;
			String ime;
			
			public Osoba(String ime){
					this.ime = ime;
					this.veza = null;
			}
		
			public String toString(){
					return ime;
			}
		}
		public String toString(){
			String s = "Lista u ulici: [ ";
			Kuca tek = prva;
			if(tek != null){
				s += tek;
				tek = tek.veza;
			
			while(tek != null){
				s += ", " +tek;
				tek = tek.veza;
			}
		 }
		 return s+ "]";
		}
		
		public boolean dodajKucu(int id){
			Kuca novaKuca = new Kuca(id);
			if(prva == null || prva.id > id){
				novaKuca.veza = prva;
				prva = novaKuca;
			}else{
				if(prva.id != id){
						Kuca tek = prva;
						while(tek.veza != null && tek.veza.id < id){
								tek = tek.veza;
						}
						if(tek.veza == null || tek.veza.id != id){
								novaKuca.veza = tek.veza;
								tek.veza = novaKuca;
								return true;
						}
						
				}
				
			}
			return false;
			
		}
		public Kuca nadjiKucu(int id){
				Kuca tekuci = prva;
				while(tekuci != null){
					if(tekuci.id == id){
						return tekuci;
					}
					tekuci = tekuci.veza;
				}
				return null;
		}
		
		public boolean dodajOsobu(int id, String ime){
				Kuca novakuca = nadjiKucu(id);
				if(novakuca == null){
						return false;
				}
				Osoba novaOsoba = new Osoba(ime);
				novaOsoba.veza = novakuca.prva;
				novakuca.prva = novaOsoba;
				return true;
		}
		
		public boolean ukloniKucu(int id){
				if(prva == null){
					return false;
				}
				if(prva.id == id){
					prva = prva.veza;
				}
				
				Kuca tek = prva;
				while(tek.veza != null){
						if(tek.veza.id == id){
								tek.veza = tek.veza.veza;
								return true;
						}
						tek = tek.veza;
				}
				return false;
				
		}
		
}
  
		

