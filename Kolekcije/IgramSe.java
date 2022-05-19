import java.util.LinkedList;
import java.util.ArrayList;


class IgramSe{
	
	public static void main(String [] args){
		Stek<String> ulice = new Stek<>();
		String str = Svetovid.in.readLine("Unesite ime ulice: ");
		while(!str.equals(".")){
			if(ulice.jePun()){
				Svetovid.out.println("nema mesta za pamcenje!");
			} else{
				ulice.stavi(str);
				}
			str = Svetovid.in.readLine("Unesite ulicu: ");
		}
		Svetovid.out.println("Rewind time");
		while(!ulice.jePrazan()){
			System.out.println("Sledeca ulica: " +ulice.skiniVrh());
		}
		
	
	}



}
