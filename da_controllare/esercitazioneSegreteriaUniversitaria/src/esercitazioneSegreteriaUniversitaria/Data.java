package esercitazioneSegreteriaUniversitaria;

import java.util.Calendar;

public class Data {

		private int giorno;
		private int mese;
		private int anno;
		
		public Data(int giorno, int mese, int anno) {
			super();
			this.giorno = giorno;
			this.mese = mese;
			this.anno = anno;
		}
		
		public int getGiorno() {
			return giorno;
		}
		public int getMese() {
			return mese;
		}
		public int getAnno() {
			return anno;
		}
		
		public int getDifference(Data data) {
			int giorniAltraData = calcolaGiorni(data);
			int giorniQuestaData = calcolaGiorni(this);
			return giorniAltraData - giorniQuestaData;
		}

		
		public static Data dataNow() {
			
			Calendar calendar = Calendar.getInstance();
			
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH);
			int year = calendar.get(Calendar.YEAR);
			
			return new Data(day,month,year);
			
		}
		private int calcolaGiorni(Data data) {
			return data.getAnno()*365 +
						data.getMese()*30+
						data.getGiorno();
		}
		
		
			
			public String toString() {
				return this.giorno + "/"+this.mese+"/"+this.anno;
				
			}
			 public static void main(String[] args) {
				 
				 System.out.println();
			 }
		}
	
