import java.util.LinkedList;
import java.util.ArrayList;

class Primer{

	public static void main(String [] args){
		LinkedList<Integer> brojevi = new LinkedList<Integer>();
		
		//ucitavanje brojeva u listu
		
		for(int i = 0; i<4; i++){
			brojevi.add(Svetovid.in.readInt("Ucitati broj: "));
		}
		Svetovid.out.println(brojevi);
		
		//ispis broja koji je na 4. mestu
		
		Svetovid.out.println(brojevi.get(3));
		
		//ispis svih elemenata
		
		for(int i = 0; i < brojevi.size(); i++){
			Svetovid.out.println(brojevi.get(i) + " ");
		}
		System.out.println();
		
		//obrisati element sa indeksom / pozicijom 2
		
		int obrisan = brojevi.remove(2);
		System.out.println("Obrisani element: " + obrisan);
		
		//ispis svih elemenata
		
		for(int br: brojevi){
			System.out.print(br + " ");
		}
		System.out.println();
		
			
	}

}
