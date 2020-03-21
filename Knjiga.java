package code;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Knjiga {
	private int brojKnjige;
	private String imeKnjige;
	private boolean statusKnjige;
static ArrayList<Knjiga>knjige=  new ArrayList<Knjiga>();
private static Zapisnik zapisnik = new Zapisnik();
		public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
			if (provjeraKreacijeKnjige(brojKnjige)) {
				this.brojKnjige = brojKnjige;
				this.imeKnjige = imeKnjige;
				this.statusKnjige = statusKnjige;
				knjige.add(this);}
		System.out.println("Knjiga je uspjesno kreirana");
		
		}

private boolean provjeraKreacijeKnjige(int brojKnjige) {
			if (brojKnjige<0) {
				System.out.println("Unesite drugi broj, veci od 0");
				return false;
			}
			for (int i=0;i<knjige.size();i++) 
				if(knjige.get(i).brojKnjige==brojKnjige) {
					System.out.println("Ukucajte novi broj knjige, knjiga vec postoji");
					return false;
				}
			
			return true;
			
		}
private static boolean provjeraZaPodizanjeKnjige(int brojRacuna, int brojKnjige) {
	Racun trenutniRacun= Racun.getRacun(brojRacuna);
	if(trenutniRacun==null) {
		System.out.println("Racun nije pronadjen");
	return false;}
	Knjiga trenutnaKnjiga= Knjiga.getKnjiga(brojKnjige);
	if (trenutnaKnjiga==null) {
		System.out.println("Knjiga nije pronadjena");
		return false;
	}
	if(trenutnaKnjiga.statusKnjige) {
		System.out.println("Trazena Knjiga je vec podignuta");
		return false;
	}
	if(trenutniRacun.getBrojPosudjenihKnjiga()==3) {
		System.out.println("Vec imate 3 podignute knjige, ne mozete podignuti vise knjiga");
		return false;
	}
	return true;
}
public static void podizanjeKnjige(int brojRacuna, int brojKnjige, java.util.Date date) {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String datumPodizanjaString = dateFormat.format(date);

	if (provjeraZaPodizanjeKnjige(brojRacuna, brojKnjige)) {

		Knjiga.getKnjiga(brojKnjige).statusKnjige = true;
		Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga()+1);
		System.out.println("Knjiga je uspjesno podignuta!");

		zapisnik.zapisiPodizanjeKnjige(brojKnjige, Knjiga.getKnjiga(brojKnjige).imeKnjige, brojRacuna, Racun.getRacun(brojRacuna).getImeMusterije(), datumPodizanjaString);

	}



}



private static Knjiga getKnjiga(int brojKnjige) {

	int i = 0;

	for (i = 0; i < knjige.size(); i++)
		if (knjige.get(i).brojKnjige == brojKnjige)
			return knjige.get(i);

	return null;
}



public static void vracanjeKnjige(int brojRacuna, int brojKnjige, java.util.Date date)  {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String datumVracanjaString = dateFormat.format(date);

	if (provjeraZaVracanjeKnjige(brojRacuna, brojKnjige)) {

		Knjiga.getKnjiga(brojKnjige).statusKnjige = false;
		Racun.getRacun(brojRacuna).setBrojPosudjenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudjenihKnjiga() - 1);
		System.out.println("Knjiga je uspjesno vracena!");

		zapisnik.zapisiVracanjeKnjige(brojKnjige, Knjiga.getKnjiga(brojKnjige).imeKnjige, brojRacuna, Racun.getRacun(brojRacuna).getImeMusterije(), datumVracanjaString);

	}



}

private static boolean provjeraZaVracanjeKnjige(int brojRacuna, int brojKnjige) {

	Racun trenutniRacun = Racun.getRacun(brojRacuna);

	if (trenutniRacun == null) {
		System.out.println("Unijeti racun nije pronadjen. Knjiga nije uspjesno vracena!");
		return false;
	}

	Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);

	if (trenutnaKnjiga == null) {
		System.out.println("Trazena knjiga nije pronadjena!");
		return false;
	}

	if (!trenutnaKnjiga.statusKnjige) {
		System.out.println("Trazena knjiga nije podignuta!");
		return false;
	}

	return true;


}
}

