/** Pun gresaka (14) */
class UlicaRadjaGresnike{
		
		public static void main(String [] args){
			Ulica ulica = new Ulica();
			
			ulica.addHome(4);
    ulica.addHome(7);
    ulica.addHome(4);
    ulica.addHome(9);
    ulica.addHome(1);
    ulica.addHome(99);
    ulica.addHome(4);
    ulica.addHome(1);
    ulica.addHome(7);
    ulica.addHome(77);
    ulica.addHome(4);
    ulica.addHome(99);

    Svetovid.out.println(ulica);

    ulica.addPerson(77, "Nikola");
    ulica.addPerson(9, "Nenad");
    ulica.addPerson(9, "Jasmina");
    ulica.addPerson(9, "Andjelija");
    ulica.addPerson(9, "Nikola");
    ulica.addPerson(9, "Nikola");
    ulica.addPerson(7, "Nikola");
    ulica.addPerson(99, "Mmmmmmm");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(99, "Nikola");
    ulica.addPerson(80, "Nikola");
    ulica.addPerson(80, "Nikola");

    Svetovid.out.println(ulica);

    Svetovid.out.println("ID kuca sa najvise ljudi duzine" + ulica.findHomeWithNames(5));

    ulica.movePerson(99, 4);
    Svetovid.out.println(ulica);
    Svetovid.out.println(ulica.findHome(9).removeLast());
    Svetovid.out.println(ulica);

		
		}
}

class Ulica{
		
		public Kuca findHome(int id){
			Kuca tek = prva;
			while(tek != null){
				if(tek.id == id)
					return tek;
					
				tek = tek.veza;
			} 
			return null;
		}
		
		public boolean homeExists(int id){
			if(findHome(id) == null)
				return false;
				
			return true;
		}
		
		public boolean addHome(int id){
				Kuca novaKuca = new Kuca(id);
				if(prva == null || prva.id > id){
						novaKuca.veza = prva;
						prva = novaKuca;
						return true;
					}else{
						if(prva.id != id){
							Kuca tekuci = prva;
							while(tekuci.veza != null && tekuci.veza.id <id){
								tekuci = tekuci.veza;
							}
							if(tekuci.veza == null || tekuci.veza.id != id){
								novaKuca.veza = tekuci.veza;
								tekuci.veza = novaKuca;
								return true;
							}
						}
					}
					return false;	
			}
			
			
			public boolean addPerson(int id, String ime){
				Kuca nova = findHome(id);
				if(nova == null)
					return false;
				nova.addPerson(ime);
				return true;
			}
			
			public int findHomeWithNames(int imeLen){
				if(prva == null){
					return 0;
				}
				
				Kuca max = prva;
				Kuca tekuci = prva;
				int maxLen = max.brojLjudiSaDugimImenima(imeLen);
				while(tekuci != null){
					int tekuciLen = tekuci.brojLjudiSaDugimImenima(imeLen);
					if(tekuciLen > maxLen){
						max = tekuci;
						maxLen = tekuciLen;
					}
					tekuci = tekuci.veza;
				}
				return max.id;
			}
			
			public boolean removeHome(int id){
				if(prva == null){
					return false;
				}
				if(prva.id == id){
					prva = prva.veza;
				}
				
				Kuca tekuci = prva;
				while(tekuci.veza != null){
					if(tekuci.veza.id == id){
						tekuci.veza = tekuci.veza.veza;
						return true;
					}
					tekuci = tekuci.veza;
				}
				return false;
			}
			
			public boolean movePerson(int fromID, int toID){
				Kuca from = findHome(fromID);
				Kuca to = findHome(toID);
				
				if(from == null){
					return false;
				}
			
			
			Osoba lastPersonFrom = from.removelast();
			
			if(lastPersonFrom == null){
				return false;
			}else{
				if(to==null){
					return true;
				}
				to.movePerson(lastPersonFrom);
				return true;
			}
		}
		
		public String toString(){
			String s = "Lista ulica[ ";
			Kuca tekuci = prva;
			if(tekuci != null){
				s += tekuci;
				tekuci = tekuci.veza;
				while(tekuci != null){
					s += ", " + tekuci;
					tekuci = tekuci.veza;
			}
		}
		return s + "]";
		
	}
			
		Kuca prva;
		class Kuca{
				int id;
				Kuca veza;
				Osoba prva;
				
			public Kuca (int id){
				this.id = id;
				/* zasto ovo pravi gresku?
				this.veza = veza;
				this.prva = prva;
				*/
			}
			
		}
		
		public void addPerson(String name){
			Osoba newNode = new Osoba(name);
			newNode.veza = prva;
			prva = newNode;
		}
		
		public void movePerson(Osoba newNode){
			newNode.veza = prva;
			prva = newNode;
		}
		
		 public Osoba removeLast() {
      if (prva == null) {
        return null;
      }
      if (prva.veza == null) {
        return prva;
      }
      Osoba tekuci = prva;

      while (tekuci.veza.veza != null) {
        tekuci = tekuci.veza;
      }
      Osoba last = tekuci.veza;
      tekuci.veza = null;

      return last;
    }

    public int numberOfPeopeWithLongNames(int nameLen) {
      int conut = 0;
      Osoba tekuci = prva;
      while (tekuci != null) {
        if (tekuci.name.length() >= nameLen)
          conut++;
        tekuci = tekuci.veza;
      }
      return conut;
    }
		/*public String toString() {
      String s = "Home(" + id + ") [";
      Osoba tekuci = prva;

      if (tekuci != null) {
        s += tekuci;
        tekuci = tekuci.veza;
        while (tekuci != null) {
          s += ", " + tekuci;
          tekuci = tekuci.veza;
        }
      }

      return s + "]";
    }
	*/
		class Osoba{
				String ime;
				Osoba veza;
			
			public Osoba(String ime){
				this.ime = ime;
				this.veza = null;
			}
			
			public String toString(){
				return ime;
			}
		
		}
}
