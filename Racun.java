package code;

import java.util.ArrayList;

public class Racun {
	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudjenihKnjiga;
	static ArrayList<Racun> racuni= new ArrayList<Racun>();
	private boolean provjeraRacuna(int brojRacuna) {
		if (brojRacuna<0) {
			System.out.println("Broj racuna ne moze biti negativan broj");
			return false;
		}
		for (int i=0;i<racuni.size();i++) {
			if (racuni.get(i).brojRacuna==brojRacuna) {
				System.out.println("Taj broj racuna vec postoji");
				return false;
			}
				
		}
		return true;
		
	}
	public Racun (int brojRacuna, String imeMusterije,int brojPosudjenihKnjiga) {
		if (provjeraRacuna(brojRacuna)) {
			this.brojRacuna=brojRacuna;
			this.imeMusterije=imeMusterije;
			this.brojPosudjenihKnjiga=brojPosudjenihKnjiga;
			racuni.add(this);
			System.out.println("Racun je uspjeno kreiran");
			
		}
		else System.out.println("Racun nije uspjesno kreiran");
	}
public static String ispisRacuna(int brojRacuna){
		
		for (int i = 0; i < racuni.size(); i++)
			if (brojRacuna == racuni.get(i).brojRacuna) 
				return "Broj racuna: " +racuni.get(i).brojRacuna + "\nIme musterije: " + racuni.get(i).imeMusterije + "\nBroj posudjenih knjiga: " + racuni.get(i).brojPosudjenihKnjiga;
			
		return "Unijeti broj racuna ne postoji.";
}
public int getBrojPosudjenihKnjiga() {
	return brojPosudjenihKnjiga;
}
public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
	this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
}
public String getImeMusterije() {
	return imeMusterije;
}
public static Racun getRacun(int brojRacuna) {
	int i=0;
	for (i=0;i<racuni.size();i++)
		if (brojRacuna == racuni.get(i).brojRacuna) 
		return racuni.get(i);
	
	return null;
}

}
