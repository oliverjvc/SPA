/**
     * Napisati program koji
    
        (a) ucitava cele brojeve iz fajlova p1  p2 na dva razlicita steka celih brojeva
    
        (b) sa vrha prvog steka uklanja jednocifrene brojeve
    
        (c) sa vrha drugog steka uklanja neparne brojeve 
    
       (d) spaja podatke sa dva steka u jedan novi, naizmenicnim ubacivanjem
       podataka (uzeti u obzir da stekovi ne moraju biti iste dužine)
   
       (e) ispisuje sadržaj tako dobijenog steka u fajl “pp.txt"
    *
    */

class VezbanjeZaKolokvijum{
	
	public static void snimiUFajl(Stek<Integer> s, String imef){
		while (!s.jePrazan())
		{
			int koef = s.skiniVrh();
			Svetovid.out(imef).println(koef);
		}
		Svetovid.out(imef).close();
	}
	
	public static Stek<Integer> spoji(Stek<Integer> s1, Stek<Integer> s2){
		Stek<Integer> rez = new Stek<Integer>();
		
		while(!s1.jePrazan() && !s2.jePrazan()){
				int broj = s1.skiniVrh();
				rez.stavi(broj);
				broj = s2.skiniVrh();
				rez.stavi(broj);
			}
		//ovo je ako su drugacije duzine, nzm zasto se radi bas ovako	
		while(!s1.jePrazan()){
			int broj = s1.skiniVrh();
			rez.stavi(broj);
		}
		while(!s2.jePrazan()){
			int broj = s2.skiniVrh();
			rez.stavi(broj);
		}
		
		return rez;
	}
	
	public static void ukloniNeparne(Stek<Integer> s){
		if(!s.jePrazan()){
			int br = s.vrh();
			while(br % 2 != 0 && !s.jePrazan()){
				s.skiniVrh();
				br = s.vrh();
			}
		}
	}
	
	public static void skiniJednocifrene(Stek<Integer> stekara){
		if(!stekara.jePrazan()){
			int broj = stekara.vrh();
			while(broj < 10 && broj > -10 && !stekara.jePrazan()){
					stekara.skiniVrh();
					broj = stekara.vrh();
			}
		}
	}
	
	
	
	public static Stek<Integer> ucitajIzFajla(String imef){
		Stek<Integer> rez = new Stek<>();
		if(Svetovid.testIn(imef)){
			while(!Svetovid.in(imef).isEmpty() && !rez.jePun()){
				int novi = Svetovid.in(imef).readInt();
				rez.stavi(novi);
			}
			Svetovid.in(imef).close();
		}
		return rez;
	}
	
	public static void main(String [] args){
		Stek<Integer> brojevi1 = ucitajIzFajla("nekibrojevi.txt");
		Stek<Integer> brojevi2 = ucitajIzFajla("nekibrojevi2.txt");
		
		skiniJednocifrene(brojevi1);
		ukloniNeparne(brojevi2);
	
		Stek<Integer> s3 = spoji(brojevi1, brojevi2);
		
		snimiUFajl(s3, "fajlici");
		
		System.out.println("gotovo");
	}
}
