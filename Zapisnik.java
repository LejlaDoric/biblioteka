package code;

public class Zapisnik {

		private static String zapisnikString="";
		
		protected void zapisiPodizanjeKnjige(int brojKnjige,String imeKnjige,int brojRacuna, String imeMusterije,String datumPodizanja) {
			zapisnikString+="Podizanje knjige: "+imeMusterije+brojKnjige+"Racun: "+imeKnjige+brojRacuna+"Datum: "+ datumPodizanja;
		}
		protected void zapisiVracanjeKnjige(int brojKnjige,String imeKnjige,int brojRacuna, String imeMusterije,String datumVracanja) {
			zapisnikString+="Vracanje knjige: "+imeMusterije+brojKnjige+"Racun: "+imeKnjige+brojRacuna+"Datum: "+ datumVracanja;
		}
		
		public static String ispisiZapisnik() {
			return zapisnikString;
		}
		
		
}
