package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Pagamento {

	float prezzo = 0;
	
	public static float calcolaPrezzo(float ratio, String price, String assicurazione, long durata) {
		System.out.println("calcolaprezzo: " + (Float.parseFloat(price)));
		System.out.println("durata: " + durata);
		switch(assicurazione) {
		
		case "Assicurazione Casco":
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 20) * durata;
			
			
		case "Assicurazione Normale":
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 0) * durata;
			
		
		default:
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 0) * durata;
		
		} 
	}
	
	public static float calcolaPrezzo(float ratio, String price, String assicurazione, String dataInizio, String dataFine) {
		 SimpleDateFormat forma=new SimpleDateFormat("dd/MM/yyyy"); 
		long durata = 0;;
		try {
			durata = TimeUnit.DAYS.convert((forma.parse(dataFine).getTime() - forma.parse(dataInizio).getTime()), TimeUnit.MILLISECONDS);
			System.out.println(durata);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(assicurazione) {

		case "Assicurazione Casco":
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 20) * durata;
		case "Assicurazione Normale":
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 0) * durata;
		default:
			return (Float.parseFloat(price) + (Float.parseFloat(price) * ratio) + 0) * durata;
		}
	}
	
	public boolean pagamento(String carta, String ccv, String data) {
		return false;
	}
}
