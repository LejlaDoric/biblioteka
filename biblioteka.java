package code;
import java.util.Date;
import java.util.Scanner;

public class biblioteka {

	public static void main(String[] args) {
		glavniMeni();
	}
	static Scanner input =new Scanner(System.in);

	public static void glavniMeni() {
		int inputValue=0;
		System.out.println("Unesite broj za odredjenu radnju:");
		System.out.println("\n1.Kreiranje racuna \n2.Kreiranje knjige \n3.Podizanje knjige \n4.Vracanje knjige  ");
while(true) {
	inputValue=input.nextInt();
	switch(inputValue) {
	case 1:kreiranjeRacuna();
	case 2:kreiranjeKnjige();
	case 3:podizanjeKnjige();
	case 4:vracanjeKnjige();
	
	}
}


	}
	public static void kreiranjeRacuna() {
		System.out.println("Unesite broj racuna");
		int brojRacuna=input.nextInt();
		input.nextLine();
		System.out.println("Unesite ime musterije");
		String imeMusterije=input.nextLine();
		int brojPosudjenihKnjiga=0;
		new Racun(brojRacuna,imeMusterije,brojPosudjenihKnjiga);		
		glavniMeni();}
	
	public static void kreiranjeKnjige() {
		System.out.println("Unesite broj knjige");
		int brojKnjige=input.nextInt();
		input.nextLine();
		System.out.println("Unesite ime knjige");
		String imeKnjige=input.nextLine();
		new Knjiga(brojKnjige,imeKnjige,false);
		glavniMeni();
	}
	public static void podizanjeKnjige() {
		System.out.println("Unesite vas broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		Knjiga.podizanjeKnjige(brojRacuna, brojKnjige, new Date());
		
		glavniMeni();
		
	}
	public static void vracanjeKnjige() {
	int brojRacuna=0;
	int brojKnjige=0;
	System.out.println("Unesite broj racuna");
	brojRacuna=input.nextInt();
	System.out.println("Unesite broj knjige");
	brojKnjige=input.nextInt();
	Knjiga.vracanjeKnjige(brojRacuna, brojKnjige, new Date());
	glavniMeni();	
	
	
	
	
	}
}
