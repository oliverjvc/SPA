import java.util.ArrayList;
import java.util.LinkedList;

class TreciZadatak{
	
	public static LinkedList<String> readListFromFile(String f){
		LinkedList<String> lista = new LinkedList<String>();
		if(!Svetovid.testIn(f)){
			return null;
		}
		while(Svetovid.in(f).hasMore()){
			String line = Svetovid.in(f).readLine();
			lista.add(line);
		}
		
		Svetovid.in(f).close();
		
		return lista;
	}
	
	public static boolean printListToFile(LinkedList<String> lista, String f){
		if(!Svetovid.testIn(f)){
			return false;
		}
		for(int i = 0; i < lista.size(); i++){
			Svetovid.out(f).println(lista.get(i));
		}
		Svetovid.out(f).close();
		return true;
	}

	public static void main(String [] args){
		ArrayList<String>  lista = new ArrayList <>();
		lista.add("Oliver");
		lista.add("Mikuta");
		lista.add("Gibo");
		lista.add("Miskovic");
		
		lista.add(1, "Jovica 2");
		
		Svetovid.out.println();

		String PrevName = lista.set(3, "Marlena");
		Svetovid.out.println("Izbacen: " + PrevName);
		Svetovid.out.println(lista);
		
		Svetovid.out.println();

		for(int i = 0; i< lista.size(); i += 2){
			Svetovid.out.println(lista.get(i));
		}
		
		lista.remove(2);
		Svetovid.out.println(lista);
		
		Svetovid.out.println();
		for(String item: lista){
			if(item.startsWith("S"))
			Svetovid.out.println(item);
		}
		
		System.out.println();
		String s = Svetovid.in.readLine("Unesite string koji hocete da izbacite");
		lista.remove(s);
		Svetovid.out.println(lista);
		
		System.out.println();
		
		LinkedList<String> ListFromFile = readListFromFile("Imena.txt");
		Svetovid.out.println(ListFromFile);
		
		/*for(String string: lista){
			ListFromFile.add(string);
		}
		* */
		
		for(int i = 0; i < lista.size(); i++){
			ListFromFile.add(lista.get(i));
		}
		System.out.println();
		Svetovid.out.println(ListFromFile);
		
		printListToFile(ListFromFile, "randomimena2.txt");
	}
}
