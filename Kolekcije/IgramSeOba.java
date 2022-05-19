class IgramSeOba{

	public static void main(String [] args){
		
		String s = "0123456789";
		
		Stek<Character> stk = new Stek<>(s.length());
		
		for(int i=0; i<s.length(); i++){
			stk.stavi(s.charAt(i));
		}
		
		Red<Character> rd = new Red<>(s.length());
		
		for(int i=0; i<s.length(); i++){
			rd.naKraj(s.charAt(i));
		}
		
		System.out.println("- Print steka -");
		while(!stk.jePrazan()){
			System.out.print(stk.skiniVrh());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("- Print reda -");
		while(!rd.jePrazan()){
			System.out.print(rd.izbaciPrvi());
		}
	}



}
