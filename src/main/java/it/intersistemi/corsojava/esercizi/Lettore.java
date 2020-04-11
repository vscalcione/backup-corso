package it.intersistemi.corsojava.esercizi;
import java.io.*;

public class Lettore {
	private static InputStreamReader a=new InputStreamReader(System.in);
	private static BufferedReader buffer=new BufferedReader(a);
	public static String leggi(){
		String letto="";
		try{
			letto=buffer.readLine();
		}
		catch(IOException e){}
		return letto;
	}
}
