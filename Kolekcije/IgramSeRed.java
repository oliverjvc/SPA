class IgramSeRed{

	public static void main(String [] args){
		int ukupno = Svetovid.in.readInt("Koliko ukupno ima takmicara");
		Red<Integer> redosled = new Red<>(ukupno);
		Svetovid.out.println("Unesite takmicare: ");
		while(!redosled.jePun()){
			int br = Svetovid.in.readInt("Sledeci: ");
			redosled.naKraj(br);
		}
		Svetovid.out.println("Takmicari: ");
		while(!redosled.jePrazan()){
			System.out.println(redosled.izbaciPrvi());
		}
	}
	

}
