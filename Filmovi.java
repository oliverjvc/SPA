class Filmovi{
	
	public static void main (String[] args){
		SpisakFilmova s1= new SpisakFilmova();
		
		Svetovid.out.println("Nakon dodavanja filmova: \n");
		
		s1.dodajFilm("Inception");
		s1.dodajFilm("Interstellar");
		s1.dodajFilm("Avengers");
		s1.dodajFilm("8 Mile");
		s1.dodajFilm("Iron Man");
		s1.dodajFilm("The Dark Knight");
		
		Svetovid.out.println(s1);
		
		Svetovid.out.println("\nNakon dodavanja glumaca u filmove: \n");
		
		s1.dodajGlumcaUFilm("Inception", "Leonardo Di Caprio");
		s1.dodajGlumcaUFilm("Inception", "Tom Hardy");
		s1.dodajGlumcaUFilm("Inception", "Tom Hardy");
		s1.dodajGlumcaUFilm("Inception", "Tom Hardy");
		s1.dodajGlumcaUFilm("Inception", "Michael Kaine");
		
		s1.dodajGlumcaUFilm("Interstellar", "Mathew McConaughey");
		s1.dodajGlumcaUFilm("Interstellar", "Anne Hathaway");
		s1.dodajGlumcaUFilm("Interstellar", "Jessica Chastain");
		
		s1.dodajGlumcaUFilm("Avengers", "Robert Downey Jr.");
		s1.dodajGlumcaUFilm("Avengers", "Scarlett Johansson");
		s1.dodajGlumcaUFilm("Avengers", "Mark Ruffalo");
		s1.dodajGlumcaUFilm("Avengers", "Chris Evans");
		
		s1.dodajGlumcaUFilm("8 Mile", "Eminem");
		s1.dodajGlumcaUFilm("8 Mile", "Brittany Murphy");
		s1.dodajGlumcaUFilm("8 Mile", "Mekhi Phifer");
		
		s1.dodajGlumcaUFilm("Iron Man", "Robert Downey Jr.");
		s1.dodajGlumcaUFilm("Iron Man", "Gwyneth Paltrow");
		s1.dodajGlumcaUFilm("Iron Man", "Jeff Bridges");
		
		s1.dodajGlumcaUFilm("Batman Begins", "Christian Bale");
		
		Svetovid.out.println(s1);
		
		Svetovid.out.println("\nNakon brisanja filmova sa odredjenim glumcem:\n");
		s1.brisiFilmoveSaGlumcem("Robert Downey Jr.");
		s1.brisiFilmoveSaGlumcem("Jessica Chastain");
		Svetovid.out.println(s1);
		
	}
}

class SpisakFilmova{
	
	
	class Glumac{
		
		String imePrezime;
		Glumac veza;
		
		public Glumac(String imePrezime){
				this.imePrezime = imePrezime;
				this.veza = null;
				
		}
		
		public String toString(){
				return imePrezime;
		}
	}
		public String toString(){
				String rez = "Filmovi:[ ";
				Film tekuci = prviFilm;
				if(tekuci != null){
					while(tekuci != null){
						rez += tekuci + ", ";
						tekuci = tekuci.veza;
					}
				}
				rez += "]";
				return rez;
		}
		
		public void dodajGlumcaUFilm(String naslov, String imePrezime){
				Film izabran = nadjiFilm(naslov);
				if(izabran != null){
						Glumac novi = new Glumac(imePrezime);
						if(!postojiGlumacUFilmu(naslov, imePrezime)){
							novi.veza = izabran.prviGlumac;
							izabran.prviGlumac = novi;
						}
						else{
							Svetovid.out.println("Greska pri dodavanju glumca!\nFilm \"" + naslov + "\" ne postoji u listi filmova!\n");
						}
				}
		} 
		
		
	Film prviFilm;
	
	class Film{
		String naslov;
		Film veza;
		Glumac prviGlumac;
		
		
		public Film (String naslov){
				this.naslov = naslov;
				this.prviGlumac = null;
				this.veza = null;
				
		}
		
		public String toString()
		{
			String rez = "[" + naslov + ": ";
			Glumac tekuci = prviGlumac;
			if(tekuci != null)
			{
				rez += " " + tekuci;
				tekuci = tekuci.veza;
				while(tekuci != null)
				{
					rez += ", " + tekuci;
					tekuci = tekuci.veza;
				}
			}
			rez += "]";
			return rez;
		}
		
	}	
		public void dodajFilm(String naslov){
				if(!postojiFilm(naslov)){
					Film novi = new Film(naslov);
					novi.veza = prviFilm;
					prviFilm = novi;
				}
				
			}
			
		public boolean postojiFilm(String trazeniNaslov){
				Film tekuci = prviFilm;
				while(tekuci != null){
					if(tekuci.naslov.equals(trazeniNaslov))
						return true;
						tekuci = tekuci.veza;
					
				}
				return false;
			}
		
		
		
		public Film nadjiFilm(String trazeniNaslov){
				Film tekuci = prviFilm;
				while(tekuci != null){
					if(tekuci.naslov.equals(trazeniNaslov)){
						return tekuci;
					}
					tekuci = tekuci.veza;
				}
				return null;
		}
		
		
		
		
		public void brisiFilmoveSaGlumcem(String imePrezime){
				Film tekuci = prviFilm;
				Film prethodni = null;
				
				/** Kad pozivamo metodu vrv cemo ukloniti samo jednog glumca a on ce biti vrv samo u jednom filmu pa da ne trazimo u svim ako je samo u jednom*/
				while(tekuci != null && postojiGlumacUFilmu(tekuci.naslov, imePrezime)){
					prviFilm = tekuci.veza;
					tekuci = prviFilm;
				}
				
				while(tekuci != null){
					
					while(tekuci != null && !postojiGlumacUFilmu(tekuci.naslov, imePrezime)){
						prethodni = tekuci;
						tekuci = tekuci.veza;
					}
					if(tekuci == null){
						return;
					}
					prethodni.veza = tekuci.veza;
					tekuci = prethodni.veza;
					
				}					
		}
		
		
		public boolean postojiGlumacUFilmu(String naslov, String imePrezime){
				Film film = nadjiFilm(naslov);
				return postojiGlumacUFilmuInterni(film, imePrezime);
		}
		
		public boolean postojiGlumacUFilmuInterni(Film trazeniFilm, String trazeniGlumac){
				if(trazeniFilm != null){
					Glumac tekuci = trazeniFilm.prviGlumac;
					while(tekuci!= null){
						if(tekuci.imePrezime.equals(trazeniGlumac))
						return true;
						tekuci = tekuci.veza;
					
				}
			}
			return false;
		}
	
}

