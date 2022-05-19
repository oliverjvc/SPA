import java.util.LinkedList;
import java.util.ArrayList;

class TreciZadatakOpet{
	
	public static void main(String [] args){
			
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Miljana");
		list.add("Marlena");
		list.add("Ivana");
		list.add("Nina");
		
		Svetovid.out.println(list);
		System.out.println();
		
		String s = list.set(3, "Neko drugi");
		Svetovid.out.println(s);
		System.out.println();
		Svetovid.out.println(list);
		
		System.out.println();
		
		for(int i = 0; i < list.size(); i += 2){
			Svetovid.out.println(list.get(i));
		}
		
		System.out.println();
		
		boolean nadjen = false;
		for(String item: list){
			if(item.startsWith("S")){
				Svetovid.out.println(item);
				nadjen = true;
			}
		}
		if(!nadjen){
			Svetovid.out.println("Nije nadjeno ime sa slovom S");
		}
		
		list.remove(2);
		System.out.println();
		Svetovid.out.println(list);
		
		String RemoveName = Svetovid.in.readLine("Unesite ime koje hocete da uklonite");
		list.remove(RemoveName);
		
		System.out.println();
		Svetovid.out.println(list);
		
		
		
		LinkedList<String> listFromFile = readListFromFile("imena.txt");
		Svetovid.out.println(listFromFile);
		
		for(int i = 0; i < list.size(); i++){
		listFromFile.add(list.get(i));
			
		}
		
		System.out.println();
		Svetovid.out.println(listFromFile);
		
		printListToFile(listFromFile, "randome.txt");
		
		
		
		
		
		
		
		///zasto nece da radi ovaj ispis
		//IspisZajebavamSe(list);
		
		
	}

	/*public void IspisZajebavamSe(ArrayList<String> list){
		for(int i = 0; i > list.size(); i+=2){
			Svetovid.out.println(list.get(i));
		}
	}
	*/
	
	public static LinkedList<String> readListFromFile(String f){
		LinkedList<String> list = new LinkedList<>();
		if(!Svetovid.testIn(f)){
			return null;
		}
		while(Svetovid.in(f).hasMore()){
			String line = Svetovid.in(f).readLine();
			list.add(line); 
		}
		return list;
	}
	
	public static boolean printListToFile(LinkedList<String> list, String f){
		if(!Svetovid.testIn(f)){
			return false;
		}
		for(int i = 0; i < list.size(); i++){
			Svetovid.out(f).println(list.get(i));
		}
		//AKO NE ZATVORIS NECE GA IZPRINTAT
		Svetovid.out(f).close();
		return true;
			
	}
}
	

